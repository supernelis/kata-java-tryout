package be.codekata;

public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountIDGenerator accountIDGenerator;
    private Account account;

    public AccountService(AccountRepository accountRepository, AccountIDGenerator accountIDGenerator) {
        this.accountRepository = accountRepository;
        this.accountIDGenerator = accountIDGenerator;
    }

    public String registerAccount(String customerId) {
        if ( account != null && customerId.equals(account.customerId())) {
            throw new CustomerAlreadyRegisteredException();
        }

        final AccountId accountId = accountIDGenerator.generate();
        this.account = new Account(accountId, customerId);
        accountRepository.store(account);
        return accountId.id();
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
