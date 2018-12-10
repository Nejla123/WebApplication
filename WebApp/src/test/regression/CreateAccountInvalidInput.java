package test.regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import model.CreateAccount;

public class CreateAccountInvalidInput {

	public class CreateAccountFillFields {
		private WebDriver driver;
		private CreateAccount createAccount;
		private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
		private String firstNameField = "Amy";
		private String lastNameField = "Rey";
		private String emailField = "amy1234mail.com";
		private String phoneNumberField = "0330&/$%111";

		@BeforeTest
		public void setupEnviromnent() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			createAccount = new CreateAccount(driver);

		}

		@Test(priority = 1)
		public void testCreateAccountInvalidInput() {

			driver.get(baseURL);

			createAccount.clickOnLoginLink();
			createAccount.clickOnCreateAccountLink();
			createAccount.setFirstName(firstNameField);
			createAccount.setLastName(lastNameField);
			createAccount.setEmail(emailField);

			WebElement invalidEmail = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[3]/p"));
			String message = invalidEmail.getAttribute("class");
			AssertJUnit.assertEquals(message, "help-block");

			WebElement invalidEmailField = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[3]"));
			String highlighedEmailField = invalidEmailField.getAttribute("class");
			AssertJUnit.assertEquals(highlighedEmailField, "form-group formg has-error");

			createAccount.setPhoneNumber(phoneNumberField);

			WebElement invalidPhoneNumber = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[4]"));
			String highlighedPhoneNumberField = invalidPhoneNumber.getAttribute("class");
			AssertJUnit.assertEquals(highlighedPhoneNumberField, "form-group formg");

			driver.close();

		}
	}

}
