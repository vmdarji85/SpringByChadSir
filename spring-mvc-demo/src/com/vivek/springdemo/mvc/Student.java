package com.vivek.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	//private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	private String[] operatingSystems;
	
	
	public Student () {
//		countryOptions = new LinkedHashMap<>();
//		
//		countryOptions.put("IND", "India");
//		countryOptions.put("USA", "United States Of America");
//		countryOptions.put("SA", "South Afrca");
//		countryOptions.put("AUS", "Australia");
//		countryOptions.put("ENG", "ENGLAND");
		
		favoriteLanguageOptions = new LinkedHashMap<>();
		
		favoriteLanguageOptions.put("Java", "java");
		favoriteLanguageOptions.put("Python", "python");
		favoriteLanguageOptions.put("Scala", "scala");
		favoriteLanguageOptions.put("C#", "c#");
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	

//	public LinkedHashMap<String, String> getCountryOptions() {
//		return countryOptions;
//	}
	
	
	
	
	
	
	
	
}
