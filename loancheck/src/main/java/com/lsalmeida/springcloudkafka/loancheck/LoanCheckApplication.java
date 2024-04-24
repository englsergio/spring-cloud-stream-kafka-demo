package com.lsalmeida.springcloudkafka.loancheck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@Slf4j
@SpringBootApplication
public class LoanCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanCheckApplication.class, args);
    }

    @Bean
    public Consumer<Loan> consumeLoan() {
        return loan -> {
            log.info("{} {} for ${} for {}", loan.getStatus(), loan.getUuid(), loan.getAmount(), loan.getName());
            if (loan.getAmount() > 1000L) loan.setStatus(Statuses.APPROVED);
            else loan.setStatus(Statuses.DECLINED);
            log.info("loan with uuid: {}, has status: {}", loan.getUuid(), loan.getStatus());
        };
    }

}
