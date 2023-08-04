package com.example.mongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(IStudentRepository repository) {
		return args -> {
			Address adress = new Address("Brazil", "54100715", "Recife");
			Student student = new Student(
					"vini",
					"guedes",
					"viniciusguedes82@gmail.com",
					Gender.MALE,
					adress,
					List.of("Computer Science", "Math"),
					10.4,
					LocalDateTime.now()
			);
			repository.save(student);
			System.out.println("ENTROU");
		};
	}
}
