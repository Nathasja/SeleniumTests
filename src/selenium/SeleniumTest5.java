package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest5 {

	WebDriver driver;

	@Before
	public void maakSeleniumKlaar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void gaNaarGva() throws InterruptedException {

		driver.get("http://www.gva.be");
		driver.findElement(By.partialLinkText("Hondje wil muizen vangen")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Dineren op 90 meter hoogte ")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("k hoef niet te scoren, ik geef de assists")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/header/div[2]/div/a/img")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText(" Meld je aan op gva")).click();
		WebElement tekstVeld = driver.findElement(By.id("input-email--login"));
		tekstVeld.sendKeys("Ronny");
		WebElement passWoord = driver.findElement(By.xpath(".//*[@id='input-password']"));
		passWoord.sendKeys("Test");
		driver.findElement(By.xpath(".//*[@id='login-form']/fieldset/div/div[5]/div/input")).click();
		Thread.sleep(5000);
		driver.quit();


		
		

	}
}