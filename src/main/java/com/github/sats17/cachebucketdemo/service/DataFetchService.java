package com.github.sats17.cachebucketdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sats17.cache.extern.CacheBucket;
import com.github.sats17.cache.internal.services.BucketController;
import com.github.sats17.cachebucketdemo.dao.Dumping;
import com.github.sats17.cachebucketdemo.model.Dump;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DataFetchService {

	@Autowired
	Dumping dumpings;
	
	CacheBucket bucket = new BucketController(10, 8000);
	
	@SuppressWarnings("unchecked")
	public List<Dump> fetchAllDumps(String path) {
		Object cache = bucket.getCache(path);
		if(cache == null) {
			log.info("Missed cache, fetching data from DB");
			return fetchFromDBAndStoreInCache(path);
		}
		log.info("Data fetched from cache");
		return (List<Dump>) cache;
	}
	
	@SuppressWarnings("unused")
	private List<Dump> fetchFromDBAndStoreInCache(String path) {
		long count = dumpings.count();
		List<Dump> list = new ArrayList<>();
		for (int i = 1; i <= count; i++) {
			dumpings.findById(i).ifPresent(t -> list.add(t));
		}
		bucket.setCache(path, list);
		return list;
	}
}
