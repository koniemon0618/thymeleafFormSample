package com.example.demo;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class Controller {
	@RequestMapping(value = { "/selectOptionExample2" }, method = RequestMethod.GET)
	public String selectOptionExample2Page(Model model) {
	 
	    PersonForm form = new PersonForm();
	    model.addAttribute("personForm", form);
	 
	    // Long: countryId
	    // String: countryName
	    Map<Long, String> mapCountries = CountryDAO.getMapCountries();
	    model.addAttribute("mapCountries", mapCountries);
	 
	    return "selectOptionExample2";
	}

}
