package testlayer;

import org.openqa.selenium.By;
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
import pompackage.PomYourOrders;
import utility.timeutils;

public class Your_Account_Test extends Baseclass {
	PomYourAccount pom;
	PomYourOrders pomorder;
	SoftAssert obj=new SoftAssert();
	int i=31;
	public Your_Account_Test() {
		super();
	}
	@BeforeTest
	public void initial_setup() {
		initiation();
		pom=new PomYourAccount();
		pomorder=new PomYourOrders();
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		driver.findElement(By.linkText("Sign in")).click();
		timeutils.pageloading();
		PomSignIn.Signin();
		}
	@BeforeMethod
	public void refresh() {
		timeutils.pageloading();
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
	}
	@Test
	public void TC31_View_and_access_account_information(){
		PomYourAccount.Your_Account();
		Assert.assertEquals(pom.Get_Title(), "Your Account");
	}
	@Test
	public void TC32_Your_Account(){
		PomYourAccount.Your_Account();
		Assert.assertEquals(pom.Get_Title(), "Your Account");
	}
	@Test
	public void TC33_Your_Orders(){
		PomYourAccount.Your_Account();
		pom.Your_Orders();
		Assert.assertEquals(pom.Get_Title(), "Your Orders");
	}
	
	@Test
	public void TC34_Login_and_security(){
		PomYourAccount.Your_Account();
		pom.Login_and_security();
		Assert.assertEquals(pom.Get_Title(), "Amazon Change Name, E-mail, Password");
	}
	@Test
	public void TC35_Prime(){
		PomYourAccount.Your_Account();
		pom.Prime();
		System.out.println(pom.Get_Title());
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca: Amazon Prime");
	}
	@Test
	public void TC36_Your_Addresses(){
		PomYourAccount.Your_Account();
		PomYourAccount.Your_Addresses();
		Assert.assertEquals(pom.Get_Title(), "Your Addresses");
	}
	@Test
	public void TC37_Your_Payments(){
		PomYourAccount.Your_Account();
		PomYourAccount.Your_Payments();
		Assert.assertEquals(pom.Get_Title(), "Your Payments");
	}
	@Test
	public void TC38_Gift_Cards(){
		PomYourAccount.Your_Account();
		pom.Gift_Cards();
		Assert.assertEquals(pom.Get_Title(), "Gift Card Balance");
	}
	@Test
	public void TC39_Customer_service(){
		PomYourAccount.Your_Account();
		pom.Customer_Service();
		System.out.println(pom.Get_Title());
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca Help: Help & Customer Service");
	}
	@Test
	public void TC40_Digital_content_and_devices(){
		PomYourAccount.Your_Account();
		driver.findElement(By.linkText("Apps and more")).click();
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca: Apps and more");
	}
	@Test
	public void TC41_Email_alerts_messages_and_ads(){
		PomYourAccount.Your_Account();
		driver.findElement(By.linkText("Advertising preferences")).click();
		Assert.assertEquals(pom.Get_Title(), "Amazon Advertising Preferences");
	}
	@Test
	public void TC42_More_ways_to_pay(){
		PomYourAccount.Your_Account();
		driver.findElement(By.linkText("Amazon Credit Card")).click();
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca: Amazon.ca Rewards Mastercard");
	}
	@Test
	public void TC43_Ordering_and_shopping_preferences(){
		PomYourAccount.Your_Account();
		driver.findElement(By.linkText("Archived orders")).click();
		Assert.assertEquals(pom.Get_Title(), "Your Orders");
	}
	@Test
	public void TC44_Other_accounts(){
		PomYourAccount.Your_Account();
		driver.findElement(By.linkText("Amazon Business registration")).click();
		Assert.assertEquals(pom.Get_Title(), "Amazon Business");
		driver.navigate().back();
	}
	@Test
	public void TC45_Shopping_programs_and_rentals(){
		PomYourAccount.Your_Account();
		driver.findElement(By.linkText("Manage Your Profiles")).click();
		Assert.assertEquals(pom.Get_Title(), "Manage your Profiles");
	}
	@Test
	public void TC46_Subscriptions(){
		PomYourAccount.Your_Account();
		driver.findElement(By.linkText("Email")).click();
		Assert.assertEquals(pom.Get_Title(), "Your Email Subscriptions");
	}
	@Test
	public void TC47_Data_and_Privacy(){
		PomYourAccount.Your_Account();
		driver.findElement(By.linkText("Privacy Notice")).click();
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca Privacy Notice - Amazon Customer Service");
	}
	@Test
	public void TC48_Orders(){
		PomYourAccount.Your_Account();
		pom.Your_Orders();
		Assert.assertEquals(pomorder.Get_Orders_Text(), "Looks like you haven't placed an order in the last three months. View orders in 2023");
	}
	@Test
	public void TC49_Orders_placed_in_past(){
		PomYourAccount.Your_Account();
		pom.Your_Orders();
		System.out.println(pomorder.Get_Orders_Text());
		Assert.assertEquals(pomorder.Get_Orders_Text(), "Looks like you haven't placed an order in the last three months. View orders in 2023");
	}
	@Test
	public void TC50_Buy_again(){
		PomYourAccount.Your_Account();
		pom.Your_Orders();
		pomorder.Click_Buy_Again();
		Assert.assertEquals(pomorder.Get_BuyAgain_Text(), "There are no recommended items for you to buy again at this time. Check Your Orders for items you previously purchased.");
	}
	@Test
	public void TC119_Not_Yet_Shipped(){
		PomYourAccount.Your_Account();
		pom.Your_Orders();
		timeutils.pageloading();
		pomorder.Click_Not_Yet_Shipped();
		System.out.println(pomorder.Get_NotYetShipped_Text());
		Assert.assertEquals(pomorder.Get_NotYetShipped_Text(), "Looking for an order? All of your orders have shipped. View all orders");
	}
	@Test
	public void TC51_Cancelled_Orders(){
		PomYourAccount.Your_Account();
		pom.Your_Orders();
		pomorder.Click_Cancelled_orders();
		System.out.println(pomorder.Get_CancelledOrders_Text());
		Assert.assertEquals(pomorder.Get_CancelledOrders_Text(), "We aren't finding any cancelled orders (for orders placed in the last 6 months). View all orders");
	}
	
	@AfterMethod
	public void screenshots() {
		obj.assertAll();
		i=i+1;
		timeutils.pageloading();
		screenshots("Your Account "+ i);	
	}
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		PomYourAccount.Mouse_Hover_on_HelloAccountAndList();
		driver.findElement(By.id("nav-item-signout")).click();
		driver.close();
	}
}

