package pages;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
    private WebElement lblLogon; 
	private By userField;
	private By passField;
	private By loginButton;
	private By titleText; 
		
	public LoginPage(WebDriver driver) {
	  this.driver=driver;
	  //aca instanciando las variables
	  userField=By.name("userName");
	  passField= By.name("password");
	  loginButton=By.name("login");	  
	  titleText=By.xpath("//font[contains(text(),'Use nuestro Buscador de vuelos para buscar la tarifa más baja')]");
	  PageFactory.initElements(driver, this);			
	}
	
	//@FindBy(name = "userName")
    //private WebElement userField;
	
	public void login(String usuario, String password)  {
		driver.findElement(userField).sendKeys(usuario);
		driver.findElement(passField).sendKeys(password);
		driver.findElement(loginButton).click();
		//driver.findElement(By.xpath(titleText));
		System.out.println(titleText);
		//return lblLogon.isDisplayed();
		
		//userField.sendKeys(usuario);
		//passField.sendKeys(password);
		//loginButton.click();		
		
	}

}
