package be.codekata.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OpeningDate {
    private final LocalDate date;

    public OpeningDate(LocalDate date) {
        this.date = date;
    }

    public String toString(){
        return date.format(DateTimeFormatter.ISO_DATE);
    }
}
