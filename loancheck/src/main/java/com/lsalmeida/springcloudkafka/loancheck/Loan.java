package com.lsalmeida.springcloudkafka.loancheck;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Loan {

    private String uuid;
    private String name;
    private Statuses status;
    private long amount;

    public Loan(String uuid, String name, long amount) {
        this.uuid = uuid;
        this.name = name;
        this.amount = amount;
        this.status = Statuses.PENDING;
    }

}