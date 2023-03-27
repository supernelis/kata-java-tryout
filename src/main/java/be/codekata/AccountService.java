package be.codekata;

import be.codekata.core.*;

public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountIDGenerator accountIDGenerator;

    public AccountService(AccountRepository accountRepository, AccountIDGenerator accountIDGenerator) {
        this.accountRepository = accountRepository;
        this.accountIDGenerator = accountIDGenerator;
    }

    public String registerAccount(String customerId) {
        if (accountRepository.findByCustomerId(customerId).isPresent()) {
            throw new CustomerAlreadyRegisteredException();
        }

        final AccountId accountId = accountIDGenerator.generate();
        accountRepository.store(new Account(accountId, customerId));
        return accountId.id();
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
