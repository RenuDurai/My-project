package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.Baseclass;

public class PomYourPayments extends Baseclass{
	@FindBy(linkText="Add a payment method") WebElement AddPayment;
	@FindBy(xpath="//span[contains(text(),'Add a credit or debit')]/preceding-sibling::input[@type='submit']") WebElement AddCardbutton;
	@FindBy(xpath="//input[@class='a-input-text a-form-normal pmts-account-Number' and @name='addCreditCardNumber']") WebElement Cardnumber;
	@FindBy(id="pp-mBZUbj-18") WebElement NameOnCard;
	@FindBy(id="pp-mBZUbj-22") WebElement ExpirationMonth;
	@FindBy(id="pp-mBZUbj-23") WebElement ExpirationYear;
	@FindBy(id="pp-mBZUbj-24") WebElement Cancel;
	@FindBy(id="pp-mBZUbj-25") WebElement AddYourCard;
	@FindBy(xpath="//span[contains(text(),'Amazon gift card')]") WebElement GiftCard;
	@FindBy(linkText="//a[contains(text(),'Reload your balance'") WebElement ReloadBalance;
	@FindBy(linkText="Redeem a gift card") WebElement RedeemGiftCard;
	
public PomYourPayments() {
	PageFactory.initElements(driver, this);
}

public void Click_Add_A_Payment_Method() {
	AddPayment.click();
}
public void Click_Add_A_Credit_or_DebitCard() {
	AddCardbutton.click();
}
public void Type_Card_Number(String cardno) {
	Cardnumber.click();
	Cardnumber.sendKeys(cardno);
}
public void Type_Name_on_Card(String name) {
	NameOnCard.sendKeys(name);
}
public void Select_Month(String month) {
	Select select=new Select(ExpirationMonth);
	select.selectByVisibleText(month);
}
public void Select_Year(String year) {
	Select select=new Select(ExpirationYear);
	select.selectByVisibleText(year);
}
public void Click_Cancel_Button() {
	Cancel.click();
}
public void Click_Add_Your_Card_Button() {
	AddYourCard.click();
}
public void Click_Amazon_Gift_Card_Button() {
	GiftCard.click();
}
public void Click_Reload_Your_Balance_Button() {
	ReloadBalance.click();
}
public void Click_Redeeem_a_Gift_Card_Button() {
	GiftCard.click();
}
public String Get_Title() {
	String text=driver.getTitle();
	return text;
}


}