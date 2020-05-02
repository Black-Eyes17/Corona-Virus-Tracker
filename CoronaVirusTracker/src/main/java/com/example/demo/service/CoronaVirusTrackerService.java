package com.example.demo.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.example.demo.dto.ConfirmedCoronaCase;
import com.example.demo.dto.CoronaCase;
import com.example.demo.dto.CoronaCaseData;
import com.example.demo.dto.DeathCoronaCase;
import com.example.demo.dto.RecoveredCoronaCase;

public interface CoronaVirusTrackerService {

	public List<CoronaCase> getCoronaVirusDetails(URL coronaURL) throws IOException;
	
	public List<ConfirmedCoronaCase> getConfirmedCoronaCase() throws IOException;
	
	public List<DeathCoronaCase> getDeathCoronaCase() throws IOException;

	public List<RecoveredCoronaCase> getRecoveredCoronaCase() throws IOException;
	
	public List<CoronaCaseData> getCoronaCaseData() throws IOException;
}
