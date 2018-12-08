package test.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import model.MakeFreeReservation;

@Test
public class SmokeTest {

	private WebDriver driver;
	private MakeFreeReservation makeReservation;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";
	private String searchBarField = "Panera";
	private String guestsField = "3";
	private String dayField = "30";
	private String monthField = "Dec";
	private String yearField = "2018";
	private String timeField1 = "2";
	private String timeField2 = "00";

	@BeforeTest
	public void setupEnviromnent() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		makeReservation = new MakeFreeReservation(driver);

	}

	public void testMakeFreeReservation() throws InterruptedException {
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
		makeReservation.scrollDown2();

		makeReservation.clickOnObject();

		makeReservation.clickOnFindTableButton2();
		makeReservation.clickOnNearestTimeButton();
		makeReservation.scrollDown();
		// makeReservation.clickOnCompleteReservationButton();
		makeReservation.clickOnMyReservationLink();

		WebElement completedReservation = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/button/div[1]"));
		String title = completedReservation.getAttribute("class");
		AssertJUnit.assertEquals(title, "col-xs-4 col-info ng-binding");
	}
}
