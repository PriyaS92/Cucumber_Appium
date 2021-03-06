package testcases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomepagePO;
import testrunner.BaseTest;
import utils.UtilityTests;

public class EAapp_Homepage extends BaseTest{

	UtilityTests ut = new UtilityTests();
	HomepagePO homepage = new HomepagePO(driver);
	
	@Given("^user navigate to execute automate application home page with \"([^\"]*)\"$")
	public void user_navigate_to_execute_automate_application_home_page_with(String url) throws Throwable {	
		try{
			driver.navigate().to(url);
			ut.staticwait("seconds", 10);
			
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	@When("^I register a employee with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_register_a_employee_with(String user, String password, String email) throws Throwable {
		homepage.register_employee(user, password, email);
		ut.staticwait("seconds", 10);
	}
	
	@Then("^verify whether the \"([^\"]*)\" is displayed in menu$")
	public void verify_whether_the_is_displayed_in_menu(String user) throws Throwable {
		homepage.register_validation(user);
		ut.staticwait("seconds", 10);
	}

}
