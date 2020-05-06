package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CloseQuitePage {
	private WebDriver driver;
	
	public CloseQuitePage (WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);			
	}
	
	public void Close() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}
	
	public void Quite() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	

}
