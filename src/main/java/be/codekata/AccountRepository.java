package be.codekata;

public interface AccountRepository {
    Account find(AccountId id);

    void store(Account account);
}
