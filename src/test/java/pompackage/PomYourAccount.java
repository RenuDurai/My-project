package pompackage;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Baseclass;

public class PomYourAccount extends Baseclass {
@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement HelloAccountAndList;
@FindBy(xpath="//span[contains(text(),'Your Account')]") WebElement YourAccount;
@FindBy(xpath="//h2[contains(text(),'Your Orders')]") WebElement YourOrders;
@FindBy(xpath="//h2[contains(text(),'Login & security')]") WebElement LoginSecurity;
@FindBy(xpath="//h2[contains(text(),'Prime')]") WebElement Prime;
@FindBy(xpath="//h2[contains(text(),'Your Addresses')]") WebElement YourAddresses;
@FindBy(xpath="//h2[contains(text(),'Your Payments')]") WebElement Payments;
@FindBy(xpath="//h2[contains(text(),'Gift cards')]") WebElement GiftCards;
@FindBy(xpath="//h2[contains(text(),'Customer Service')]") WebElement CustomerService;
static PomYourAccount obj=new PomYourAccount();

	public PomYourAccount() {
		PageFactory.initElements(driver,this);
	}
	
	public static void Mouse_Hover_on_HelloAccountAndList() {
		Actions action=new Actions(driver);
		action.moveToElement(obj.HelloAccountAndList).build().perform();
	}
	public static void Your_Account() {
		obj.YourAccount.click();
	}
	public void Your_Orders() {
		YourOrders.click();
	}
	public void Login_and_security() {
		LoginSecurity.click();
	}
	public void Prime() {
		Prime.click();
	}
	public static void Your_Addresses() {
		obj.YourAddresses.click();
	}
	public static void Your_Payments() {
		obj.Payments.click();
	}
	public void Gift_Cards() {
		GiftCards.click();
	}
	public void Customer_Service() {
		CustomerService.click();
	}
	public String Get_Title() {
		String text=driver.getTitle();
		return text;
	}
	
	
}
