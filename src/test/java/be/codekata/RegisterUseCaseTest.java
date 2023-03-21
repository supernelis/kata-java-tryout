package be.codekata;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class RegisterUseCaseTest {

    @Test
    public void receiveNewIdWhenRegisteringAccount(){
        AccountService service = new AccountService();

        String response = service.registerAccount("a customer id");

        assertThat(response, equalTo("an id"));
    }

    @Test
    public void registeredAccountCanBeFetched(){
        AccountService service = new AccountService();
        String accountId = service.registerAccount("a customer id");

        FetchAccountReponse fetchAccountReponse = service.fetchAccount(accountId);

        FetchAccountReponse expected = new FetchAccountReponse(accountId, "2023-02-28");
        assertThat(fetchAccountReponse, equalTo(expected));
    }

    @Test
    public void registeredAccountIsPersisted() {
        AccountRepository accountRepository = new InMemoryAccountRepository();
        AccountService service = new AccountService();
        String accountId = service.registerAccount("a customer id");

        assertNotNull(accountRepository.find(new AccountId(accountId)));
    }
}
