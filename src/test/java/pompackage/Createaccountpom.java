package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Baseclass;

public class Createaccountpom extends Baseclass {
	
	@FindBy(id="ap_customer_name") WebElement Yourname;
	@FindBy(id="ap_email") WebElement Email;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="ap_password_check") WebElement Passwordagain;
	@FindBy(id="continue") WebElement Continue;
	@FindBy(linkText="Conditions of Use") WebElement Conditions;
	@FindBy(linkText="Privacy Notice") WebElement Notice;
	@FindBy(linkText="Sign in") WebElement Signinlink;
	@FindBy(linkText="Create a free business account") WebElement Businessaccount;
	
	public Createaccountpom() {
		PageFactory.initElements(driver,this);
	}
	
	public void type_yourname(String name) {
		Yourname.sendKeys(name);
	}
	public void type_EmailorMobile(String email) {
		Email.sendKeys(email);
	}
	public void type_Password(String pw) {
		Password.sendKeys(pw);
	}
	public void type_PasswordAgain(String pwa) {
		Passwordagain.sendKeys(pwa);
	}
	public void Click_Continue() {
		Continue.click();
	}
	public void Click_ConditionsofUse() {
		Conditions.click();
	}
	public void Click_PrivacyNotice() {
		Notice.click();
	}
	public void Click_Signin() {
		Signinlink.click();
	}
	public void Click_Create_a_free_business_account() {
		Businessaccount.click();
	}
}
