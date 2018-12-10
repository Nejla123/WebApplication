package test.regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import model.MakeFreeReservation;

public class MakeReservationNoInputData {
	private WebDriver driver;
	private MakeFreeReservation makeReservation;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";

	@BeforeTest
	public void setupEnviromnent() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		makeReservation = new MakeFreeReservation(driver);

	}

	@Test(priority = 1)
	public void testMakeReservationNoInputData() throws InterruptedException {
		driver.get(baseURL);
		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnFindTableButton();

		WebElement tooltipBellowTheField = driver
				.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/form/div/div[4]/input"));
		String messageBellowTheField1 = tooltipBellowTheField.getAttribute("class");
		AssertJUnit.assertEquals(messageBellowTheField1,
				"form-control home-form-control ng-pristine ng-untouched ng-empty ng-valid-min ng-valid-max ng-invalid ng-invalid-required");

		driver.close();

	}

}