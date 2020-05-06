//***Autor: Patricia Silva Vergara
//***Fecha de creación:11-03-2019
//***Fecha de ultima modificación: 13-03-2019
//***Descripción: Este Test realiza los siguientes pasos:
//1.-Loguearse .
//2.-Eliminar productos del carrito de compras.
//3.-Buscar producto.
//4.-Agregar producto al carrito de compras.
//5.-Desloquearse.

package com.falabella.templateautomationfront.tests;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.dyslexicon.configuration.BaseConfig;
import com.falabella.templateautomationfront.dataproviders.DataProviders;
import com.falabella.templateautomationfront.entity.UserCredentials;
import com.falabella.templateautomationfront.pages.HomePage;
import com.falabella.templateautomationfront.pages.EliminarPage;
import com.falabella.templateautomationfront.pages.BuscarPage;
import com.falabella.templateautomationfront.pages.BuscarSKUPage;
import com.falabella.templateautomationfront.pages.CloseQuitPage;
import com.falabella.templateautomationfront.pages.AgregarPage;
import com.falabella.templateautomationfront.pages.LogonPage;
import com.falabella.templateautomationfront.pages.ManejoPantallaPage;
import com.falabella.templateautomationfront.pages.ValidarTituloPage;

public class Login extends BaseConfig {
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "loginData", description = "Logueo")
	
	private void loginFalabella(UserCredentials userCredentials) throws Exception {
		
		//***********Formato de pantalla**
		ManejoPantallaPage  manejoPantallaPage= new ManejoPantallaPage(driver);
		manejoPantallaPage.setWindowSize("fullscreen");
		
		//***********Loguearse***********
		HomePage  homePage= new HomePage(driver);
		String userName= userCredentials.getUsername();
		String passWord= userCredentials.getPassword();
		Assert.assertTrue(homePage.login(userName, passWord),"Error en login");
	
		//***********Validar titulo de la página*************
		String titulo="Falabella.com - Mejor Compra Online";
		ValidarTituloPage  tituloPagina= new ValidarTituloPage();
		Assert.assertTrue(tituloPagina.ValidarTituloPagina(driver, titulo),"No coincide el titulo de la página ");
		
		//**********Eliminar productos de la bolsa**
		EliminarPage  eliminarPage= new EliminarPage(driver);
		Assert.assertTrue(eliminarPage.EliminarBolsa(),"No se eliminaron los productos:");
		
		//**********Buscar producto por SKU*****************
		BuscarSKUPage buscarSKUPage= new BuscarSKUPage(driver);
		buscarSKUPage.BuscarPorSKU("C:\\archivo_java\\productos.txt");
		//Assert.assertTrue(buscarSKUPage.BuscarPorSKU(),"No encontro el producto:");
				    
        //*********Cerrar sesión***********************
		LogonPage logonPage=new LogonPage(driver);
		logonPage.Logon();
		//Assert.assertTrue(logonPage.Logon(),"No se pudo cerrar la sesión");
	        
        //************Desloguearse*********************
		CloseQuitPage closeQuitPage= new CloseQuitPage(driver);
		closeQuitPage.Close();   
             
	}
}