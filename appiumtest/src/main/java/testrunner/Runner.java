package testrunner;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.testng.annotations.*;
import java.io.*;

@CucumberOptions(
		features = "src/test/resources/FeatureFiles",
        glue = {"testcases","reporting","hooks"},
        //tags = {"~@Ignore"},
        plugin = {
                        "pretty",
                        "html:target/cucumber-reports/cucumber-pretty",
                        "json:target/cucumber-reports/CucumberTestReport.json",
                        "rerun:src/test/resources/Failedfeature/rerun.txt",
        "reporting.Reports"}
        )
       

public class Runner extends BaseTest{
	private TestNGCucumberRunner testNGCucumberRunner;
	FeatureWrapper cucumberFeatures;
	AppiumDriverLocalService appiumDriverLocalService;
	
	@BeforeSuite
    public void beforeSuite() throws FileNotFoundException, IOException {
		appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();
	 }
	
	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 	
    @Test(dataProvider = "features")
    public void feature(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
    	testNGCucumberRunner.runScenario(pickle.getPickle());
    }
 
    @DataProvider
    public Object[][] features() {
    	return testNGCucumberRunner.provideScenarios();
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
    	testNGCucumberRunner.finish();
    }
    
    @AfterSuite
    public void afterSuite() {
        appiumDriverLocalService.stop();
    }
}
