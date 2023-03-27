package be.codekata.core;

import java.util.Optional;

public interface AccountRepository {
    Account find(AccountId id);

    void store(Account account);

    Optional<Account> findByCustomerId(String customerId);
}
