package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping(path="/searchFilmForm", method = RequestMethod.GET)
    public String showFilmSearchForm() {


        return "filmList";
    }

    @RequestMapping(path="/searchFilmForm", method = RequestMethod.POST)
    public String searchFilms(@RequestParam int minLength, @RequestParam int maxLength,
                              @RequestParam String genre, ModelMap modelMap) {

        List<Film> films = filmDao.getFilmsBetween(genre, minLength, maxLength);
        modelMap.put("films", films);

        return "filmList";
    }

}