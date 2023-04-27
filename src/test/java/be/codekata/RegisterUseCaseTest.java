package be.codekata;

import be.codekata.core.Account;
import be.codekata.core.AccountId;
import be.codekata.core.CustomerAlreadyRegisteredException;
import be.codekata.infrastructure.InMemoryAccountRepository;
import be.codekata.infrastructure.RandomAccountIDGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;


public class RegisterUseCaseTest {

    private AccountService service;
    private InMemoryAccountRepository accountRepository;
    private TestDateGenerator dateGenerator;

    @BeforeEach
    void setUp() {
        accountRepository = new InMemoryAccountRepository();
        dateGenerator = new TestDateGenerator();
        service = new AccountService(accountRepository, new RandomAccountIDGenerator(), dateGenerator);
    }

    @Test
    public void receiveNewIdWhenRegisteringAccount() {
        service = new AccountService(accountRepository, () -> new AccountId("an id"), dateGenerator);
        String response = service.registerAccount("a customer id");

        assertThat(response, equalTo("an id"));
    }

    @Test
    public void registeredAccountCanBeFetched() {
        String accountId = service.registerAccount("a customer id");

        FetchAccountReponse fetchAccountReponse = service.fetchAccount(accountId);

        FetchAccountReponse expected = new FetchAccountReponse(accountId, "2023-02-28");
        assertThat(fetchAccountReponse, equalTo(expected));
    }

    @Test
    public void registeredAccountIsPersisted() {
        dateGenerator.setNow("2023-04-14");

        String registeredAccountId = service.registerAccount("a customer id");

        Account persistedAccount = accountRepository.find(new AccountId(registeredAccountId)).get();
        assertEquals(registeredAccountId, persistedAccount.accountId());
        assertEquals("a customer id", persistedAccount.customerId());
        assertEquals("2023-04-14", persistedAccount.openingDate().toString());
    }

    @Test
    public void registeringTwoAccountsWithTheSameIdIsForbidden() {
        service.registerAccount("a customer id");

        assertThrows(CustomerAlreadyRegisteredException.class,
                () -> service.registerAccount("a customer id"));
    }

    @Test
    void registerTwoAccountsShouldHaveUniqueIds() {
        String firstCustomerAccountId = service.registerAccount("a customer id");
        String secondCustomerAccountId = service.registerAccount("another id");

        assertNotEquals(firstCustomerAccountId, secondCustomerAccountId);
    }

    private class TestDateGenerator extends DateGenerator {
        private String date = "2023-04-01";

        public void setNow(String date) {
            this.date = date;
        }

        @Override
        public LocalDate now() {
            return LocalDate.parse(date);
        }
    }
}
