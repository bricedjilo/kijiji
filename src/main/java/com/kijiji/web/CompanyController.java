package com.kijiji.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kijiji.domain.Login;
import com.kijiji.phantomjs.PhantomJSDemo;
import com.kijiji.utility.JsonIO;
import com.kijiji.utility.KijijiScreenShot;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private Login login;
	private JsonIO jsonIO;
	
	@Autowired
	public void setLogin(Login login) {
		this.login = login;
	}
	
	@Autowired
	public void setJsonIO(JsonIO jsonIO) {
		this.jsonIO = jsonIO;
	}

	// Insert a new Company
//	@RequestMapping(value = "/pd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void create(@RequestBody Company company) {
//		companyService.create(company);
//	}

//	// Update a Company's info
//	@RequestMapping(value = "/update/{compId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void update(@RequestBody Company company, @PathVariable int compId) {
//		companyService.update(compId, company);
//	}
//
//	// delete a Company object
//	@RequestMapping(value = "/delete/{compId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void update(@PathVariable int compId) {
//		companyService.delete(compId);
//	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String login() {
		return login.accessKijiji("waza.tech@yahoo.ca", "isaro2015", "https://www.kijiji.ca/t-login.html");
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject readItem() {
		Map<String, String> map = new HashMap<>();
		map.put(new String("test"), new String("test"));
		
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject = jsonIO.getJsonObjectFromFile("files/links.JSON");
			return jsonObject;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (new JSONObject(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (new JSONObject(map));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (new JSONObject(map));
		}
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
//	// Find companies by name
//	@RequestMapping(value = "/name/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<Map<String, String>> getCompanyByName(@PathVariable String companyName) {
//		return companyService.getCompanyByName(companyName);
//	}
//
//	// query 3
//	@RequestMapping(value = "/laborcost", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<Map<String, String>> getCompaniesLaborCost() {
//		return companyService.getCompaniesLaborCost();
//	}
//
//	// query 3.1
//	@RequestMapping(value = "/laborcost/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<Map<String, String>> getCompanysLaborCost(@PathVariable String companyName) {
//		return companyService.getCompanysLaborCost(companyName);
//	}

}
