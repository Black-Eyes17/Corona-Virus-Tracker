package com.example.demo.dto;

public class CoronaCaseData {
	private String state;
	private String country;
	private int latestConfirmedCases;
	private int latestRecoveredCases;
	private int latestDeathCases;
	
	public String getState() {
		return state;
	}
	public int getLatestConfirmedCases() {
		return latestConfirmedCases;
	}
	public void setLatestConfirmedCases(int latestConfirmedCases) {
		this.latestConfirmedCases = latestConfirmedCases;
	}
	public int getLatestRecoveredCases() {
		return latestRecoveredCases;
	}
	public void setLatestRecoveredCases(int latestRecoveredCases) {
		this.latestRecoveredCases = latestRecoveredCases;
	}
	public int getLatestDeathCases() {
		return latestDeathCases;
	}
	public void setLatestDeathCases(int latestDeathCases) {
		this.latestDeathCases = latestDeathCases;
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

}
