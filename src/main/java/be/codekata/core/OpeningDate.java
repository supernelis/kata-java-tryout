package be.codekata.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OpeningDate {
    private final String now;

    public OpeningDate(String now) {
        this.now = now;
    }

    public String toString(){
        return LocalDate.parse(now).format(DateTimeFormatter.ISO_DATE);
    }
}
