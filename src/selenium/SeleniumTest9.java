package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Gegenereerd met de Selenium IDE
 */
public class SeleniumTest9 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.badchix.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSeleniumTest9() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//img[@alt='Vegetarian eat meat for the first time in 22 years'])[3]")).click();
    driver.findElement(By.cssSelector("button.ytp-large-play-button.ytp-button")).click();
    driver.findElement(By.cssSelector("button.ytp-play-button.ytp-button")).click();
    driver.findElement(By.cssSelector("img.cb-fi-standard.wp-post-image")).click();
    assertEquals("Vegetarian eat meat for the first time in 22 years", driver.findElement(By.xpath("//div[@id='cb-fis-wrap']/span/h1")).getText());
    driver.findElement(By.cssSelector("button.ytp-large-play-button.ytp-button")).click();
    driver.findElement(By.cssSelector("div.ytp-volume-slider-handle")).click();
    driver.findElement(By.xpath("(//img[@alt='Daily Fresh Baked Randomness (45 Photos)'])[2]")).click();
    assertEquals("Daily Fresh Baked Randomness (45 Photos)", driver.findElement(By.xpath("//div[@id='cb-fis-wrap']/span/h1")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
