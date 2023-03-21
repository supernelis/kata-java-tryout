package be.codekata;

import java.util.UUID;

public class RandomAccountIDGenerator implements AccountIDGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}