package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractSeleniumTest {

	WebDriver driver;
	
	@Before
	public void maakSeleniumKlaar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void sluitSeleniumAf() {
		driver.quit();
	}
	
	public void assertTextPresent(String tekst){
		String paginaBron = driver.getPageSource();
		boolean paginaBevatTekst = paginaBron.contains(tekst);
		
		if (paginaBevatTekst == false){
			Assert.fail("Tekst niet gevonden op de pagina: " + tekst);
		}
	}
	public void drukBackspace(WebElement tekstVeld, int getal) {
		for (int i = 0; i < getal; i++) {
			tekstVeld.sendKeys(Keys.BACK_SPACE);
		}
	}
}
