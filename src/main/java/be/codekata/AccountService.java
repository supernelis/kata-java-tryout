package be.codekata;

public class AccountService {
    public String registerAccount(String customerId) {

        return "an id";
    }

    public FetchAccountReponse fetchAccount(String accountId) {
        return new FetchAccountReponse(accountId, "2023-02-28");
    }
}
