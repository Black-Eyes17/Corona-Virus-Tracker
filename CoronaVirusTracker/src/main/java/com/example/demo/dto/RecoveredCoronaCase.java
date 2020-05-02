package com.example.demo.dto;

public class RecoveredCoronaCase {
	private String state;
	private String country;
	private int latestRecoveredCases;
	
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
	public int getLatestRecoveredCases() {
		return latestRecoveredCases;
	}
	public void setLatestRecoveredCases(int latestRecoveredCases) {
		this.latestRecoveredCases = latestRecoveredCases;
	}
}
