package com.manage.sml.smlAdminPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SmlAdminPageApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmlAdminPageApplication.class, args);
	}
}