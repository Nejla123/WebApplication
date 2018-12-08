package test.regression;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import model.CreateAccount;

public class CreateAccountFillFields {
	private WebDriver driver;
	private CreateAccount createAccount;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String firstNameField = "Amy";
	private String lastNameField = "Rey";
	private String email;
	private int emailPrefixLenght = 5;
	private String emailSufix = "@gmail.com";
	private String phoneNumberField = "037800111";
	private String passwordField = "apple12";
	private String confirmPassword = "apple12";

	public void generateRandomEmail() {

		String allowedCharacters = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		String randomEmailPrefix = "";
		for (int i = 0; i < emailPrefixLenght; i++) {
			// length of the random string.
			int index = random.nextInt(allowedCharacters.length());
			char randomCharacter = allowedCharacters.charAt(index);
			randomEmailPrefix = randomEmailPrefix + randomCharacter;
		}
		email = randomEmailPrefix + emailSufix;

	}

	@BeforeTest
	public void setupEnviromnent() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		createAccount = new CreateAccount(driver);

	}

	@Test
	public void testCreateAccountFillField() {

		driver.get(baseURL);

		createAccount.clickOnLoginLink();
		createAccount.clickOnCreateAccountLink();
		createAccount.setFirstName(firstNameField);
		createAccount.setLastName(lastNameField);
		generateRandomEmail();
		createAccount.setEmail(email);
		createAccount.setPhoneNumber(phoneNumberField);
		createAccount.chooseCountry();
		createAccount.chooseCity();
		createAccount.setPassword(passwordField);
		createAccount.confirmPassword(confirmPassword);
		createAccount.clickOnCreateAccountbutton();

		WebElement createdAccount = driver.findElement(By.xpath("/html/body/div[2]/div/form/ul/li[1]/h3"));
		String title = createdAccount.getAttribute("class");
		AssertJUnit.assertEquals(title, "login-h3");

		driver.close();

	}

}
