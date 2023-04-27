package be.codekata.core;

import java.time.LocalDate;

public class OpeningDate {
    private final String now;

    public OpeningDate(String now) {
        this.now = now;
    }

    public String toString(){
        return now;
    }
}
