package be.codekata.infrastructure;

import be.codekata.core.AccountIDGenerator;
import be.codekata.core.AccountId;

import java.util.UUID;

public class RandomAccountIDGenerator implements AccountIDGenerator {

    @Override
    public AccountId generate() {
        return new AccountId(UUID.randomUUID().toString());
    }
}