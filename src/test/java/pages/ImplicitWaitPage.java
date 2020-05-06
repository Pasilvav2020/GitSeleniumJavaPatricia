package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ImplicitWaitPage {
	
	private WebDriver driver;
	
	public ImplicitWaitPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);			
	}
	
	public void  implicitlyWaitSeconds (int seconds) {
	   
	  driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
			
	}

}
