package be.codekata;

import be.codekata.core.*;

import static java.time.LocalDate.now;

public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountIDGenerator accountIDGenerator;
    private final Calendar calendar;

    public AccountService(AccountRepository accountRepository, AccountIDGenerator accountIDGenerator, Calendar calendar) {
        this.accountRepository = accountRepository;
        this.accountIDGenerator = accountIDGenerator;
        this.calendar = calendar;
    }

    public String registerAccount(String customerId) {
        if (accountRepository.findByCustomerId(customerId).isPresent()) {
            throw new CustomerAlreadyRegisteredException();
        }

        final AccountId accountId = accountIDGenerator.generate();
        OpeningDate openingDate = new OpeningDate(calendar.today());
        accountRepository.store(new Account(accountId, customerId, openingDate));
        return accountId.id();
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
