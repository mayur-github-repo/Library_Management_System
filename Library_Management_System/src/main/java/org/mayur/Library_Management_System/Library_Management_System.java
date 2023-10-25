package org.mayur.Library_Management_System;

import org.mayur.Library_Management_System.repository.TxnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Library_Management_System implements CommandLineRunner {

	@Autowired
	private TxnRepository txnRepository;

	public static void main(String[] args) {
		SpringApplication.run(Library_Management_System.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		txnRepository.updateTxnCreatedOn();
	}
}
