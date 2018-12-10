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

public class MakeReservationFromPopularLocations {
	private WebDriver driver;
	private MakeFreeReservation makeReservation;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";
	private String guestsForFilteredObject = "2";
	private String dayForFilteredObject = "28";
	private String monthForFilteredObject = "Dec";
	private String yearForFilteredObject = "2018";
	private String time1FieldForFilteringObject = "02";
	private String time2FieldForFilteringObject = "00";

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
	public void testMakeReservationFromPopularLocations() throws InterruptedException {
		driver.get(baseURL);
		makeReservation.clickOnLoginLink();

		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnHomeLink();
		makeReservation.scrollDownPopularLocation();

		WebElement section = driver.findElement(By.xpath("/html/body/div[2]/div[4]/h3"));
		String titlePopularLocations = section.getAttribute("class");
		AssertJUnit.assertEquals(titlePopularLocations, "text-center container-h3");

		makeReservation.clickOnPopularLocationCity();
		makeReservation.clickOnPopularLocationRestaurant();
		makeReservation.setGuestesForFilteredObject(guestsForFilteredObject);
		makeReservation.setDayForFilteredObject(dayForFilteredObject);
		makeReservation.setMonthForFilteredObject(monthForFilteredObject);
		makeReservation.setYearForFilteredObject(yearForFilteredObject);
		makeReservation.setTime1FieldForFilteringObject(time1FieldForFilteringObject);
		makeReservation.setTime2FieldForFilteringObject2(time2FieldForFilteringObject);
		makeReservation.clickOnFindTableForFilteredObject();
		makeReservation.clickOnNearestTimeForFilteredObject();
		makeReservation.scrollDown();
		makeReservation.clickOnCompleteReservationButton();
		makeReservation.clickOnMyReservationLink();

		WebElement tooltip1 = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/button[3]"));
		String message1 = tooltip1.getAttribute("class");
		AssertJUnit.assertEquals(message1, "row-reservation btn-block ng-scope");

		driver.close();

	}
}
