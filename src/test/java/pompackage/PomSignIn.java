package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Baseclass;

public class PomSignIn extends Baseclass{

	@FindBy(id="ap_email") WebElement Email;
	@FindBy(id="continue") WebElement Continue;
	@FindBy(linkText="Conditions of Use") WebElement Conditions;
	@FindBy(linkText="Privacy Notice") WebElement Notice;
	@FindBy(linkText="Forgot Password") WebElement ForgotPassword;
	@FindBy(linkText="Other issues with Sign-In") WebElement SignInIssues;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="signInSubmit") WebElement SignInButton;
	public @FindBy(name="rememberMe") WebElement KeepMeSignedin;
	@FindBy(id="a-popover-header-1") WebElement popup;
	@FindBy(xpath="//*[contains(text(),'Need help?')]") WebElement NeedHelp;
	@FindBy(linkText="Change") WebElement Change;
	@FindBy(id="remember_me_learn_more_link") WebElement Details;
	
	public PomSignIn() {
		PageFactory.initElements(driver,this);
	}
	
	public void type_EmailorMobile(String email) {
		Email.sendKeys(email);
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
	public void Need_Help() {
		NeedHelp.click();
	}
	public void Click_Forgot_Password() {
		ForgotPassword.click();
	}
	public void Click_Other_issues_with_SignIn() {
		SignInIssues.click();
	}
	public void type_Password(String password) {
		Password.sendKeys(password);
	}
	public void Click_SignIn() {
		SignInButton.click();
	}
	public void Keep_me_signed_in_checkbox() {
		KeepMeSignedin.click();
	}
	public void Change_Hyperlink() {
		Change.click();
	}
	public String MobileOrEmailFeildText() {
		String text=Email.getAttribute("name");
		return text;
	}
	public void Details_Button() {
		Details.click();
	}
	
	public static void Signin() {
		PomSignIn signin=new PomSignIn();
		signin.type_EmailorMobile(prop.getProperty("email"));
		signin.Click_Continue();
		signin.type_Password(prop.getProperty("password"));
		signin.Click_SignIn();
	}
}