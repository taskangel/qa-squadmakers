package steps;

import io.cucumber.java.After;
import settings.DriverSetup;

public class Hooks {

    @After
    public void tearDown(){
        DriverSetup.destroyDriver();
    }
}
