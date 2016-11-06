package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest7 {

	WebDriver driver;

	@Before
	public void maakSeleniumKlaar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void gaNaarImmoweb() throws InterruptedException {

		driver.get("http://www.immoweb.be/");
		slaap();
		driver.findElement(By.partialLinkText("NEDERLANDS")).click();
		slaap();
		driver.findElement(By.xpath(".//*[@id='nav-menu']/ul/li[2]/a")).click();
		slaap();
		driver.findElement(By.xpath(".//*[@id='footerAnnuairePays']/div[3]/div/ul/li[1]/h3/a")).click();

		WebElement tekstVeldje = driver.findElement(By.xpath(".//*[@id='xprice1']"));

		drukBackspace(tekstVeldje, 3);
		
		tekstVeldje.sendKeys("400");

		slaap();
		WebElement tekstVeld = driver.findElement(By.xpath(".//*[@id='xprice2']"));

		drukBackspace(tekstVeld, 3);

		tekstVeld.sendKeys("800");

		slaap();
		WebElement tekstVeldStad = driver.findElement(By.xpath(".//*[@id='localisation']"));

		drukBackspace(tekstVeldStad, 28);

		tekstVeldStad.sendKeys("Hemiksem 2620");

		driver.findElement(By.xpath(".//*[@id='changecategorie']/a/strong")).click();
		driver.findElement(By.xpath(".//*[@id='column-central']/div/div[1]/table/tbody/tr[1]/td[1]/input")).click();
		driver.findElement(By.xpath(".//*[@id='column-central']/div/div[1]/table/tbody/tr[1]/td[1]/input")).click();

		// new
		// Actions(driver).moveToElement(driver.findElement(By.xpath(".//*[@id='column-central']/div/div[1]/table/tbody/tr[1]/td[1]/input"))).click().perform();

		driver.findElement(By.xpath(".//*[@id='column-central']/div/div[1]/table/tbody/tr[1]/td[2]/input")).click();

	}

	private void slaap() throws InterruptedException {
		Thread.sleep(2000);
	}

	private void drukBackspace(WebElement tekstVeld, int getal) {
		for (int i = 0; i < getal; i++) {
			tekstVeld.sendKeys(Keys.BACK_SPACE);
		}
	}
}