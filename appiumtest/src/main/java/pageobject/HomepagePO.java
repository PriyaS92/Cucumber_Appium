package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.sun.glass.events.KeyEvent;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import testrunner.BaseTest;

public class HomepagePO extends BasePO{

	public HomepagePO(RemoteWebDriver appdriver) {
		super(appdriver);
	}
	
	@AndroidFindBy(id = "UserName")
	AndroidElement UserName;
	@AndroidFindBy(id = "Password")
	AndroidElement Password;
	@AndroidFindBy(id = "ConfirmPassword")
	AndroidElement ConfirmPassword;
	@AndroidFindBy(id = "Email")
	AndroidElement Email;
	BaseTest b = new BaseTest();
	
	public void register_employee(String user,String pwd,String email_id){
		try{
			b.pressKey(KeyEvent.VK_TAB);
			b.pressKey(KeyEvent.VK_ENTER);
			for(int i=0;i<4;i++){
				b.pressKey(KeyEvent.VK_TAB);
			}
			b.pressKey(KeyEvent.VK_ENTER);
			TimeUnit.SECONDS.sleep(10);
			UserName.sendKeys(user);
			Password.sendKeys(pwd);
			ConfirmPassword.sendKeys(pwd);
			Email.sendKeys(email_id);
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	public void register_validation(String user){
		try{
			b.pressKey(KeyEvent.VK_TAB);
			b.pressKey(KeyEvent.VK_ENTER);
			TimeUnit.SECONDS.sleep(5);
			b.pressKey(KeyEvent.VK_TAB);
			b.pressKey(KeyEvent.VK_ENTER);
		}
		catch(Exception e){e.printStackTrace();}
	}
	
}
