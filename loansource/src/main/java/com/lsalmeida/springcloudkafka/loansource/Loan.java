package com.lsalmeida.springcloudkafka.loansource;

public record Loan (
    String uuid,
    String name,
    Statuses status,
    long amount
) {
    public static Loan create(String uuid, String name, long amount) {
        return new Loan(uuid, name, Statuses.PENDING, amount);
    }
}
