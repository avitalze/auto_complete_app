package com.avital.auto_complete;

import com.avital.auto_complete.dao.NameRepository;
import com.avital.auto_complete.modle.Name;
import com.avital.auto_complete.service.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoCompleteApplication {

	public static void main(String[] args) {
			SpringApplication.run(AutoCompleteApplication.class, args);

	}


}
