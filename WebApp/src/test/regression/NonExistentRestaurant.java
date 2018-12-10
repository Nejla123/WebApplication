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

public class NonExistentRestaurant {
	private WebDriver driver;
	private MakeFreeReservation makeReservation;
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";
	private String searchBarField = "Mlinada";
	private String guestsField = "3";
	private String dayField = "30";
	private String monthField = "Dec";
	private String yearField = "2018";
	private String timeField1 = "2";
	private String timeField2 = "00";

	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";

	@BeforeTest
	public void setupEnviromnent() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		makeReservation = new MakeFreeReservation(driver);
	}

	@Test
	public void testNonExistentRestaurant() throws InterruptedException {
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

		WebElement title = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div"));
		String messageForNonExistentRestaurant = title.getAttribute("class");
		AssertJUnit.assertEquals(messageForNonExistentRestaurant, "no-results");
		driver.close();
	}

}
