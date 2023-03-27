package be.codekata.infrastructure;

import be.codekata.core.Account;
import be.codekata.core.AccountId;
import be.codekata.core.AccountRepository;

import java.util.Optional;

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

    @Override
    public Optional<Account> findByCustomerId(String customerId) {
        if ( account != null && customerId.equals(account.customerId()))
            return Optional.of(account);
        return Optional.empty();
    }
}
