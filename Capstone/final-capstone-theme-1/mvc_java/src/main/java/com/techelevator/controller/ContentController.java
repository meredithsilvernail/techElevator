package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(path="/user")
public class ContentController {

	public ContentController(){
	}

	@RequestMapping(path="/breweries", method=RequestMethod.GET)
	public String displayBreweries() {
		return "home/breweries";
	}

	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String displayDashboard() {
		return "dashboard";
	}

	@RequestMapping(path="/search", method=RequestMethod.GET)
	public String displaySearchResults() {
		return "searchResults";
	}

	@RequestMapping(path="/blank", method=RequestMethod.GET)
	public String displayBlankPage() {

		return "blank";
	}

	@RequestMapping(path="/404", method=RequestMethod.GET)
	public String displayBadPage() {

		return "404";
	}

	@RequestMapping(path="/basic/table", method=RequestMethod.GET)
	public String displayBasicTable() {

		return "basicTableExample";
	}

	@RequestMapping(path="/rest/table", method=RequestMethod.GET)
	public String displayRestTable() {

		return "restTableExample";
	}

	@RequestMapping(path="/buttons", method=RequestMethod.GET)
	public String displayButtons() {

		return "buttons";
	}

	@RequestMapping(path="/cards", method=RequestMethod.GET)
	public String displayCards() {

		return "cards";
	}

	@RequestMapping(path="/charts", method=RequestMethod.GET)
	public String displayCharts() {

		return "charts";
	}
	
}
