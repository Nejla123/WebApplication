package model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeFreeReservation {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"js-navbar-collapse\"]/ul/li[3]/a")
	WebElement loginLink;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement loginEmailField;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement loginPasswordField;

	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	WebElement loginButton;

	@FindBy(xpath = "/html/body/div[2]/div/form/ul/li[2]/p/a")
	WebElement createAccountLink;

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	WebElement firstNameField;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	WebElement lastNameField;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailField;

	@FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement phoneNumberField;

	@FindBy(xpath = "/html/body/div[2]/div/form/div[5]/div[1]/select")
	WebElement countryField;

	@FindBy(xpath = "/html/body/div[2]/div/form/div[5]/div[2]/select")
	WebElement cityField;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement passwordField;

	@FindBy(xpath = "//*[@id=\"confirmPassword\"]")
	WebElement confirmPassword;

	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	WebElement createAccountButton;

	@FindBy(xpath = "//*[@id=\"js-navbar-collapse\"]/ul/li[1]/a")
	WebElement homeLink;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/form/div/div[1]/input")
	WebElement searchBarField;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/form/div/div[2]/input")
	WebElement guestsField;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/form/div/div[3]/input")
	WebElement dayField;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/form/div/div[3]/input")
	WebElement monthField;
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/form/div/div[3]/input")
	WebElement yearField;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/form/div/div[4]/input")
	WebElement timeField1;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/form/div/div[4]/input")
	WebElement timeField2;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/form/div/div[5]/button")
	WebElement findTableButton;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/img")
	WebElement object;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[5]/button")
	WebElement findTableButton2;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/div[2]/button")
	WebElement nearestTimeButton;

	@FindBy(xpath = "/html/body/div[2]/div/div[3]/form/button")
	WebElement completeReservationButton;

	@FindBy(xpath = "//*[@id=\"js-navbar-collapse\"]/ul/li[3]/a")
	WebElement myReservation;

	@FindBy(xpath = "//*[@id=\"js-navbar-collapse\"]/ul/li[2]/a")
	WebElement restaurantsLink;

	@FindBy(xpath = "//*[@id=\"single-button\"]")
	WebElement findByButton;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/form/div[2]/div/ul/li[1]/ul/li[1]/ul/li[2]/span/span/i[5]")
	WebElement price;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/form/div[2]/div/ul/li[1]/ul/li[2]/ul/li[2]/span/span/i[5]")
	WebElement rate;

	@FindBy(xpath = "//*[@id=\"categorymultipleleft\"]/option[2]")
	WebElement americanCousine;

	@FindBy(xpath = "//*[@id=\"categorymultipleleft\"]/option[3]")
	WebElement fastFoodCousine;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/form/div[3]/button")
	WebElement filterSearchButton;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/button")
	WebElement filteredObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[1]/input")
	WebElement guestsForFilteredObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[2]/input")
	WebElement dayForFilteredObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[2]/input")
	WebElement monthForFilteredObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[2]/input")
	WebElement yearForFilteredObject;
//
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div[2]/a[2]")
	WebElement aboutButton;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div[2]/a[3]")
	WebElement menuButton;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div[2]/a[4]")
	WebElement reviewsBUtton;

	@FindBy(xpath = "//*[@id=\"Menu\"]/div[1]/label[2]")
	WebElement lunchButton;

	@FindBy(xpath = "//*[@id=\"Menu\"]/div[1]/label[3]")
	WebElement dinnerButton;

	@FindBy(xpath = "//*[@id=\"Menu\"]/button")
	WebElement showFullMenuButton;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[3]/input")
	WebElement time1FieldForFilteringObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[3]/input")
	WebElement time2FieldForFilteringObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[3]/input")
	WebElement time3FieldForFilteringObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[4]/select")
	WebElement durationForFilteredObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/form/div/div[4]/button")
	WebElement findTableForFilteredObject;

	@FindBy(xpath = "//*[@id=\"Reservation\"]/div[2]/button[1]")
	WebElement nearestTimeForFilteredObject;

	@FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/button/h4")
	WebElement popularLocationCity;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/button")
	WebElement popularLocationRestaurant;

	public MakeFreeReservation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setSearchBarField(String string) {
		searchBarField.sendKeys(string);
	}

	public void setGuestsField(String string) throws InterruptedException {
		guestsField.sendKeys(string);
		guestsField.sendKeys(Keys.TAB);
	}

//	public void setDate(String string, String string2, String string3) throws InterruptedException {
//		dateField.sendKeys(string);
//		dateField.sendKeys(Keys.ARROW_RIGHT);
//		dateField.sendKeys(string2);
//		dateField.sendKeys(Keys.ARROW_RIGHT);
//		dateField.sendKeys(string3);
//		dateField.sendKeys(Keys.TAB);
//
//	}

