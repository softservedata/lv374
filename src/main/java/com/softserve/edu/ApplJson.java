package com.softserve.edu;

import com.google.gson.Gson;

public class ApplJson {

	public static void main(String[] args) {
		Gson gson = new Gson();
		String json = "{\"id\":101,\"name\":\"name1\"}";
		System.out.println("Base JSON: " + json);
		UserJson userJson = gson.fromJson(json, UserJson.class);
		System.out.println("UserJson: " + userJson);
		//
		//json = "{\"content\":[\"URL=/reset, method=GET resetServiceToInitialState\",\"URL=/item/{index}, method=GET getItem, PARAMETERS= token, index\"]}";
		json = "{\"content\":[\"URL1\",\"URL2\"]}";
		RestResultJson restResultJson = gson.fromJson(json, RestResultJson.class);
		System.out.println("RestResultJson: " + restResultJson);
	}
	
}
