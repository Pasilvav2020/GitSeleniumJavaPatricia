package tests;
import org.testng.annotations.Test;
import pages.AbrirNavegadorPage;
import pages.CloseQuitePage;
import pages.LoginPage;
import pages.ManejoPantallaPage;
import pages.TiempoEsperaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

import org.openqa.selenium.*;


public class Home2 {
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		//DesiredCapabilities caps =new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver= new ChromeDriver();	
		
		//***Abrirpágina*********************************
		AbrirNavegadorPage abrirNavegadorPage = new AbrirNavegadorPage(driver);
		abrirNavegadorPage.abrirNavegador("http://newtours.demoaut.com/");
		
		//***Espero que cargue la pagina********************
		TiempoEsperaPage tiempoEsperaPage=new TiempoEsperaPage(driver);
		tiempoEsperaPage.sleepSeconds(5);
		
		//Maximizar la pantalla**************************
		ManejoPantallaPage manejoPantallaPage= new ManejoPantallaPage(driver);
		manejoPantallaPage.setWindows("fullscreen");
	}
	
		
	
	@Test(dataProvider = "SearchProvider")	
	public void pruebaUno(String tester, String search) throws InterruptedException {
		//*******Login************************************
		System.out.println("Hola Mundo");
		LoginPage loginPage= new LoginPage(driver);	
		loginPage.login("pasilvav@gmail.com","Cafe4153");
		//*****DataProvider**************
		WebElement searchText=driver.findElement(By.name("q"));
		searchText.sendKeys(search);
		System.out.println("Bienvenido:" + tester + "valor:" +search );
		
		String testValue=searchText.getAttribute("value");
		System.out.println("Bienvenido:" + testValue + "valor:" +search );
	}
	
	@DataProvider(name="searchProvider")
	public Object[][] getDataFromDataProvider(Method m){
		
		if (m.getName().equals("pruebaUno")) {
			return new Object[][]{
				{"usuario","pasilvav@gmail.com"},
				{"password","Cafe4153"}
			
			};
		}else {
			return null;	
		}
				
	}
	
	@AfterMethod
	public void PruebaDos() {
		CloseQuitePage closeQuitePage= new CloseQuitePage(driver);
		closeQuitePage.Close();		
	}
	
	
		
}		

	

