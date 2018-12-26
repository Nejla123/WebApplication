package model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin {
	MakeFreeReservation makeReservation;
	private WebDriver driver;

	@FindBy(xpath = "//*[@id=\"js-navbar-collapse\"]/ul/li[4]/a")
	WebElement adminLink;

	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[2]/a")
	WebElement restaurantSectionInAdmin;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[2]/button")
	WebElement addRestaurantButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[1]/div[1]/label[1]")
	WebElement uploadLogoImage;

	@FindBy(xpath = "//*[@id=\"restaurantName\"]")
	WebElement nameField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[3]/div[1]/div[3]/select")
	WebElement category;

	@FindBy(className = "uploadcover")
	WebElement uploadCoverPhoto;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[2]/div[2]/div[1]/select")
	WebElement countryField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[2]/div[2]/div[2]/select")
	WebElement cityField;

	@FindBy(xpath = "//*[@id=\"resDescription\"]")
	WebElement descriptionField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[4]/div[2]/select")
	WebElement priceRange;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/ul/li[2]/a")
	WebElement menuSection;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[2]/div[2]/input[1]")
	WebElement nameFieldForDish1;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[2]/div[3]/select")
	WebElement typeOfDish1;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[2]/div[4]/input")
	WebElement priceOfDish1;

	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[3]/a")
	WebElement locationsSection;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[1]/div[1]/ul/li[2]/button")
	WebElement addLocationButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[2]/form[1]/div/div[1]/div[1]/input")
	WebElement locationNameField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[2]/form[1]/div/div[1]/div[2]/input")
	WebElement existingOrNewCountryField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[2]/form[1]/div/div[2]/div[2]/button")
	WebElement createLocationButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[2]/form[1]/div/div[1]/div[1]/div")
	WebElement createdLocationAlert;

	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[4]/a")
	WebElement categoriesSection;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div[1]/div[1]/ul/li[2]")
	WebElement addCategoryButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div[2]/form[1]/div/div[1]/input")
	WebElement categoryNameField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div[2]/form[1]/div/div[2]/div[2]/button")
	WebElement createCategoryButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div[2]/form[1]/div/div[1]/div")
	WebElement createdCategoryAlert;

	public Admin(WebDriver driver) {
		this.driver = driver;
		makeReservation = new MakeFreeReservation(driver);

		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminLink() {
		adminLink.click();
	}

	public void clikcOnRestaurantSection() {
		restaurantSectionInAdmin.click();
	}

	public void clickOnAddRestaurantButton() {
		addRestaurantButton.click();
	}

	public MakeFreeReservation getMakeReservatiom() {
		return makeReservation;
	}

	public void clickOnUploadLogo(String uploadLogoImage1) {
		uploadLogoImage.click();
		uploadLogoImage.sendKeys("uploadLogoImage1");
	}

	public void setNameField() {
		nameField.sendKeys("Mrkva");
	}

	public void clickOnCategory() {
		category.click();
		category.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void uploadCoverPhoto(String uploadLogoImage1) throws InterruptedException {
		uploadCoverPhoto.click();
		uploadCoverPhoto.sendKeys("C:\\Users");
		Thread.sleep(1000);
	}

	public void chooseCountry() {
		countryField.click();
		countryField.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void chooseCity() {
		cityField.click();
		cityField.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void setDescription(String descriptionField2) {
		descriptionField.sendKeys(descriptionField2);
	}

	public void choosePriceRange() {
		priceRange.click();
		priceRange.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void clickOnMenuSection() {
		menuSection.click();
	}

	public void setNameOfDish(String nameFieldForDish12) {
		nameFieldForDish1.sendKeys(nameFieldForDish12);
	}

	public void chooseTypeOfDish() {
		typeOfDish1.click();
		typeOfDish1.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void setPrice(String priceOfDish12) {
		priceOfDish1.sendKeys(priceOfDish12);
	}

	public void clickONLocationsSection() {
		locationsSection.click();
	}

	public void setLocationNameField(String locationNameField2) {
		locationNameField.sendKeys(locationNameField2);
	}

	public void setExistingOrNewCountryField(String existingOrNewCountryField2) {
		existingOrNewCountryField.sendKeys(existingOrNewCountryField2);
	}

	public void clickOnCreateLocationButton() {
		createLocationButton.click();
	}

	public String getCreatedLocationClass() {
		String alert = createdLocationAlert.getAttribute("class");
		return alert;
	}

	public void clickOnAddLocationButton() {
		addLocationButton.click();
	}

	public void clickOnCategoriesSection() {
		categoriesSection.click();
	}

	public void clickOnAddCategeryButton() {
		addCategoryButton.click();

	}

	public void setCategoryNameField(String categoryNameField2) {
		categoryNameField.sendKeys(categoryNameField2);
	}

	public void clickOnCreateCategoryButton() {
		createCategoryButton.click();
	}

	public String getCreatedCategoryClass() {
		String alertForCreatedCategory = createdCategoryAlert.getAttribute("class");
		return alertForCreatedCategory;
	}

}
