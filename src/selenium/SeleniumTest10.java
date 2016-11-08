package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest10 {

	WebDriver driver;

	@Before
	public void maakSeleniumKlaar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void gaNaarGoogle() throws InterruptedException {

		driver.get("http://www.google.com/");
		slaap();
		WebElement tekstGoogle = driver.findElement(By.id("gs_htif0"));
		tekstGoogle.sendKeys("Reizen");
		slaap();
		driver.findElement(By.id("sblsbb")).click();
		driver.findElement(By.xpath(".//*[@id='rso']/div/div/div[3]/div/h3/a")).click();
		slaap();
		driver.findElement(By.id("QsmSingleSelect_prXpromo_3")).click();
		slaap();
		driver.findElement(By.xpath(".//*[@id='BoxStunt']/div/h2/a")).click();
		slaap();
		driver.findElement(By.xpath(".//*[@id='footer']/div/div[2]/div[2]/div/div/div[1]/ul/li[5]/a")).click();
		slaap();
		driver.findElement(By.xpath(".//*[@id='QsmListerOrFullTextSearch_/sitecore/content/eComHome/Configuration/Common/Components/QSM/SOLR/VelocityQsmMainSki_label']")).click();
		slaap();
		driver.findElement(By.xpath(".//*[@id='QsmListerOrFullTextSearch_/sitecore/content/eComHome/Configuration/Common/Components/QSM/SOLR/VelocityQsmMainSki']")).click();
		slaap();
		driver.findElement(By.id("QsmSelect_Title_4")).click();
		slaap();

	}

	private void slaap() throws InterruptedException {
		Thread.sleep(2000);
	}

}