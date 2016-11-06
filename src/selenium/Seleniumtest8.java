package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Seleniumtest8 extends AbstractSeleniumTest {

	@Test
	public void testDatDeCaptchaWerkt() throws InterruptedException {
		gaNaarFormulierGezinszorg();
		vulFormulierIn();
		verzendFormulier();

		assertTextPresent("captcha");

	}

	@Test
	public void testDatVerplichteVeldeWordenGecontroleerd() throws InterruptedException {
		gaNaarFormulierGezinszorg();
		vulFormulierIn();
		WebElement tekstVeldNaam = driver.findElement(By.name("naam"));
		drukBackspace(tekstVeldNaam, 4);
		verzendFormulier();
		
		assertTextPresent("Gelieve de volgende velden in te vullen");
		assertTextPresent("naam");

	}

	private void verzendFormulier() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='aanvraag']/table/tbody/tr/td/table/tbody/tr[21]/td/input")).click();
		Thread.sleep(5000);
	}

	private void doeCaptcha() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='ajax-fc-task']/li[5]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ajax-fc-circle']")).click();
		Thread.sleep(2000);
	}

	private void gaNaarFormulierGezinszorg() throws InterruptedException {
		driver.get("http://www.thuiszorgvleminckveld.be/");
		driver.findElement(By.xpath(".//*[@id='list-menu']/a[11]")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Klik hier als u een aanvraag voor gezinszorg ")).click();
		Thread.sleep(2000);
	}

	private void vulFormulierIn() throws InterruptedException {
		WebElement naam = driver.findElement(By.xpath(".//*[@id='aanvraag']/table/tbody/tr/td/table/tbody/tr[2]/td[3]/input"));
		naam.sendKeys("Test");
		Thread.sleep(2000);
		WebElement voorNaam = driver.findElement(By.xpath(".//*[@id='aanvraag']/table/tbody/tr/td/table/tbody/tr[3]/td[3]/input"));
		voorNaam.sendKeys("Test2");
		WebElement straat = driver.findElement(By.name("straat"));
		straat.sendKeys("Bloemenlaan");
		WebElement huisNr = driver.findElement(By.name("nummer"));
		huisNr.sendKeys("25");
		WebElement telNr = driver.findElement(By.name("telefoon"));
		telNr.sendKeys("0499257893");
		WebElement postCode = driver.findElement(By.xpath(".//*[@id='aanvraag']/table/tbody/tr/td/table/tbody/tr[6]/td[3]/select"));
		postCode.sendKeys("antwerpen");
		WebElement eMail = driver.findElement(By.name("aemail"));
		eMail.sendKeys("Test@hotmail.com");
		WebElement ziekenFonds = driver.findElement(By.name("ziekenfonds"));
		ziekenFonds.sendKeys("partena");
		WebElement aanVraag = driver.findElement(By.name("aanvrager"));
		aanVraag.sendKeys("Ziekenhuis");
		WebElement ziekenHuis = driver.findElement(By.xpath(".//*[@id='aanvraag']/table/tbody/tr/td/table/tbody/tr[11]/td/table/tbody/tr[2]/td[3]/input"));
		ziekenHuis.sendKeys("UZA");
		WebElement ziekenHuisTel = driver.findElement(By.name("telefoon_aanvrager"));
		ziekenHuisTel.sendKeys("03866458269");
		WebElement Waarom = driver.findElement(By.name("waarom"));
		Waarom.sendKeys("Ik ben bedliggend en ik kan niks meer");
		WebElement andereContactPers = driver.findElement(By.name("contactpersonen"));
		andereContactPers.sendKeys("Nee ik heb geen familie");
		WebElement andereOpmerkingen = driver.findElement(By.name("opmerkingen"));
		andereOpmerkingen.sendKeys("Ik heb ook poetshulp nodig");
	}
}
