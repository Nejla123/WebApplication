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

public class MakeReservationInvalidData {
	private WebDriver driver;
	private MakeFreeReservation makeReservation;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";
	private String searchBarField = "Metropolis";
	private String guestsField = "2e";
	private String dayField = "20";
	private String monthField = "Apr";
	private String yearField = "2018";
	private String timeField1 = "3";
	private String timeField2 = "30";

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
	public void testMakeReservationInvalidData() throws InterruptedException {

		driver.get(baseURL);
		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.setSearchBarField(searchBarField);
		makeReservation.setGuestsField(guestsField);
		makeReservation.setDay(dayField);
		makeReservation.setMonth(monthField);
		makeReservation.setYear(yearField);
		makeReservation.setTime1(timeField1);
		makeReservation.setTime2(timeField2);

		makeReservation.clickOnFindTableButton();

		WebElement tooltip1 = driver
				.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/form/div/div[2]/input"));
		String messageGuestsField = tooltip1.getAttribute("class");
		AssertJUnit.assertEquals(messageGuestsField,
				"form-control home-form-control ng-dirty ng-empty ng-invalid ng-invalid-number ng-touched");

		WebElement tooltip2 = driver
				.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/form/div/div[3]/input"));
		String messageDateField = tooltip2.getAttribute("class");
		AssertJUnit.assertEquals(messageDateField,
				"form-control home-form-control ng-not-empty ng-valid-max ng-dirty ng-valid-parse ng-invalid ng-invalid-min ng-touched");
		driver.close();
	}

}