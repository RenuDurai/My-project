package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.Baseclass;

public class PomYourAddresses extends Baseclass{
		@FindBy(xpath="//h2[contains(text(),'Your Addresses')]") WebElement YourAddresses;
		@FindBy(id="ya-myab-address-add-link") WebElement AddAddress;
		@FindBy(id="ya-myab-display-address-block-0") WebElement DefaultAddress;
		@FindBy(id="address-ui-widgets-countryCode") WebElement Country;
		@FindBy(id="address-ui-widgets-enterAddressFullName") WebElement Fullname;
		@FindBy(id="address-ui-widgets-enterAddressPhoneNumber") WebElement Phoneno;
		@FindBy(id="address-ui-widgets-enterAddressLine1") WebElement AddressLine1;
		@FindBy(id="address-ui-widgets-enterAddressLine2") WebElement AddressLine2;
		@FindBy(id="address-ui-widgets-enterAddressCity") WebElement Cityelement;
		@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId") WebElement Dropdown;
		@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement Postalc;
		public @FindBy(id="address-ui-widgets-use-as-my-default") WebElement CheckboxDefaultaddress;
		@FindBy(xpath="//span[contains(text(),'Add preferences, notes, access codes and more')]") WebElement DeliveryInstructions;
		public @FindBy(xpath="//*[contains(text(),'House')]") WebElement House;
		public @FindBy(xpath="//*[contains(text(),'Apartment')]") WebElement Apartment;
		@FindBy(xpath="//button[contains(text(),'Business')]") WebElement Business;
		@FindBy(xpath="//button[contains(text(),'Other')]") WebElement Other;
		public @FindBy(xpath="//span[contains(text(),'Front door')]") WebElement FrontDoor;
		@FindBy(id="address-ui-widgets-form-submit-button") WebElement SubmitAddAddress;
		
		public PomYourAddresses() {
			PageFactory.initElements(driver, this);
		}
		public void Click_Your_Addresses() {
			YourAddresses.click();
		}
		public void Click_Add_Address() {
			AddAddress.click();
		}
		public String Get_Title() {
			String text=driver.getTitle();
			return text;
		}
		public String Get_Country_Text() {
			String text=Country.getText();
			return text;
		}
		public void Type_Full_name(String email) {
			Fullname.sendKeys(email);
		}
		public void Type_Phone_Number(String phone) {
			Phoneno.sendKeys(phone);
		}
		public void Type_Address_Line1(String addressline1) {
			AddressLine1.sendKeys(addressline1);
		}
		public void Type_Address_Line2(String addressline2) {
			AddressLine1.sendKeys(addressline2);
		}
		public void Type_City(String Citytext) {
			Cityelement.sendKeys(Citytext);
		}
		public void Select_Province(String text) {
			Select select=new Select(Dropdown);
			select.selectByVisibleText(text);
		}
		public void Type_Postal_code(String PC) {
			Postalc.sendKeys(PC);
		}
		public void Click_Make_This_My_Default_Address() {
			CheckboxDefaultaddress.click();
		}
		public void Click_Delivery_Instructions() {
			DeliveryInstructions.click();
		}
		public void Click_House() {
			House.click();
		}
		public void Click_Apartment() {
			Apartment.click();
		}
		public void Click_Business() {
			Business.click();
		}
		public void Click_Other() {
			Other.click();
		}
		public void Click_Front_Door() {
			FrontDoor.click();
		}
		public void Click_Button_Add_Address() {
			SubmitAddAddress.click();
		}
}
