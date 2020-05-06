package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ExplicitWaitPage {
	
	private WebDriver driver;
	
	public ExplicitWaitPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);			
	}
	
	public void  explicitWaitSeconds (int seconds) {
	   
	  driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
	 
			
	}

}
