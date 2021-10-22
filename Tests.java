package forms;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
	String url;
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		url = "https://forms.liferay.com/web/forms/shared/-/form/122548";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\catar\\estudos-workspace\\forms\\drivers\\chrome\\95\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void descriptionMessage() {
	// The text “party rock” must be present in the form
		
		
	}
	
	@Test
	public void requiredFields() {
	// All fields must be mandatory and contain an error message if they are not filled
		
		
	}
	
	@Test
	public void successfulMessage() {
	// A successful message should appear after the form has been successfully submitted
		
		
	}
}
