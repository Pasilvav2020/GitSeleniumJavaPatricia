package pages;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.Position;

//import java.awt.Dimension;
import org.openqa.selenium.*;
public class ManejoPantallaPage {
	private WebDriver driver;
	
	
	public ManejoPantallaPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);					
	}
	
	public void setWindowSize (String size) {
		
		if (size.toLowerCase()=="maximized") {
			driver.manage().window().maximize();
			
		}else if(size.toLowerCase()=="fullscreen"){
			
			driver.manage().window().fullscreen();
		}
	}
	
	public void setWindowSize(int x, int y) {
		Dimension d = new Dimension(x,y);
		driver.manage().window().setSize(d);		
	}
	
	public void setPosition(int x, int y) {
		//Position p= (Position) new Point(x,y);
		driver.manage().window().setPosition(new Point(x,y));
	}

}
