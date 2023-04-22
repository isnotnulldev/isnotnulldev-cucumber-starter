package dev.isnotnull;

import dev.isnotnull.context.Context;
import dev.isnotnull.utils.SessionUtils;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;


public class StepDefinitionsPartTwo extends Context {
    public StepDefinitionsPartTwo(SessionUtils session) {
        super(session);
    }

    @Then("the user verifies that the string stored in the session is {string}")
    public void verifyVariable(String expectedValue){
        assertEquals(expectedValue, getSession().get(SessionUtils.TEST_KEY));
    }
}
