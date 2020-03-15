package com.techelevator;

import com.techelevator.exceptions.DataAccessException;
import com.techelevator.log.Logger;
import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.entity.City;
import com.techelevator.dao.CityDAO;
import com.techelevator.dao.CityDaoJDBC;

import javax.sql.DataSource;
import java.util.List;

public class Driver {

	public static void main(String[] args) {

		try {
			Logger.openLogger();
		} catch (DataAccessException ex){
			System.exit(1);
		}

		CityDAO dao = null;
		try {
			dao = new CityDaoJDBC( getDataSource() );
		} catch (DataAccessException ex){
			System.exit(1);
		}

//		City city = dao.findCityById(50);
//		System.out.println(city);
//
//		List<City> cities = dao.findCityByCountryCode("USA");
//		for(City theCity : cities){
//			System.out.println(theCity);
//		}
		
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville);
		
		City theCity = dao.findCityById(smallville.getId());

		System.out.println(theCity);

		dao.delete(theCity.getId());

		theCity = dao.findCityById(smallville.getId());
		if (theCity == null){
			System.out.println("theCity successfully deleted!");
		}

		Logger.closeLogger();
	}

	public static DataSource getDataSource() {
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		return worldDataSource;
	}

}
