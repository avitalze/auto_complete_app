package com.avital.auto_complete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

@SpringBootApplication
public class AutoCompleteApplication {

	public static void main(String[] args) {
		// Load the provided list of names to an H2 database
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("BoyNames.txt");

//		URL url = Resources.getResource("BoyNames.txt");
//		String text = Resources.toString(url, StandardCharsets.UTF_8);


		SpringApplication.run(AutoCompleteApplication.class, args);
	}

}
