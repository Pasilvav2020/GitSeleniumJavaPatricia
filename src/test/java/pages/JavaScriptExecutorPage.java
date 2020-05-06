package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptExecutorPage {
	private WebDriver driver;
	public JavaScriptExecutorPage(WebDriver driver) {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);			
	}
	
	public void executeScript(String pagina) {
		javascriptExecutor.class
		
	}
	

}
