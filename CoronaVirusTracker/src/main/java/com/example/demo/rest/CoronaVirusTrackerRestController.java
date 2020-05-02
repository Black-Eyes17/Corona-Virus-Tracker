package com.example.demo.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ConfirmedCoronaCase;
import com.example.demo.dto.CoronaCaseData;
import com.example.demo.dto.DeathCoronaCase;
import com.example.demo.dto.RecoveredCoronaCase;
import com.example.demo.service.CoronaVirusTrackerService;

@RestController
public class CoronaVirusTrackerRestController {

	@Autowired
	CoronaVirusTrackerService coronaVirusTrackerService;
	
	@GetMapping("/confirmedCoronaCase")
	public List<ConfirmedCoronaCase> retirveLatestCoronaVirusConfirmedCaseDetails() throws IOException {
		
		return coronaVirusTrackerService.getConfirmedCoronaCase();
	}
	
	@GetMapping("/deathCoronaCase")
	public List<DeathCoronaCase> retrieveLatestCoronaVirusDeathDetails() throws IOException{
		return coronaVirusTrackerService.getDeathCoronaCase();
	}
	
	@GetMapping("/recoveredCoronaCase")
	public List<RecoveredCoronaCase> retrieveLatestCoronaVirusRecoveredDetails() throws IOException{
		return coronaVirusTrackerService.getRecoveredCoronaCase();
	}
	
	@GetMapping("/completeCoronaCase")
	public List<CoronaCaseData> retrieveLatestCoronaVrusData() throws IOException{
		return coronaVirusTrackerService.getCoronaCaseData();
	}
}
