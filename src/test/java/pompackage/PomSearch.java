package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.Baseclass;


public class PomSearch extends Baseclass {
		@FindBy(id="nav-link-accountList") WebElement HelloAccountAndList;
		@FindBy(id="twotabsearchtextbox") WebElement Searchbox;
		@FindBy(id="searchDropdownBox") WebElement SearchDropdown;
		@FindBy(id="nav-search-submit-button") WebElement SearchIcon;
		@FindBy(id="nav-cart") WebElement CartButton;
	
	public PomSearch(){
		PageFactory.initElements(driver, this);
		}
	public void HelloAccountAndList() {
		Actions action=new Actions(driver);
		action.moveToElement(HelloAccountAndList).build().perform();
	}
	public void Type_in_Search_Box(String searchitems) {
		Searchbox.sendKeys(searchitems);
	}
	public void Clear_Search_Box() {
		Searchbox.clear();
	}
	public void Select_Search_Drop_Down(String text) {
		Select select=new Select(SearchDropdown);
		select.selectByVisibleText(text);
	}
	public void Click_Search_Icon() {
		SearchIcon.click();
	}
	public void Click_Cart_Button() {
		CartButton.click();
	}
	public String Get_Title() {
		String text=driver.getTitle();
		return text;
	}
}
