package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import testrunner.BaseTest;

public class CommonHooks {
	
	@AfterStep
    public void capturescreenshot(Scenario scenario){
		TakesScreenshot newScreen = (TakesScreenshot) BaseTest.driver;
		String img = newScreen.getScreenshotAs(OutputType.BASE64);
		scenario.attach(img, "image/png", "screenshot");
    }
}
