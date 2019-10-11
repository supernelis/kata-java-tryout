package be.codekata;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TestsShouldGoHere {

    @Test
    public void failingTest(){
        assertThat(false,equalTo(true));
    }

    @Test
    public void passingTest(){
        assertThat(true,equalTo(true));
    }
}
