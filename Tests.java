package forms;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
	String url;

	WebDriver driver;

	@Before
	public void setUp() {
		url = "https://forms.liferay.com/web/forms/shared/-/form/122548";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\catar\\estudos-workspace\\forms\\drivers\\chrome\\95\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void descriptionMessage() {
		// The text “party rock” must be present in the form

		driver.get(url);

		String formDescription = "Let's party rock.";

		assertEquals(formDescription, driver.findElement(By.className("lfr-ddm-form-page-description")).getText());
	}

	@Test
	public void requiredFields() {
		// All fields must be mandatory and contain an error message if they are not
		// filled

		driver.get(url);

		driver.findElement(By.id("ddm-form-submit")).sendKeys(Keys.ENTER);

		String requirementMessage = "This field is required.";

		assertEquals(requirementMessage,
				driver.findElement(
						By.xpath("//div[@class=\"col-ddm col-md-7\"]//div[contains(@class,'form-feedback-item')]"))
						.getText());

		assertEquals(requirementMessage,
				driver.findElement(
						By.xpath("//div[@class=\"col-ddm col-md-5\"]//div[contains(@class,'form-feedback-item')]"))
						.getText());

		assertEquals(requirementMessage,
				driver.findElement(
						By.xpath("//div[@class=\"col-ddm col-md-12\"]//div[contains(@class,'form-feedback-item')]"))
						.getText());
	}

	@Test
	public void successfulMessage() {
		// A successful message should appear after the form has been successfully
		// submitted

		driver.get(url);

		WebElement inputName = driver.findElement(By.cssSelector("Input[class*='form-control ddm-field-text'"));

		inputName.sendKeys("Catarine");

		WebElement inputQuestion = driver.findElement(By.cssSelector("Textarea[class*='ddm-field-text form-control'"));

		inputQuestion.sendKeys("Because I'm curious and perfectionist");

		// Select date of birth, submit and assert success message
	}
}
