package com.lsalmeida.springcloudkafka.loansource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class LoanSourceApplication {

	private final List<String> names = Arrays.asList("Pedro", "Paulo", "Maria", "Juliana", "Rafael", "Leonardo");
	private final List<Long> values = Arrays.asList(1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L);

	public static void main(String[] args) {
		SpringApplication.run(LoanSourceApplication.class, args);
	}

	@Bean
	public Supplier<Loan> supplyLoan() {
		return () -> {
			Loan loan = Loan.create(UUID.randomUUID().toString(),
					names.get(new Random().nextInt(names.size())),
					values.get(new Random().nextInt(values.size()))
			);
			log.info("{} {} for ${} for {}", loan.status(), loan.uuid(), loan.amount(), loan.name());
			return loan;
		};
	}

}
