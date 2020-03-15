package com.techelevator.fbn.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.fbn.model.CheckingAccountApplication;

@Controller
@RequestMapping("/checkingApplication")
public class CheckingApplicationController {

	@RequestMapping(path = { "/", "/personalInformationInput" }, method = RequestMethod.GET)
	public String displayPersonalInformationInput() {
		return "checkingApplication/personalInformationInput";
	}

	/* 1) 
	 * - Create a POST mapping to /personalInformationInput
	 * - Account for all the fields on the originating form.
	 * - Bring in a HttpSession object
	 * - Instantiate an object of CheckingAccountApplication with
	 * the incoming form data.
	 * - Add the instance of CheckingAccountApplication to the 
	 * HttpSession object.
	 * - Redirect to /checkingApplication/addressInput
	 */
	
	/*2)
	 * - Send the user to addressInput.jsp
	 */

	/*3)
	 * - Create an a POST mapping to /addressInput
	 * - Account for all the fields on the originating form.
	 * - Instantiate an object of CheckingAccountApplication with
	 * the incoming form data.
	 * - Bring in a HttpSession object
	 * - Extract the existing CheckingAccountApplication session data
	 * - Set the address data into the CheckingAccountApplication object. 
	 * - Redirect to redirect:/checkingApplication/summary
	 */

	/* 4)
	 * Send the user to summary.jsp
	 */

	/* 5)
	 * - Create an a POST mapping to /completeApplication
	 * - Bring in a HttpSession object
	 * - Extract the existing CheckingAccountApplication session data
	 * - Redirect the user to /checkingApplication/thankYou
	 */

	/* 6)
	 * - Send the user to thankYou.jsp
	 */
}
