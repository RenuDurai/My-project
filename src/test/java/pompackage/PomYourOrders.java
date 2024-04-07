package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.Baseclass;

public class PomYourOrders extends Baseclass{
@FindBy(id="a-autoid-1-announce") WebElement Dropdown;
@FindBy(xpath="//div[contains(text(),'Looks like you')]") WebElement last3MonthsOrders;
@FindBy(xpath="//*[contains(text(),'There are no recommended')]") WebElement BuyAgain;
@FindBy(xpath="//*[contains(text(),'Looking for an order')]") WebElement NotYetShipped;
@FindBy(id="ordersContainer") WebElement CancelledOrders;
@FindBy(linkText="Buy Again") WebElement BuyAgainlink;
@FindBy(linkText="Not Yet Shipped") WebElement NotYetShippedlink;
@FindBy(linkText="Cancelled Orders") WebElement CancelledOrderslink;
@FindBy(linkText="Orders") WebElement Orderslink;

public PomYourOrders () {
	PageFactory.initElements(driver, this);
}
public String Get_Orders_Text() {
	String text=last3MonthsOrders.getText();
	return text;
}
public String Get_BuyAgain_Text() {
	String text=BuyAgain.getText();
	return text;
}
public String Get_NotYetShipped_Text() {
	String text=NotYetShipped.getText();
	return text;
}
public String Get_CancelledOrders_Text() {
	String text=CancelledOrders.getText();
	return text;
}

public void Search_Drop_Down(String text) {
	Select select=new Select(Dropdown);
	select.selectByVisibleText(text);
}
public void Click_Buy_Again() {
	BuyAgainlink.click();
}
public void Click_Not_Yet_Shipped() {
	NotYetShippedlink.click();
}
public void Click_Cancelled_orders() {
	CancelledOrderslink.click();
}
public void Click_Orders() {
	Orderslink.click();
}
}