package testlayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basepackage.Baseclass;
import pompackage.PomSignIn;
import pompackage.PomYourAccount;
import pompackage.PomYourAddresses;
import testData.ExcelSheet;
import utility.timeutils;

public class Add_Address_Module_Test extends Baseclass {
	PomYourAddresses pom;
	SoftAssert obj=new SoftAssert();
	int i=52;
	public Add_Address_Module_Test() {
		super();
	}
	@BeforeTest
	public void initial_setup() {
		initiation();
		pom=new PomYourAddresses();
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		driver.findElement(By.linkText("Sign in")).click();
		timeutils.pageloading();
		PomSignIn.Signin();
		}
	@BeforeMethod
	public void refresh() {
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		PomYourAccount.Your_Account();
		PomYourAccount.Your_Addresses();
		pom.Click_Add_Address();
		timeutils.pageloading();
		}
	@DataProvider
	public Object[][] testdata(){
		Object result[][]=ExcelSheet.readdata("Add address");
		return result;
	}
	@Test
	public void TC52_Add_address(){
		Assert.assertEquals(pom.Get_Title(), "Your Addresses");
	}
	@Test
	public void TC53_Add_address_CountryorRegion(){
		Assert.assertEquals(pom.Get_Country_Text(), "Canada");
	}
	@Test(dataProvider="testdata")
	public void TC54_Add_address_Invalid_Full_name(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Phone_Number(phone);
		pom.Type_Address_Line1(Address);
		pom.Type_City(City);
		pom.Select_Province(Province);
		pom.Type_Postal_code(Postal);
		pom.Click_Button_Add_Address();
		Assert.assertEquals(driver.findElement(By.id("address-ui-widgets-enterAddressFullName-full-validation-alerts")).getText(), "Please enter a name.");
	}
	@Test(dataProvider="testdata")
	public void TC55_Add_address_Invalid_Phone_number(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Full_name(name);
		pom.Type_Address_Line1(Address);
		pom.Type_City(City);
		pom.Select_Province(Province);
		pom.Type_Postal_code(Postal);
		pom.Click_Button_Add_Address();
		Assert.assertEquals(driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber-full-validation-alerts")).getText(), "Please enter a phone number so we can call if there are any issues with delivery.");
	}
	@Test(dataProvider="testdata")
	public void TC56_Add_address_Invalid_Address(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Full_name(name);
		pom.Type_Phone_Number(phone);
		pom.Type_City(City);
		pom.Select_Province(Province);
		pom.Type_Postal_code(Postal);
		pom.Click_Button_Add_Address();
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Please enter an address.')]")).getText(), "Please enter an address.");
	}
	@Test(dataProvider="testdata")
	public void TC57_Add_address_Invalid_Address(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Full_name(name);
		pom.Type_Phone_Number(phone);
		pom.Type_Address_Line1(invalidAddress);
		pom.Type_City(City);
		pom.Select_Province(Province);
		pom.Type_Postal_code(Postal);
		pom.Click_Button_Add_Address();
		Assert.assertEquals(pom.Get_Title(), "Your Addresses");
		driver.navigate().back();
	}
	@Test(dataProvider="testdata")
	public void TC58_Add_address_Invalid_City(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Full_name(name);
		pom.Type_Phone_Number(phone);
		pom.Type_Address_Line1(Address);
		pom.Select_Province(Province);
		pom.Type_Postal_code(Postal);
		pom.Click_Button_Add_Address();
		Assert.assertEquals(driver.findElement(By.id("address-ui-widgets-enterAddressCity-full-validation-alerts")).getText(), "Please enter a city name.");
	}
	@Test(dataProvider="testdata")
	public void TC59_Add_address_Invalid_ProvinceorTerritory(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Full_name(name);
		pom.Type_Phone_Number(phone);
		pom.Type_Address_Line1(Address);
		pom.Type_City(City);
		pom.Type_Postal_code(Postal);
		pom.Click_Button_Add_Address();
		Assert.assertEquals(driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId-full-validation-alerts")).getText(), "Please enter a province/territory.");
	}
	@Test(dataProvider="testdata")
	public void TC60_Add_address_Invalid_Postal_code(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Full_name(name);
		pom.Type_Phone_Number(phone);
		pom.Type_Address_Line1(Address);
		pom.Type_City(City);
		pom.Select_Province(Province);
		pom.Click_Button_Add_Address();
		Assert.assertEquals(driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode-full-validation-alerts")).getText(), "Please enter a postal code.");
	}	
	@Test(dataProvider="testdata")
	public void TC61_Add_address_default_address(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Full_name(name);
		pom.Type_Phone_Number(phone);
		pom.Type_Address_Line1(Address);
		pom.Type_City(City);
		pom.Select_Province(Province);
		pom.Type_Postal_code(Postal);
		pom.Click_Make_This_My_Default_Address();
		System.out.println(pom.CheckboxDefaultaddress.isSelected());
		Assert.assertEquals(pom.CheckboxDefaultaddress.isSelected(), true);
	}
	@Test(dataProvider="testdata")
	public void TC118_Add_address_button(String name, String phone, String Address, String City, String Province,String Postal,String invalidAddress){
		pom.Type_Full_name(name);
		pom.Type_Phone_Number(phone);
		pom.Type_Address_Line1(Address);
		pom.Type_City(City);
		pom.Select_Province(Province);
		pom.Type_Postal_code(Postal);
		pom.Click_Button_Add_Address();
		Assert.assertEquals(driver.findElement(By.id("yaab-alert-box")).getText(), "Address saved");
		pom.Click_Add_Address();
	}
		
	@AfterMethod
	public void screenshots() {
		obj.assertAll();
		i=i+1;
		timeutils.pageloading();
		screenshots("Add Address "+ i);	
	}
	@AfterTest
	public void close(){
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		driver.findElement(By.id("nav-item-signout")).click();
		driver.close();
	}
}
