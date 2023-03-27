package be.codekata;
import be.codekata.core.Account;
import be.codekata.core.AccountId;
import be.codekata.core.CustomerAlreadyRegisteredException;
import be.codekata.infrastructure.InMemoryAccountRepository;
import be.codekata.infrastructure.RandomAccountIDGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;


public class RegisterUseCaseTest {

    private AccountService service;
    private InMemoryAccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = new InMemoryAccountRepository();
        service = new AccountService(accountRepository,new RandomAccountIDGenerator());
    }

    @Test
    public void receiveNewIdWhenRegisteringAccount(){
        service = new AccountService(accountRepository, () -> new AccountId("an id"));
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
        String accountId = service.registerAccount("a customer id");

        Account actualAccount = accountRepository.find(new AccountId(accountId));
        assertEquals(accountId,actualAccount.accountId());
        assertEquals("a customer id",actualAccount.customerId());
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
