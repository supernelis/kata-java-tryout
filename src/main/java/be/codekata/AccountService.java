package be.codekata;

public class AccountService {
    private String customerId;

    public String registerAccount(String customerId) {
        if( customerId.equals(this.customerId)) {
            throw new CustomerAlreadyRegisteredException();
        }

        this.customerId = customerId;
        return "an id";
    }

    public FetchAccountReponse fetchAccount(String accountId) {

        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
