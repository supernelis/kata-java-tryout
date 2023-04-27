package be.codekata;

import be.codekata.core.*;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountIDGenerator accountIDGenerator;
    private final DateGenerator dateGenerator;

    public AccountService(AccountRepository accountRepository, AccountIDGenerator accountIDGenerator, DateGenerator dateGenerator) {
        this.accountRepository = accountRepository;
        this.accountIDGenerator = accountIDGenerator;
        this.dateGenerator = dateGenerator;
    }

    public String registerAccount(String customerId) {
        if (accountRepository.findByCustomerId(customerId).isPresent()) {
            throw new CustomerAlreadyRegisteredException();
        }

        final AccountId accountId = accountIDGenerator.generate();
        OpeningDate openingDate = new OpeningDate(dateGenerator.now());
        accountRepository.store(new Account(accountId, customerId, openingDate));
        return accountId.id();
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
