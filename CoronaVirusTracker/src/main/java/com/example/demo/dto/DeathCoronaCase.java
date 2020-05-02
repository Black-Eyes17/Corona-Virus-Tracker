package com.example.demo.dto;

public class DeathCoronaCase {
	private String state;
	private String country;
	private int latestDeathCases;
	
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
	public int getLatestDeathCases() {
		return latestDeathCases;
	}
	public void setLatestDeathCases(int latestDeathCases) {
		this.latestDeathCases = latestDeathCases;
	}
}
