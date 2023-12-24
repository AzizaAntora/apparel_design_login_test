import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	@Test
	public void loginTest() {

		// Initialize ChromeDriver
		WebDriver driver = new ChromeDriver();

		// Navigate to the login page
		driver.get("https://automationexercise.com/login");
		driver.manage().window().maximize();
		
		// Locate the email and password fields
		WebElement emailField = driver.findElement(By.name("email"));
		WebElement passwordField = driver.findElement(By.name("password"));

		// Enter email and password
		emailField.sendKeys("validusername@example.com");
		passwordField.sendKeys("password123");

		// Locate and click the login button
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
		loginButton.click();

		// Wait for the dashboard page to load 

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/"));

		// Verification - Check if the dashboard page is loaded
		String expectedURL = "https://automationexercise.com/";
		String currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, expectedURL);

		// Close the browser
		driver.quit();
	}
}
