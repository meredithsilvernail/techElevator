package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.FavoriteThings;

@Controller
@RequestMapping("/FavoriteThings")
@SessionAttributes("favoriteThings")
public class FavoriteThingsController {

	@RequestMapping(path = "/Page1", method = RequestMethod.GET)
	public String getPage1(ModelMap map) {
		map.addAttribute("favoriteThings", new FavoriteThings());
		return "page1";
	}

	@RequestMapping(path = "/Page1", method = RequestMethod.POST)
	public String postPage1(@RequestParam String favoriteColor, ModelMap map) {
		FavoriteThings favoriteThings = getFavoriteThings(map);
		favoriteThings.setFavoriteColor(favoriteColor);
		return "redirect:Page2";
	}

	@RequestMapping(path = "/Page2", method = RequestMethod.GET)
	public String getPage2() {
		return "page2";
	}

	@RequestMapping(path = "/Page2", method = RequestMethod.POST)
	public String postPage2(@RequestParam String favoriteFood, ModelMap map) {
		FavoriteThings favoriteThings = getFavoriteThings(map);
		favoriteThings.setFavoriteFood(favoriteFood);
		return "redirect:Page3";
	}

	@RequestMapping(path = "/Page3", method = RequestMethod.GET)
	public String getPage3() {
		return "page3";
	}

	@RequestMapping(path = "/Page3", method = RequestMethod.POST)
	public String postPage3(@RequestParam String favoriteSeason, ModelMap map) {
		FavoriteThings favoriteThings = getFavoriteThings(map);
		favoriteThings.setFavoriteSeason(favoriteSeason);
		return "redirect:Summary";
	}

	@RequestMapping(path = "/Summary", method = RequestMethod.GET)
	public String getSummary() {
		return "summary";
	}

	private FavoriteThings getFavoriteThings(ModelMap map) {

		return (FavoriteThings) map.get("favoriteThings");
	}
}
