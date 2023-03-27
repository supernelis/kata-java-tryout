package be.codekata.infrastructure;

import be.codekata.core.Account;
import be.codekata.core.AccountId;
import be.codekata.core.AccountRepository;

public class InMemoryAccountRepository implements AccountRepository {
    private Account account;

    @Override
    public Account find(AccountId id) {
        return account;
    }

    @Override
    public void store(Account account) {
        this.account = account;
    }
}
