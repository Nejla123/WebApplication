package test.regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import model.MakeFreeReservation;

public class BookFromSectionRestaurants {
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
	private String time3FieldForFilteringObject = "pm";

	@BeforeTest
	public void setupEnviromnent() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); <--- ceka na page load da izvrsi JS code

		makeReservation = new MakeFreeReservation(driver);

	}

	@Test
	public void testBookFromSectionRestaurants() throws InterruptedException {
		driver.get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnHomeLink();

		makeReservation.clickOnRestaurantsLink();

		makeReservation.clickOnFindByButton();
		// makeReservation.clickOnPrice();
		makeReservation.clickOnRate();
		// makeReservation.clickOnAmericanCousine();
		// makeReservation.clickOnFastFoodCousine();
		makeReservation.clickOnFilterSearchButton();
		makeReservation.clickOnFilteredObject();

		makeReservation.clickOnAboutField();

		makeReservation.scrollToTop();
		makeReservation.clickOnMenuButton();
		makeReservation.clickOnLunchButton();
		makeReservation.clickOnDinnerButton();

		makeReservation.clickOnShowFullMenuButton();
		makeReservation.scrollToTop();
		makeReservation.clickOnReviewsButton();
		makeReservation.scrollToTop();

		makeReservation.setGuestesForFilteredObject(guestsForFilteredObject);
		makeReservation.setDayForFilteredObject(dayForFilteredObject);
		makeReservation.setMonthForFilteredObject(monthForFilteredObject);
		makeReservation.setYearForFilteredObject(yearForFilteredObject);
		makeReservation.setTime1FieldForFilteringObject(time1FieldForFilteringObject);
		makeReservation.setTime2FieldForFilteringObject2(time2FieldForFilteringObject);
		// makeReservation.chooseDurationForFilteredObject();
		makeReservation.clickOnFindTableForFilteredObject();
		makeReservation.clickOnNearestTimeForFilteredObject();
		makeReservation.scrollDown();
		makeReservation.clickOnCompleteReservationButton();

	}

}
