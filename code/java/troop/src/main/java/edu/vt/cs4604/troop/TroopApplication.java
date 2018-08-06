package edu.vt.cs4604.troop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class TroopApplication {
	private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);	

	public static void main(String[] args) {
		SpringApplication.run(TroopApplication.class, args);
 		logger.info("--Application Started--");
	}
}
