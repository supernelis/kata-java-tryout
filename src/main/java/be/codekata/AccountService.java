package be.codekata;

public class AccountService {
    private final AccountIDGenerator accountIDGenerator;
    private String customerId;

    public AccountService(AccountIDGenerator accountIDGenerator) {
        this.accountIDGenerator = accountIDGenerator;
    }

    public String registerAccount(String customerId) {
        if( customerId.equals(this.customerId)) {
            throw new CustomerAlreadyRegisteredException();
        }

        final AccountId accountId = accountIDGenerator.generate();
        final Account account = new Account(accountId, customerId);
        this.customerId = customerId;
        return accountId.id();
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
