package be.codekata;

import java.util.Objects;

public class FetchAccountReponse {
    private final String accountId;
    private final String openingDate;

    public FetchAccountReponse(String accountId, String openingDate) {
        this.accountId = accountId;
        this.openingDate = openingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FetchAccountReponse that = (FetchAccountReponse) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(openingDate, that.openingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, openingDate);
    }
}
