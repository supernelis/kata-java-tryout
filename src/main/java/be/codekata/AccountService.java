package be.codekata;

public class AccountService {
    private final AccountIDGenerator accountIDGenerator;
    private String customerId;
    private String accountId = "an id";

    public AccountService(AccountIDGenerator accountIDGenerator) {
        this.accountIDGenerator = accountIDGenerator;
    }

    public String registerAccount(String customerId) {
        if( customerId.equals(this.customerId)) {
            throw new CustomerAlreadyRegisteredException();
        }

        this.customerId = customerId;
        String currentAccountId = this.accountId;
        this.accountId = accountIDGenerator.generate();
        return currentAccountId;
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