//	public void setTime(String string, String string2) throws InterruptedException {
//		timeField.sendKeys(string);
//		timeField.sendKeys(string2);
//
//		timeField.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//
//	}

	public void clickOnFindTableButton() throws InterruptedException {
		findTableButton.click();
		Thread.sleep(1000);

	}

	public void clickOnObject() throws InterruptedException {
		Thread.sleep(1000);
		object.click();

	}

	public void clickOnFindTableButton2() throws InterruptedException {
		findTableButton2.click();

	}

	public void clickOnNearestTimeButton() throws InterruptedException {
		nearestTimeButton.click();

	}

	public void scrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);

	}

	public void scrollDown2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(100,400)");
		Thread.sleep(1000);

	}

	public void clickOnLoginLink() {
		loginLink.click();
	}

	public void clickOnCreateAccountLink() {
		createAccountLink.click();
	}

	public void setFistName(String string) {
		firstNameField.sendKeys(string);

	}

	public void setLastName(String string) {
		lastNameField.sendKeys(string);
	}

	public void setEmail(String string) {
		emailField.sendKeys(string);
	}

	public void setPhoneNumber(String string) {
		phoneNumberField.sendKeys(string);

	}

	public void chooseCountry() throws InterruptedException {
		countryField.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

	}

	public void chooseCity() {
		cityField.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void setPassword(String string) {
		passwordField.sendKeys(string);
	}

	public void confirmPassword(String string) {
		confirmPassword.sendKeys(string);
	}

	public void clickOnCreateAccountButton() {
		createAccountButton.click();
	}

	public void clickOnHomeLink() {
		homeLink.click();
	}

	public void setLoginEmailField(String string) {
		loginEmailField.sendKeys(string);
	}

	public void setLoginPasswordField(String string) {
		loginPasswordField.sendKeys(string);

	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public void clickOnCompleteReservationButton() throws InterruptedException {
		completeReservationButton.click();
		Thread.sleep(2000);
	}

	public void clickOnMyReservationLink() throws InterruptedException {
		myReservation.click();
		Thread.sleep(1000);

	}

	public void setDay(String dayField1) throws InterruptedException {
		dayField.sendKeys(dayField1);
		dayField.sendKeys(Keys.TAB);

	}

	public void setMonth(String monthField2) {
		monthField.sendKeys(monthField2);
		monthField.sendKeys(Keys.ARROW_RIGHT);

	}

	public void setYear(String yearField2) {
		yearField.sendKeys(yearField2);
		yearField.sendKeys(Keys.TAB);

	}

	public void setTime1(String timeFieldfirst) {
		timeField1.sendKeys(timeFieldfirst);
	}

	public void setTime2(String timeFieldsecond) {
		timeField2.sendKeys(timeFieldsecond);
		timeField2.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_DOWN);

	}

	public void clickOnRestaurantsLink() {
		restaurantsLink.click();
	}

	public void clickOnFindByButton() {
		findByButton.click();
	}

	public void clickOnPrice() {
		price.click();
	}

	public void clickOnRate() {
		rate.click();
	}

	public void clickOnAmericanCousine() {
		americanCousine.click();
	}

	public void clickOnFastFoodCousine() {
		fastFoodCousine.click();
	}

	public void clickOnFilterSearchButton() throws InterruptedException {
		filterSearchButton.click();
		Thread.sleep(1000);
	}

	public void clickOnFilteredObject() {
		filteredObject.click();
	}

	public void setGuestesForFilteredObject(String guestsForFilteredObject2) {
		guestsForFilteredObject.sendKeys(guestsForFilteredObject2);
	}

	public void setDayForFilteredObject(String dayForFilteredObject2) throws InterruptedException {
		dayForFilteredObject.sendKeys(dayForFilteredObject2);
		Thread.sleep(1000);

		dayForFilteredObject.sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(1000);

	}

	public void setMonthForFilteredObject(String monthForFilteredObject2) {
		monthForFilteredObject.sendKeys(monthForFilteredObject2);
		monthForFilteredObject.sendKeys(Keys.ARROW_RIGHT);

	}

	public void setYearForFilteredObject(String yearForFilteredObject2) {
		yearForFilteredObject.sendKeys(yearForFilteredObject2);
		yearForFilteredObject.sendKeys(Keys.TAB);

	}

	public void clickOnAboutField() {
		aboutButton.click();
	}

	public void clickOnMenuButton() {
		menuButton.click();
	}

	public void clickOnLunchButton() {
		lunchButton.click();
	}

	public void clickOnDinnerButton() throws InterruptedException {
		dinnerButton.click();
		Thread.sleep(1000);
	}

	public void clickOnShowFullMenuButton() throws InterruptedException {
		showFullMenuButton.click();
		Thread.sleep(1000);
	}

	public void clickOnReviewsButton() throws InterruptedException {
		reviewsBUtton.click();
		Thread.sleep(3000);
	}

	public void scrollToTop() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0);");
//		Thread.sleep(1000);

	}

	public void setTime1FieldForFilteringObject(String time1FieldForFilteringObject2) {
		time1FieldForFilteringObject.sendKeys(time1FieldForFilteringObject2);

	}

	public void setTime2FieldForFilteringObject2(String time2FieldForFilteringObject2) {
		time2FieldForFilteringObject.sendKeys(time2FieldForFilteringObject2);
		time2FieldForFilteringObject.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

	}

	public void chooseDurationForFilteredObject() {
		durationForFilteredObject.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		;
	}

	public void clickOnFindTableForFilteredObject() {
		findTableForFilteredObject.click();
	}

	public void clickOnNearestTimeForFilteredObject() {
		nearestTimeForFilteredObject.click();
	}

	public void scrollDownPopularLocation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(1000);

	}

	public void clickOnPopularLocationCity() {
		popularLocationCity.click();
	}

	public void clickOnPopularLocationRestaurant() {
		popularLocationRestaurant.click();
	}

}