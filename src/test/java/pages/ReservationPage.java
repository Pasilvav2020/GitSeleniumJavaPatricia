package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReservationPage {
	
	private WebDriver driver;
	private By passengerDrops;
	private By fromDrops;
	private By arrivosDrops;
	
	public ReservationPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		passengerDrops=By.name("passCount");
		fromDrops=By.name("fromPort");
		arrivosDrops=By.name("toPort");
	}
	
	public void selectPassengers(int cant){
		
		WebDriverWait wait=new WebDriverWait (driver,10);
		WebElement cantidadPasajeros=wait.until(ExpectedConditions.presenceOfElementLocated(passengerDrops));
		
		//Select selectPasajeros= new Select(driver.findElement(passengerDrops));
		Select selectPasajeros= new Select(cantidadPasajeros);
		selectPasajeros.selectByVisibleText(Integer.toString(cant));			
	}
	
	public void selectFrom (int index) {
		
		Select selectFrom= new Select(driver.findElement(fromDrops));
		selectFrom.selectByIndex(index);
	}
	public void selectArrivos(String city) {
		
		Select selectArrivos= new Select(driver.findElement(arrivosDrops));
		selectArrivos.selectByValue(city);
		
	}
	

}
