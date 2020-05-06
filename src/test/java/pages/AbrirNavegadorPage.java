package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbrirNavegadorPage {
	private WebDriver driver;
	//Constructor de clase*****************
	public AbrirNavegadorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void abrirNavegador (String url) {		
		driver.navigate().to("http://newtours.demoaut.com/");
		
	}

}
