package dev.byteschool.byteschoolapp;

import org.springframework.boot.SpringApplication;

public class TestByteSchoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(ByteSchoolAppApplication::main)
				.with(TestcontainersConfiguration.class)
				.run(args);
	}

}
