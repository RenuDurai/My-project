package testlayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basepackage.Baseclass;
import pompackage.PomSignIn;
import pompackage.PomYourAccount;
import pompackage.PomYourPayments;
import utility.timeutils;

public class AddYourPayment_Module extends Baseclass {
	PomYourPayments pom;
	SoftAssert obj=new SoftAssert();
	int i=71;
	public AddYourPayment_Module() {
		super();
	}
	@BeforeTest
	public void initial_setup() {
		initiation();
		pom=new PomYourPayments();
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		driver.findElement(By.linkText("Sign in")).click();
		timeutils.pageloading();
		PomSignIn.Signin();
		}
	@BeforeMethod
	public void refresh() {
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		PomYourAccount.Your_Account();
		PomYourAccount.Your_Payments();
		timeutils.pageloading();
		}
	@Test
	public void TC71_Your_Payments_Add_a_payment_method(){
			pom.Click_Add_A_Payment_Method();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			pom.Click_Add_A_Credit_or_DebitCard();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			timeutils.pageloading();
			//WebElement popup=driver.findElement(By.id("a-popover-header-1"));
			driver.switchTo().alert().sendKeys("5123456789012346");
			//Alert al=driver.switchTo().alert().sendKeys("5123456789012346");
			pom.Type_Card_Number("5123456789012346");
			pom.Type_Name_on_Card("RENUKODEESWARI");
			pom.Select_Month("05");
			pom.Select_Year("2024");
			//pom.Click_Add_Your_Card_Button();
		}
	@Test
	public void TC73_Your_Payments_Amazon_gift_card(){
			pom.Click_Amazon_Gift_Card_Button();
			pom.Click_Reload_Your_Balance_Button();
			System.out.println(pom.Get_Title());
	
	}
	
	@AfterMethod
	public void screenshots() {
		obj.assertAll();
		timeutils.pageloading();
		i=i+1;
		screenshots("Create Account "+ i);	
	}
	@AfterTest
	public void close(){
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		driver.findElement(By.id("nav-item-signout")).click();
		driver.close();
	}
	}
	


