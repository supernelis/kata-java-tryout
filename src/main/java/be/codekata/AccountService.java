package be.codekata;

public class AccountService {
    private final RandomAccountIDGenerator randomAccountIDGenerator = new RandomAccountIDGenerator();
    private String customerId;
    private String accountId = "an id";

    public String registerAccount(String customerId) {
        if( customerId.equals(this.customerId)) {
            throw new CustomerAlreadyRegisteredException();
        }

        this.customerId = customerId;
        String currentAccountId = this.accountId;
        this.accountId = randomAccountIDGenerator.generate();
        return currentAccountId;
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
