package com.example.demo.dto;

public class ConfirmedCoronaCase {

	private String state;
	private String country;
	private int latestConfirmedCases;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestConfirmedCases() {
		return latestConfirmedCases;
	}
	public void setLatestConfirmedCases(int latestConfirmedCases) {
		this.latestConfirmedCases = latestConfirmedCases;
	}
	
	
}
