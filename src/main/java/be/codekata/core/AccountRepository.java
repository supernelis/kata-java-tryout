package be.codekata.core;

public interface AccountRepository {
    Account find(AccountId id);

    void store(Account account);
}
