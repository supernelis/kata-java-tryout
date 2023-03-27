package be.codekata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;


public class RegisterUseCaseTest {

    private AccountService service;

    @BeforeEach
    void setUp() {
        service = new AccountService(new RandomAccountIDGenerator());
    }

    @Test
    public void receiveNewIdWhenRegisteringAccount(){
        service = new AccountService(() -> new AccountId("an id"));
        String response = service.registerAccount("a customer id");

        assertThat(response, equalTo("an id"));
    }

    @Test
    public void registeredAccountCanBeFetched(){
        String accountId = service.registerAccount("a customer id");

        FetchAccountReponse fetchAccountReponse = service.fetchAccount(accountId);

        FetchAccountReponse expected = new FetchAccountReponse(accountId, "2023-02-28");
        assertThat(fetchAccountReponse, equalTo(expected));
    }

    @Test
    public void registeredAccountIsPersisted() {
        AccountRepository accountRepository = new InMemoryAccountRepository();
        String accountId = service.registerAccount("a customer id");

        assertNotNull(accountRepository.find(new AccountId(accountId)));
    }

    @Test
    public void registeringTwoAccountsWithTheSameIdIsForbidden() {
        service.registerAccount("a customer id");

        assertThrows(CustomerAlreadyRegisteredException.class,
                () ->  service.registerAccount("a customer id"));
    }

    @Test
    void registerTwoAccountsShouldHaveUniqueIds() {
        String firstCustomerAccountId = service.registerAccount("a customer id");
        String secondCustomerAccountId = service.registerAccount("another id");

        assertNotEquals(firstCustomerAccountId, secondCustomerAccountId);
    }
}
