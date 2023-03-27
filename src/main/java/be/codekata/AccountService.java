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

        this.customerId = customerId;
        return accountIDGenerator.generate().id();
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
