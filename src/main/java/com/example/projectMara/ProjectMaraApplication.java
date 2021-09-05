package com.example.projectMara;

import com.example.projectMara.domain.model.User;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@SpringBootApplication
@EnableScheduling

public class ProjectMaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMaraApplication.class, args);
	}
}
