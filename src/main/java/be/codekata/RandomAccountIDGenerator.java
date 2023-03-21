package be.codekata;

import java.util.UUID;

public class RandomAccountIDGenerator {
    public RandomAccountIDGenerator() {
    }

    public String generateAccountID() {
        return UUID.randomUUID().toString();
    }
}