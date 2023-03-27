package be.codekata;

public class AccountService {
    private final AccountIDGenerator accountIDGenerator;
    private Account account;

    public AccountService(AccountIDGenerator accountIDGenerator) {
        this.accountIDGenerator = accountIDGenerator;
    }

    public String registerAccount(String customerId) {
        if ( account != null && customerId.equals(account.customerId())) {
            throw new CustomerAlreadyRegisteredException();
        }

        final AccountId accountId = accountIDGenerator.generate();
        this.account = new Account(accountId, customerId);
        return accountId.id();
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
