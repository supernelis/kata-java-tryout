package be.codekata;

import java.util.UUID;

public class RandomAccountIDGenerator implements AccountIDGenerator {

    @Override
    public AccountId generate() {
        return new AccountId(UUID.randomUUID().toString());
    }
}