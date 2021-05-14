package com.github.sats17.cachebucketdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sats17.cachebucketdemo.model.Dump;
import com.github.sats17.cachebucketdemo.service.DataFetchService;

@RestController
@RequestMapping("/api")
public class DataFetchController {
	
	@Autowired
	public DataFetchService dataFetchService;
	
	@GetMapping("/uuid")
	public List<Dump> getAllUuid() {
		
		return dataFetchService.fetchAllDumps("/api/uuid");
	}

}
