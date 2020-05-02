package com.example.demo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ConfirmedCoronaCase;
import com.example.demo.dto.CoronaCase;
import com.example.demo.dto.CoronaCaseData;
import com.example.demo.dto.DeathCoronaCase;
import com.example.demo.dto.RecoveredCoronaCase;
import com.example.demo.enums.HeaderEnum;
import com.example.demo.service.CoronaVirusTrackerService;
import com.example.demo.util.InputStreamProcessing;

@Service
public class CoronaVirusTrackerServiceImpl implements CoronaVirusTrackerService{
	
	private static String confirmedCasesURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	private static String deathCasesURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
	
	private static String recoveredCasesURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
	
	@Autowired
	private InputStreamProcessing inputStreamProcessing;
	
	@Override
	public List<CoronaCase> getCoronaVirusDetails(URL coronaUrl) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) coronaUrl.openConnection();
		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			InputStream inputStream = connection.getInputStream();
			StringReader response = new StringReader(inputStreamProcessing.processInputStream(inputStream));
			Iterable<CSVRecord> data = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(response);
			List<CoronaCase> coronaCaseList = new ArrayList<CoronaCase>();
			for(CSVRecord record : data) {
				CoronaCase coronaCase = new CoronaCase();
				coronaCase.setState(record.get(HeaderEnum.ConfirmedCoronaCaseEnum.ProvinceOrStreet.getHeader()));
				coronaCase.setCountry(record.get(HeaderEnum.ConfirmedCoronaCaseEnum.CountryOrRegion.getHeader()));
				coronaCase.setLatestCases(Integer.parseInt(record.get(record.size()-1)));
				coronaCaseList.add(coronaCase);
			}
			return coronaCaseList;
		}
		return null;
	}

	@Override
	public List<ConfirmedCoronaCase> getConfirmedCoronaCase() throws IOException{
		URL confirmedCoronaCasesUrl = new URL(confirmedCasesURL);
		List<ConfirmedCoronaCase> confirmedCoronaCaseList = new ArrayList<ConfirmedCoronaCase>();
		for(CoronaCase coronaCase : this.getCoronaVirusDetails(confirmedCoronaCasesUrl)){
			ConfirmedCoronaCase confirmedCoronaCase = new ConfirmedCoronaCase();
			confirmedCoronaCase.setState(coronaCase.getState());
			confirmedCoronaCase.setCountry(coronaCase.getCountry());
			confirmedCoronaCase.setLatestConfirmedCases(coronaCase.getLatestCases());
			confirmedCoronaCaseList.add(confirmedCoronaCase);
		}
		return confirmedCoronaCaseList;
	}
	
	@Override
	public List<DeathCoronaCase> getDeathCoronaCase() throws IOException{
		URL deathCoronaCasesUrl = new URL(deathCasesURL);
		List<DeathCoronaCase> deathCoronaCaseList = new ArrayList<DeathCoronaCase>();
		for(CoronaCase coronaCase : this.getCoronaVirusDetails(deathCoronaCasesUrl)){
			DeathCoronaCase deathCoronaCase = new DeathCoronaCase();
			deathCoronaCase.setState(coronaCase.getState());
			deathCoronaCase.setCountry(coronaCase.getCountry());
			deathCoronaCase.setLatestDeathCases(coronaCase.getLatestCases());
			deathCoronaCaseList.add(deathCoronaCase);
		}
		return deathCoronaCaseList;
	}

	@Override
	public List<RecoveredCoronaCase> getRecoveredCoronaCase() throws IOException{
		URL recoveredCoronaCasesUrl = new URL(recoveredCasesURL);
		List<RecoveredCoronaCase> recoveredCoronaCaseList = new ArrayList<RecoveredCoronaCase>();
		for(CoronaCase coronaCase : this.getCoronaVirusDetails(recoveredCoronaCasesUrl)){
			RecoveredCoronaCase recoveredCoronaCase = new RecoveredCoronaCase();
			recoveredCoronaCase.setState(coronaCase.getState());
			recoveredCoronaCase.setCountry(coronaCase.getCountry());
			recoveredCoronaCase.setLatestRecoveredCases(coronaCase.getLatestCases());
			recoveredCoronaCaseList.add(recoveredCoronaCase);
		}
		return recoveredCoronaCaseList;
	}
	
	public List<CoronaCaseData> getCoronaCaseData() throws IOException{
		List<ConfirmedCoronaCase> confirmedCases = this.getConfirmedCoronaCase();
		List<RecoveredCoronaCase> recoveredCases = this.getRecoveredCoronaCase();
		List<DeathCoronaCase> deathCases = this.getDeathCoronaCase();
		List<CoronaCaseData> coronaCaseDataList = new ArrayList<CoronaCaseData>();
		for(int i=0; i<250; i++) {
			CoronaCaseData coronaCaseData = new CoronaCaseData();
			coronaCaseData.setState(confirmedCases.get(i).getState());
			coronaCaseData.setCountry(confirmedCases.get(i).getCountry());
			coronaCaseData.setLatestConfirmedCases(confirmedCases.get(i).getLatestConfirmedCases());
			coronaCaseData.setLatestRecoveredCases(recoveredCases.get(i).getLatestRecoveredCases());
			coronaCaseData.setLatestDeathCases(deathCases.get(i).getLatestDeathCases());
			coronaCaseDataList.add(coronaCaseData);
		}
		return coronaCaseDataList;
	}
	
}
