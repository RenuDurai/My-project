package testlayer;

import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;
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
import testData.ExcelSheet;
import utility.timeutils;

public class SignIn extends Baseclass {
	PomSignIn pom;
	SoftAssert obj;
	int i=16;
	public SignIn() {
		super();
	}
	@BeforeTest
	public void initial_setup() {
		initiation();
		pom= new PomSignIn();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList")));
		driver.findElement(By.linkText("Sign in")).click();
		timeutils.pageloading();
		}
	@BeforeMethod
	public void refresh() {
	driver.navigate().refresh();
	timeutils.pageloading();
	obj=new SoftAssert();
	}
	@DataProvider
	public Object[][] testdata(){
		Object result[][]=ExcelSheet.readdata("SignIn");
		return result;
	}
	@Test(dataProvider="testdata")
	public void TC16_SignIn_Valid_email_or_mobile_number(String Email,String Password,String Mobileno,String InvalidEmail,String InvalidPassword,String InvalidMobileno) {
		pom.type_EmailorMobile(Email);
		pom.Click_Continue();
		timeutils.pageloading();
		String text=driver.findElement(By.id("ap_password")).getAttribute("name");
		Assert.assertEquals(text, "password");
		obj.assertAll();
		driver.navigate().back();
		}
	
	@Test
	public void TC17_SignIn_Empty_email_or_mobile_number() {
		pom.Click_Continue();
		timeutils.pageloading();
		String text=driver.findElement(By.id("auth-email-missing-alert")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "Enter your e-mail address or mobile phone number");
		obj.assertAll();
		}
	@Test(dataProvider="testdata")
	public void TC18_SignIn_Invalid_email_or_mobile_number(String Email,String Password,String Mobileno,String InvalidEmail,String InvalidPassword,String InvalidMobileno) {
		pom.type_EmailorMobile(InvalidEmail);
		pom.Click_Continue();
		timeutils.pageloading();
		String text=driver.findElement(By.xpath("//h4[contains(text(),'There was a problem')]")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "There was a problem");
		obj.assertAll();
		i=18;
		driver.navigate().back();
		
		}
	@Test
	public void TC19_Conditions_of_use_hyperlink() {
		pom.Click_ConditionsofUse();
		timeutils.pageloading();
		String text= driver.getTitle();
		System.out.println(text);
		obj.assertEquals(text,"Amazon.ca Conditions of Use - Amazon Customer Service");
		obj.assertAll();
		}
	@Test
	public void TC20_Verify_Privacy_Notice_hyperlink() {
		driver.navigate().back();
		pom.Click_PrivacyNotice();
		timeutils.pageloading();
		String text= driver.getTitle();
		System.out.println(text);
		obj.assertEquals(text,"Amazon.ca Privacy Notice - Amazon Customer Service");
		obj.assertAll();
		}
	@Test
	public void TC22_Need_Help() {
		pom.Need_Help();
		String text1= driver.findElement(By.id("auth-fpp-link-bottom")).getText();
		obj.assertEquals(text1,"Forgot Password");
		String text2= driver.findElement(By.id("ap-other-signin-issues-link")).getText();
		obj.assertEquals(text2,"Other issues with Sign-In");
		obj.assertAll();
		}
	@Test
	public void TC21_Forgot_Password() {
		driver.navigate().back();
		pom.Need_Help();
		pom.Click_Forgot_Password();
		timeutils.pageloading();
		String text= driver.getTitle();
		System.out.println(text);
		obj.assertEquals(text,"Amazon Password Assistance");
		obj.assertAll();
		driver.navigate().back();
		}
	@Test
	public void TC23_Verify_Other_issues_with_SignIn_hyperlink() {
		pom.Need_Help();
		pom.Click_Other_issues_with_SignIn();;
		timeutils.pageloading();
		String text= driver.getTitle();
		System.out.println(text);
		obj.assertEquals(text,"Amazon.ca - Account & Login Issues");
		obj.assertAll();
		driver.navigate().back();
		}
	@Test(dataProvider="testdata")
	public void TC24_SignIn_Empty_Password(String Email,String Password,String Mobileno,String InvalidEmail,String InvalidPassword,String InvalidMobileno) {
		pom.type_EmailorMobile(Email);
		pom.Click_Continue();
		timeutils.pageloading();
		pom.Click_SignIn();
		String text=driver.findElement(By.id("auth-password-missing-alert")).getText();
		Assert.assertEquals(text, "Enter your password");
		obj.assertAll();
		}
	@Test(dataProvider="testdata")
	public void TC25_SignIn_Invalid_Password(String Email,String Password,String Mobileno,String InvalidEmail,String InvalidPassword,String InvalidMobileno) {
		pom.type_Password(InvalidPassword);
		pom.Click_SignIn();
		String text=driver.findElement(By.xpath("//h4[contains(text(),'There was a problem')]")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "There was a problem");
		obj.assertAll();
		driver.navigate().back();
		}
	@Test
	public void TC26_Change_Hyperlink() {
		driver.navigate().back();
		pom.Click_Continue();
		pom.Change_Hyperlink();
		Assert.assertEquals(pom.MobileOrEmailFeildText(), "email");
		obj.assertAll();
	}
	
	@Test(dataProvider="testdata")
	public void TC27_Forgot_Password_Hyperlink(String Email,String Password,String Mobileno,String InvalidEmail,String InvalidPassword,String InvalidMobileno) {
		pom.type_EmailorMobile(Email);
		pom.Click_Continue();
		pom.Click_Forgot_Password();
		timeutils.pageloading();
		String text= driver.getTitle();
		obj.assertEquals(text,"Amazon Password Assistance");
		obj.assertAll();
		driver.navigate().back();
		driver.navigate().back();	
	}
	@Test(dataProvider="testdata")
	public void TC28_Verify_Details(String Email,String Password,String Mobileno,String InvalidEmail,String InvalidPassword,String InvalidMobileno) {
		pom.type_EmailorMobile(Email);
		pom.Click_Continue();
		pom.Details_Button();
		String text=driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div[1]")).getText();
		System.out.println(text);
		obj.assertEquals(text,"\"Keep Me Signed In\" Checkbox");
		obj.assertAll();
	}
	@Test
	public void TC29_Keep_me_signed_in_Check_box() {
		pom.Keep_me_signed_in_checkbox();
		pom.KeepMeSignedin.isSelected();
	}
	@Test(dataProvider="testdata")
	public void TC30_SignIn_Valid_Password(String Email,String Password,String Mobileno,String InvalidEmail,String InvalidPassword,String InvalidMobileno) {
		pom.type_Password(Password);
		pom.Click_SignIn();
		Assert.assertEquals(driver.getTitle(), "Amazon Sign In");
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		driver.findElement(By.id("nav-item-signout")).click();
	}
	@AfterMethod
	public void screenshots() {
		i=i+1;
		timeutils.pageloading();
		screenshots("Sign In "+ i);	
	}
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
}
