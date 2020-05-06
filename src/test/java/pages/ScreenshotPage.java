package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

public class ScreenshotPage {
	private WebDriver driver;
	
	public ScreenshotPage(WebDriver driver) {
		  this.driver=driver;
		  //aca instanciando las variables
		  PageFactory.initElements(driver, this);			
		}
	
	public void screenshotPage (){
		
		File myScreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
				FileUtils.copyFile(myScreenshot, new File("LOGIN"+System.currentTimeMillis()+".png"));                     	
				
		  }catch(IOException ie){
				ie.printStackTrace();
				
		  }
		
				
	}
	
	public void takeScreenshot(String screenName, WebDriver driver) {
		File myScreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
    		
			FileUtils.copyFile(myScreenshot, new File(screenName+"_"+System.currentTimeMillis()+".png"));                     	
				
		}catch(IOException ie){
			ie.printStackTrace();
				
			}
		
	}
	
}
