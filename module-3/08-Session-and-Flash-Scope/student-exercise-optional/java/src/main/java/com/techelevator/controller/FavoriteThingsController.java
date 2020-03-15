package com.techelevator.controller;

import com.techelevator.model.FavoriteThings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/FavoriteThings")
public class FavoriteThingsController {

	@RequestMapping(path = {"/", "/page1"}, method = RequestMethod.GET)
	public String getPage1(ModelMap map) {
		return "page1";
	}

	@RequestMapping(path = "/page1", method = RequestMethod.POST)
	public String savePage1(ModelMap map, HttpSession session, @RequestParam String favoriteColor){
		FavoriteThings things = new FavoriteThings();
		things.setFavoriteColor(favoriteColor);

		session.setAttribute("favorites", things );

		return "page2";
	}

	@RequestMapping (path = "/page2", method = RequestMethod.GET)
	public String getPage2(ModelMap map){
		return "page2";
	}

	@RequestMapping (path = "/page2", method = RequestMethod.POST)
	public String savePage2(ModelMap map, HttpSession session, @RequestParam String favoriteFood){
		FavoriteThings things = (FavoriteThings) session.getAttribute("favorites");

		things.setFavoriteFood(favoriteFood);

		return "page3";

	}

	@RequestMapping (path = "/page3", method = RequestMethod.GET)
	public String getPage3(ModelMap map){

		return "page3";
	}

	@RequestMapping (path = "/page3", method = RequestMethod.POST)
	public String savePage3(ModelMap map, HttpSession session, @RequestParam String season){
		FavoriteThings things = (FavoriteThings) session.getAttribute("favorites");

		things.setFavoriteFood(season);

		return "summary";
	}

	@RequestMapping(path = "/summary", method = RequestMethod.GET)
	public String getSummary(ModelMap map){
		return "summary";
	}

}
