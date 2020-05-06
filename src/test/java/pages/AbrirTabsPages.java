package pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbrirTabsPages {
	private WebDriver driver;
	ArrayList<String> tabs;
	//Constructor de clase*****************
	public AbrirTabsPages (WebDriver driver) {
		this.driver=driver;
		tabs= new ArrayList<String> (driver.getWindowHandles());
		PageFactory.initElements(driver, this);
	}
	
	public void abrirNuevoTab(String url){
		JavascriptExecutor javascriptExecutor=  (JavascriptExecutor)driver;
		String googleWindow="window.open(url)";
		javascriptExecutor.executeScript(googleWindow);
			
	}
	
	public void cambiarTab(String handle, int index) {
		driver.switchTo().window(tabs.get(index));
		
	}
	public void cerrarTab(String handle,int index) {
		driver.switchTo().window(tabs.get(index)).close();
		
	}

}
