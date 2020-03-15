package com.techelevator;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;

    /* What request mapping do we want here */
    @RequestMapping (path="/searchCustomers", method = RequestMethod.GET)
    public String showSearchCustomerForm() {

        return "customerList";
    }

    /* What about here? */
    @RequestMapping (path="/searchCustomers", method = RequestMethod.POST)
    public String searchCustomers(/* What arguments go here to get parameters from the page? */
            @RequestParam String searchName, String sortOption, ModelMap modelMap) {
        /* Call the model and pass values to the jsp */

        List<Customer> customers = customerDao.searchAndSortCustomers(searchName, sortOption);

        modelMap.put("customers", customers);

        return "customerList";
    }

}