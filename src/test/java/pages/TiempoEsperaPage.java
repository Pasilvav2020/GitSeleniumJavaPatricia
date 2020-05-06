package pages;

import org.openqa.selenium.WebDriver;

public class TiempoEsperaPage {
    private WebDriver driver;
	public TiempoEsperaPage(WebDriver driver) {
		this.driver=driver;
				
	}
	public void sleepSeconds(int seconds) {
		try {
		   Thread.sleep(seconds*1000);
		
		}catch(InterruptedException ie){
			ie.printStackTrace();
			
		}
		
	}

}
