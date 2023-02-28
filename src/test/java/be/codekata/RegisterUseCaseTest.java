package be.codekata;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RegisterUseCaseTest {

    @Test
    public void registerNewCheckingAccount(){
        AccountService service = new AccountService();

        String response = service.registerAccount("a customer id");

        assertThat(response, equalTo("an id"));
    }
}
