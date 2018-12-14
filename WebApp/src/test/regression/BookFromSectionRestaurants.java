package test.regression;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnviroment;
import model.MakeFreeReservation;
import model.Menu;

public class BookFromSectionRestaurants {

	private SetupEnviroment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private Menu menu;
	//
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

		setupEnviroment = new SetupEnviroment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
		menu = makeReservation.getMenu();

	}

	@Test(priority = 1)
	public void testBookFromSectionRestaurants() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnHomeLink();
		makeReservation.clickOnRestaurantsLink();

		makeReservation.clickOnFindByButton();
		makeReservation.clickOnRate();
		makeReservation.clickOnFilterSearchButton();
		makeReservation.clickOnFilteredObject();
//		makeReservation.clickOnAboutField();
		menu.clickOnAboutButton();

		String aboutHeaderClass = menu.getAboutHeaderClass();
		Assert.assertEquals(aboutHeaderClass, "restaurant-h5 ng-binding");

		String aboutDescriptionClass = menu.getAboutDescriptionClass();
		Assert.assertEquals(aboutDescriptionClass, "desc restaurant-h6");

		makeReservation.scrollToTop();
		menu.clickOnMenuButton();

		String menuClass = menu.getMenuClass();
		Assert.assertEquals(menuClass, "container-card ng-scope");

		makeReservation.clickOnLunchButton();
		makeReservation.clickOnDinnerButton();
		makeReservation.clickOnShowFullMenuButton();
		makeReservation.scrollToTop();
		menu.clickOnReviewsButton();

//		WebElement titleReview = driver.findElement(By.xpath("//*[@id=\"Reviews\"]/h5"));
//		String reviewSection = titleReview.getAttribute("class");
//		AssertJUnit.assertEquals(reviewSection, "h5-heading-reservation review-h5 restaurant-h5");

		String reviewClass = menu.getReviewClass();
		Assert.assertEquals(reviewClass, "h5-heading-reservation review-h5 restaurant-h5");

		makeReservation.scrollToTop();
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

//		WebElement tooltip1 = driver
//				.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/button[1]"));
//		String message1 = tooltip1.getAttribute("class");
//		Assert.assertEquals(message1, "row-reservation btn-block ng-scope");

		String toolTip1Class = makeReservation.getToolTip1Class();
		Assert.assertEquals(toolTip1Class, "row-reservation btn-block ng-scope");

		setupEnviroment.getDriver().close();

		System.out.println("Finished regression ");

	}

}
