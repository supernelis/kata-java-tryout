package be.codekata;

public class InMemoryAccountRepository implements AccountRepository {
    private Account account;

    @Override
    public Account find(AccountId id) {
        return account;
    }

    @Override
    public void store(Account account) {
        this.account = account;
    }
}
