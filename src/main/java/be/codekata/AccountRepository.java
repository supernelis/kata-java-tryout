package be.codekata;

public class AccountRepository {
    private Account account;

    public Account find(AccountId id) {
        return account;
    }

    public void store(Account account) {
        this.account = account;
    }
}
