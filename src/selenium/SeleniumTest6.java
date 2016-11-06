package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest6 {
	WebDriver driver;

	@Before
	public void maakSeleniumKlaar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void gaNaarAction() throws InterruptedException {

		driver.get("http://www.action.be");
		driver.findElement(By.partialLinkText("100 nieuwste")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='page']/div[6]/div[1]/div/div[3]/ul/li[14]/div/a/img")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='product_addtocart_form']/div[3]/div/div[2]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Weekaanbiedingen")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("100 nieuwste")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page']/div[6]/div[1]/div/div[3]/ul/li[93]/div/a/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='product_addtocart_form']/div[3]/div/div[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page']/div[3]/nav/div[2]/ul/li[5]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='sidebar']/div/ul/li[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='page']/div[5]/div[2]/div[1]/div/div[2]/ul/li[2]/div/a/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Zet op mijn lijstje")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("my-action-login")).click();
		WebElement tekstVeldEmail = driver.findElement(By.id("email"));
		tekstVeldEmail.sendKeys("slonske@hotmail.com");
		Thread.sleep(2000);
		WebElement passWoord = driver.findElement(By.id("pass"));
		passWoord.sendKeys("olleke");
		driver.findElement(By.xpath(".//*[@id='send2']")).click();
		
		boolean p = driver.getPageSource().contains("Ongeldige gebruikersnaam en/of wachtwoord.");

		if (p == false) {
			Assert.fail("");
			
	     

	}
	}
}