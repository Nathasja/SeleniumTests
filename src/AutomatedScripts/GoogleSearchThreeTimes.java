package AutomatedScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchThreeTimes {

	private static int i;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.google.com");

		WebElement searchBox = driver.findElement(By.id("lst-ib"));

		WebElement searchButton = driver.findElement(By.name("btnG"));

		String searchTerms[] = { "google", "selenium", "automation" };

		String pageTitle = "";
		boolean titleContainsTerm = false;
		for (int i = 0; i < searchTerms.length; i++) {

		}
		searchBox.clear();
		searchBox.sendKeys(searchTerms[i]);

		searchButton.click();
		Thread.sleep(2000);
		pageTitle = driver.getTitle();

		titleContainsTerm = pageTitle.contains(searchTerms[i]);

		System.out.println(titleContainsTerm);

		if (pageTitle.contains(searchTerms[i])) {
			System.out.println("page title" + pageTitle);
			System.out.println("Search term:" + searchTerms[i]);
			System.out.println("page title contains the search term.");
			System.out.println("");

		} else
			System.out.println("page title" + pageTitle);
		System.out.println("Search term:" + searchTerms[i]);
		System.out.println("page title contains the search term.");
		System.out.println("");
	}

	// driver.quit();

}
