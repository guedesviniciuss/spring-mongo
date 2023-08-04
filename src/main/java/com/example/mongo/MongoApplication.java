package com.example.mongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(IStudentRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			System.out.println("ENTROU");

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

			Query query = new Query();
			query.addCriteria(Criteria.where("email").is("viniciusguedes82@gmail.com"));

			List<Student> students = mongoTemplate.find(query, Student.class);

			if(students.size() > 1) {
				throw new IllegalStateException("more than one student found");
			}

			if(students.isEmpty()) {
				repository.save(student);
			}
		};
	}
}
