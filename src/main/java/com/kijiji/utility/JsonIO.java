package com.kijiji.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("jsonIO")
public class JsonIO {
	
	private JSONObject jsonObject;
	private JSONParser parser;

//	@Autowired
//	public void setParser(JSONParser parser) {
//		this.parser = parser;
//	}

	public JsonIO() {
	}

//	@Autowired
//	public void setJsonObject(JSONObject jsonObject) {
//		this.jsonObject = jsonObject;
//	}
	
	public JSONObject getJsonObjectFromFile(String filePath) throws FileNotFoundException, IOException, ParseException {
		parser = new JSONParser();
		File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
//		Scanner scan = new Scanner(file);
//		System.out.println(scan.nextLine() +" ========= Next Line");
//		return null;
		return ((JSONObject)parser.parse(new FileReader(file)));
	}
	
}
