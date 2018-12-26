package adminPanel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.Admin;
import model.MakeFreeReservation;

public class AddRestaurant {
	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private Admin admin;

	//
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "ridvan_appa@hotmail.com";
	private String loginPasswordField = "admin";
	private String descriptionField = "Very good.";
	private String nameFieldForDish1 = "Musaka";
	private String priceOfDish1 = "10";
	// private String uploadLogoImage1 = "C:\\Users\\Nejla\\Desktop\\navigator
	// slike\\bug1.png";
	// slike\\slikazanina.jpg";

	@BeforeTest
	public void setupEnviromnent() {

		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
		admin = new Admin(setupEnviroment.getDriver());
		// admin = makeReservation.getAdmin();
		makeReservation = admin.getMakeReservatiom();

	}

	@Test(priority = 1)
	public void testAddRestaurant() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		admin.clickOnAdminLink();
		admin.clikcOnRestaurantSection();
		admin.clickOnAddRestaurantButton();
		// admin.clickOnUploadLogo("uploadLogoImage1");
		admin.setNameField();
		admin.clickOnCategory();
		// admin.uploadCoverPhoto("C:\\Users\\Nejla\\Desktop\\navigator
		// slike\\bug1.png1");
		admin.chooseCountry();
		admin.chooseCity();
		admin.setDescription(descriptionField);
		makeReservation.scrollDown();
		admin.choosePriceRange();
		makeReservation.scrollToTop();
		admin.clickOnMenuSection();
		admin.setNameOfDish(nameFieldForDish1);
		admin.chooseTypeOfDish();
		admin.setPrice(priceOfDish1);

	}
}
