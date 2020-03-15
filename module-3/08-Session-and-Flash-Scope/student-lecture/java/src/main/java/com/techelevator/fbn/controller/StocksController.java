package com.techelevator.fbn.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.fbn.model.DollarAmount;
import com.techelevator.fbn.model.Stock;

@Controller
@SessionAttributes("stocks")
public class StocksController {
	@RequestMapping(path = { "/stocks" }, method = RequestMethod.GET)
	public String showStocksPage(ModelMap map) {
		List<Stock> stocks = getStocks();

		map.put("stocks", stocks);

		return "stocks/stocksLandingPage";
	}

	/* 1.
	 * - Create a GET mapping to /stockPurchase
	 * - Send the user to stocksPurchasePage.jsp
	 */

	/*
	 * 2.
	 * - Create a POST mapping to /stockPurchase
	 * - Bring in the ticker and shares from the form
	 * - Bring in a RedirectAttributes object.
	 * - Add three redirect attributes: 
	 * - 1) Time Stamp
	 * - 2) Shares Bought
	 * - 3) Ticker Symbol
	 * - Redirect to /stocksConfirmation
	 */

	    
	/* 3.
	 * Send the user to stocksConfirmationPage.jsp
	 */

	private List<Stock> getStocks() {
		List<Stock> stocks = new ArrayList<Stock>();
		Resource res = new ClassPathResource("stockData.txt");

		try (Scanner inputScanner = new Scanner(res.getFile())){

			while (inputScanner.hasNextLine()) {
				Stock stock = new Stock();

				String line = inputScanner.nextLine();
				String[] nameParts = line.split("\"");

				stock.setTicker(nameParts[1]);
				stock.setName(nameParts[3]);
								
				String[] priceAndChange = nameParts[4].split("\\s+");
				
				String[] priceString = priceAndChange[0].split("\\.");
				int dollars = Integer.parseInt(priceString[0]);
				int cents = Integer.parseInt(priceString[1].substring(0, 2));
				DollarAmount price = new DollarAmount(dollars * 100 + cents);
				stock.setPrice(price);				
				
				float change = Float.parseFloat(priceAndChange[1]);
				stock.setChange(change);

				stocks.add(stock);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stocks;
	}
}
