package dev.isnotnull;

import dev.isnotnull.context.Context;
import dev.isnotnull.utils.SessionUtils;
import io.cucumber.java.en.Given;

public class StepDefinitionsPartOne extends Context {
    public StepDefinitionsPartOne(SessionUtils session) {
        super(session);
    }

    @Given("I have {string} stored in my session")
    public void iHaveStringStoredInMySession(String stepValue){
        getSession().put(SessionUtils.TEST_KEY, stepValue);
    }
}
