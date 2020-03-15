package com.techelevator.dao;

import com.techelevator.entity.City;
import com.techelevator.exceptions.DataAccessException;
import com.techelevator.log.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDAO {

    private JdbcTemplate jdbcTemplate;

    public CityDaoJDBC(DataSource dataSource) throws DataAccessException {
        try {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception ex) {
            Logger.logTimeStampedMessage(ex.getMessage());
            throw new DataAccessException(ex.getMessage());
        }
    }

    @Override
    public City findCityById(long id) {

        String sqlFindCityById =
                "SELECT id, name, countrycode, district, population " +
                        "FROM city " +
                        "WHERE id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
        if (results.next()) {
            return mapRowToCity(results);
        }
        return null;
    }

    @Override
    public List<City> findCityByCountryCode(String countryCode) {

        String sqlFindCityByCountryCode =
                "SELECT id, name, countrycode, district, population " +
                        "FROM city " +
                        "WHERE countrycode = ?";

        ArrayList<City> cities = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
        while (results.next()) {
            cities.add(mapRowToCity(results));
        }
        return cities;
    }

    @Override
    public List<City> findCityByDistrict(String district) {

        return null;
    }

    @Override
    public void save(City city) {

        String sqlInsertCity =
                "INSERT INTO city(id, name, countrycode, district, population) " +
                        "VALUES(?, ?, ?, ?, ?)";
        try {
            city.setId(getNextCityId());
            jdbcTemplate.update(sqlInsertCity,
                    city.getId(),
                    city.getName(),
                    city.getCountryCode(),
                    city.getDistrict(),
                    city.getPopulation());
            Logger.logTimeStampedMessage("insert success: " + city);
        } catch (Exception ex){
            Logger.logTimeStampedMessage(ex.getMessage());
        }
    }

    @Override
    public void update(City city) {
    }

    @Override
    public void delete(long id) {

        String sqlDeleteCity =
                "DELETE FROM city WHERE id=?";
        try {
            Object[] params = {id};
            jdbcTemplate.update(sqlDeleteCity, params);
            Logger.logTimeStampedMessage("delete success: " + id);
        } catch (Exception ex){
            Logger.logTimeStampedMessage(ex.getMessage());
        }
    }

    private long getNextCityId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");

        if (nextIdResult.next()) {
            return nextIdResult.getLong(1);
        } else {
            throw new DataAccessException("Something went wrong while getting an id for the new city");
        }
    }

    private City mapRowToCity(SqlRowSet results) {
        return new City(
                results.getLong("id"),
                results.getString("name"),
                results.getString("countrycode"),
                results.getString("district"),
                results.getInt("population"));
    }
}
