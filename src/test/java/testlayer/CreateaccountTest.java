package testlayer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basepackage.Baseclass;
import pompackage.Createaccountpom;
import pompackage.PomYourAccount;
import testData.ExcelSheet;
import utility.timeutils;
public class CreateaccountTest extends Baseclass {
	Createaccountpom create;
	SoftAssert obj=new SoftAssert();
	int i=1;		//screenshot number
	public CreateaccountTest() {
		super();
	}
	@BeforeTest
	public void initial_setup() {
		initiation();
		create= new Createaccountpom();
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		driver.findElement(By.linkText("Start here.")).click();
		timeutils.pageloading();
		}
	@BeforeMethod
	public void refresh() {
		driver.navigate().refresh();}
	@DataProvider
	public Object[][] testdata(){
		Object result[][]=ExcelSheet.readdata("Create Account");
		return result;
	}
	@Test(dataProvider="testdata")
	public void TC01_createaccount(String Name,String Email,String Mobile,String Password,String PasswordAgain,String InvalidEmail,String InvalidMobile,String InvalidPassword,String InvalidPasswordAgain)
	{
		create.type_yourname(Name);
		create.type_EmailorMobile(Email);
		create.type_Password(Password);
		create.type_PasswordAgain(PasswordAgain);
		create.Click_Continue();
		timeutils.pageloading();
		String text= driver.findElement(By.xpath("//h4[contains(text(),'E-mail address already in use')]")).getText();
		System.out.println(text);
		obj.assertEquals(text,"E-mail address already in use");
		driver.navigate().back();
		}
	@Test(dataProvider="testdata")
	public void TC02_Invalid_Your_name(String Name,String Email,String Mobile,String Password,String PasswordAgain,String InvalidEmail,String InvalidMobile,String InvalidPassword,String InvalidPasswordAgain) {
		create.type_EmailorMobile(Email);
		create.type_Password(Password);
		create.type_PasswordAgain(PasswordAgain);
		create.Click_Continue();
		timeutils.pageloading();
		String text= driver.findElement(By.id("auth-customerName-missing-alert")).getText();
		System.out.println(text);
		obj.assertEquals(text,"Enter your name");
		}
	@Test(dataProvider="testdata")
	public void TC03_Invalid_Mobile_number_or_email(String Name,String Email,String Mobile,String Password,String PasswordAgain,String InvalidEmail,String InvalidMobile,String InvalidPassword,String InvalidPasswordAgain) {
		create.type_yourname(Name);
		create.type_Password(Password);
		create.type_PasswordAgain(PasswordAgain);
		create.Click_Continue();
		timeutils.pageloading();
		String text= driver.findElement(By.id("auth-email-missing-alert")).getText();
		System.out.println(text);
		obj.assertEquals(text,"Enter your e-mail address or mobile phone number");
		}
	@Test(dataProvider="testdata")
	public void TC04_Invalid_partial_Mobile_number(String Name,String Email,String Mobile,String Password,String PasswordAgain,String InvalidEmail,String InvalidMobile,String InvalidPassword,String InvalidPasswordAgain) {
		create.type_yourname(Name);
		create.type_EmailorMobile(InvalidMobile);
		String text= driver.findElement(By.id("auth-continue-announce")).getText();
		System.out.println(text);
		obj.assertEquals(text,"Continue");
		}
	@Test(dataProvider="testdata")
	public void TC05_invalid_email(String Name,String Email,String Mobile,String Password,String PasswordAgain,String InvalidEmail,String InvalidMobile,String InvalidPassword,String InvalidPasswordAgain) {	
		create.type_yourname(Name);
		create.type_EmailorMobile(InvalidEmail);
		create.type_Password(Password);
		create.type_PasswordAgain(PasswordAgain);
		create.Click_Continue();
		timeutils.pageloading();
		String text= driver.findElement(By.id("auth-email-invalid-claim-alert")).getText();
		System.out.println(text);
		obj.assertEquals(text,"Wrong or invalid e-mail address or mobile phone number. Please correct it and try again.");
		}
	@Test(dataProvider="testdata")
	public void TC07_Invalid_Password(String Name,String Email,String Mobile,String Password,String PasswordAgain,String InvalidEmail,String InvalidMobile,String InvalidPassword,String InvalidPasswordAgain) {
		create.type_yourname(Name);
		create.type_EmailorMobile(Email);
		create.type_Password(InvalidPassword);
		create.type_PasswordAgain(InvalidPassword);
		create.Click_Continue();
		timeutils.pageloading();
		String text= driver.findElement(By.id("auth-password-invalid-password-alert")).getText();
		System.out.println(text);
		obj.assertEquals(text,"Minimum 6 characters required");
		}
	@Test(dataProvider="testdata")
	public void TC08_Invalid_Password_again_field(String Name,String Email,String Mobile,String Password,String PasswordAgain,String InvalidEmail,String InvalidMobile,String InvalidPassword,String InvalidPasswordAgain) {
		create.type_yourname(Name);
		create.type_EmailorMobile(Email);
		create.type_Password(Password);
		create.type_PasswordAgain(InvalidPassword);
		create.Click_Continue();
		timeutils.pageloading();
		String text= driver.findElement(By.id("auth-password-mismatch-alert")).getText();
		System.out.println(text);
		obj.assertEquals(text,"Passwords do not match");
		}
	@Test(dataProvider="testdata")
	public void TC09_Empty_Password_again_field(String Name,String Email,String Mobile,String Password,String PasswordAgain,String InvalidEmail,String InvalidMobile,String InvalidPassword,String InvalidPasswordAgain) {
		create.type_yourname(Name);
		create.type_EmailorMobile(Email);
		create.type_Password(Password);
		create.Click_Continue();
		timeutils.pageloading();
		String text= driver.findElement(By.id("auth-passwordCheck-missing-alert")).getText();
		System.out.println(text);
		obj.assertEquals(text,"Type your password again");
		}
	@Test
	public void TC12_Conditions_of_use_hyperlink() {	
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		create.Click_ConditionsofUse();
		timeutils.pageloading();
		String text= driver.getTitle();
		System.out.println(text);
		obj.assertEquals(text,"Amazon.ca Conditions of Use - Amazon Customer Service");
		}
	@Test
	public void TC13_Verify_Privacy_Notice_hyperlink() {
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		create.Click_PrivacyNotice();
		timeutils.pageloading();
		String text= driver.getTitle();
		System.out.println(text);
		obj.assertEquals(text,"Amazon.ca Privacy Notice - Amazon Customer Service");
		}
	@Test
	public void TC14_Sign_in_hyperlink() {	
		driver.navigate().back();
		create.Click_Signin();
		timeutils.pageloading();
		String text= driver.getTitle();
		System.out.println(text);
		obj.assertEquals(text,"Amazon Sign In");
		}
	@Test
	public void TC15_Create_free_business_account_hyperlink() {
		driver.navigate().back();
		create.Click_Create_a_free_business_account();
		timeutils.pageloading();
		String text= driver.getTitle();
		System.out.println(text);
		obj.assertEquals(text,"Amazon Business");
	}
	
	@AfterMethod
	public void screenshots() {
		obj.assertAll();
		i=i+1;
		timeutils.pageloading();
		screenshots("Create Account "+i);	
	}
	
	@AfterTest 
	public void close() {
		driver.close();
	}

	}
	
