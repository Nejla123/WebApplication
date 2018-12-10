package test.regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import model.Login;

public class LoginInvalidInput {
	private WebDriver driver;
	private Login login;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail%com";
	private String loginPasswordField = "probniemail";

	@BeforeTest
	public void setupEnviromnent() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login = new Login(driver);

	}

	@Test(priority = 1)
	public void testLoginInvalidInput() {
		driver.get(baseURL);
		login.clickOnLoginLink();

		login.setLoginEmailField(loginEmailField);
		login.setLoginPasswordField(loginPasswordField);

		WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[1]/p"));
		String message = login.getAttribute("class");
		AssertJUnit.assertEquals(message, "help-block");
		driver.close();

	}
}