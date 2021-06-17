package com.avital.auto_complete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoCompleteApplication {

	public static void main(String[] args) {
		// Load the provided list of names to an H2 database

		SpringApplication.run(AutoCompleteApplication.class, args);
	}

}
