package tests;
import org.testng.annotations.Test;
import pages.AbrirNavegadorPage;
import pages.BasePage;
import pages.CloseQuitePage;
import pages.LoginPage;
import pages.ManejoPantallaPage;
import pages.ReservationPage;
import pages.ScreenshotPage;
import pages.TiempoEsperaPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Home{
	private WebDriver driver;
	private ITestResult result;
	
	@BeforeMethod
	public void setUp() {
		
		//DesiredCapabilities caps =new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver= new ChromeDriver();	
		
		//***Abrirpágina*********************************
		//******se pasa driver para el constructor de la clase
		AbrirNavegadorPage abrirNavegadorPage = new AbrirNavegadorPage(driver);
		abrirNavegadorPage.abrirNavegador("http://newtours.demoaut.com/");
		
		//***Espero que cargue la pagina********************
		TiempoEsperaPage tiempoEsperaPage=new TiempoEsperaPage(driver);
		tiempoEsperaPage.sleepSeconds(5);
		
		//Maximizar la pantalla**************************
		ManejoPantallaPage manejoPantallaPage= new ManejoPantallaPage(driver);
		manejoPantallaPage.setWindowSize("fullscreen");
		//manejoPantallaPage.setPosition(600,500);
	}
	
		
	
	@Test
	public void Testing()  {
		//*******Login************************************
		System.out.println("Hola Mundo");
		
		LoginPage loginPage= new LoginPage(driver);	
		loginPage.login("pasilvav@gmail.com","Cafe4153");
		
		ScreenshotPage screenshot = new ScreenshotPage(driver);	
		screenshot.screenshotPage();
		
		//*******Seleccionar pasajeros************************************
		
		 ReservationPage reservationPage=new ReservationPage(driver);
		 reservationPage.selectPassengers(2);
		//*******Seleccionar opcion Partiendo De**************************
		 reservationPage.selectFrom(2);
		//*******Seleccionar opcion Al llegar a**************************
		 reservationPage.selectArrivos("Acapulco");
		 
		//Assert.assertTrue(loginPage.login("pasilvav@gmail.com","Cafe4153"),"Error en login");
		
		//Assert.assertTrue(driver.findElement(By.xpath("//font[contains(text(),'Use nuestro Buscador de vuelos para buscar la tarifa más baja')]")),"Error");
		
		
		
	}
		
    @AfterMethod
	public void tearDown(ITestResult resultado) {
    	if (!resultado.isSuccess()) {
    		ScreenshotPage screenshot = new ScreenshotPage(driver);	
    		screenshot.takeScreenshot("Error",driver); 		
    	}
    	
		CloseQuitePage closeQuitePage= new CloseQuitePage(driver);
		closeQuitePage.Close();		
	}
	
	
		
}		

	

