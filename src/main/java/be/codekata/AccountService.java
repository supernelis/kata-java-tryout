package be.codekata;

import be.codekata.core.*;

import java.time.LocalDate;

import static java.time.LocalDate.now;

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
        OpeningDate openingDate = new OpeningDate(LocalDate.parse("2023-04-01"));
        accountRepository.store(new Account(accountId, customerId, openingDate));
        return accountId.id();
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
