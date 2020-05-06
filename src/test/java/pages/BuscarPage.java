//***Autor: Patricia Silva Vergara
//***Fecha de creación:11-03-2019
//***Fecha de ultima modificación: 13-03-2019
//***Descripción: Permite buscar un producto.

package com.falabella.templateautomationfront.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

public class BuscarPage extends BasePage{
	private WebDriver  driver;
	public BuscarPage (WebDriver driver) {
		this.driver= driver;
    	PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//font[contains(text(),'Bienvenido de nuevo a Mercury Tours! ')]")
    private WebElement lblLogon; 
	
	@FindBy(name = "Ntt")
    private WebElement txtSearch;
    
public boolean  BuscarProducto(String producto) {
	//System.out.println("el objeto es:" + lblOrdenarPor.isDisplayed());
	txtSearch.clear();	
	txtSearch.sendKeys(producto);
	txtSearch.sendKeys(Keys.ENTER);
	return lblOrdenarPor.isDisplayed();
 }

}
