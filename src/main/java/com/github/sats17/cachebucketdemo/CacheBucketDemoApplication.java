package com.github.sats17.cachebucketdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.sats17.cachebucketdemo.dao.Dumping;
import com.github.sats17.cachebucketdemo.model.Dump;

@SpringBootApplication
public class CacheBucketDemoApplication {
	
	@Autowired
	Dumping dumping;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CacheBucketDemoApplication.class, args);
	}
	
	@Bean
	public void dumper() {
		Dump dump = new Dump();
		for (int i = 0; i < 5000; i++) {
			dump.setId(i + 1);
			dump.setUuid(generateUUID());
			dumping.save(dump);
		}
	}
	
	protected String generateUUID() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
