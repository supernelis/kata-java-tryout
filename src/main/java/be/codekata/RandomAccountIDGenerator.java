package be.codekata;

import java.util.UUID;

public class RandomAccountIDGenerator {

    public String generate() {
        return UUID.randomUUID().toString();
    }
}