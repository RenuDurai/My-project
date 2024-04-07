package testlayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basepackage.Baseclass;
import pompackage.PomSearch;
import testData.ExcelSheet;
import utility.timeutils;

public class SearchTest extends Baseclass {
	PomSearch pom;
	SoftAssert obj=new SoftAssert();
	int i=75;
	public SearchTest() {
		super();
	}
	@BeforeTest
	public void initial_setup() {
		initiation();
		pom=new PomSearch();
	}
	@BeforeMethod
	public void clear_Search() {
		pom.Clear_Search_Box();
	}
	@DataProvider
	public Object[][] testdata(){
		Object result[][]=ExcelSheet.readdata("Search");
		return result;
	}
	@Test(dataProvider="testdata")
	public void TC75_Search_by_KeyWord(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) {
		pom.Type_in_Search_Box(Search);
		pom.Click_Search_Icon();
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca : bags");
	}
	@Test(dataProvider="testdata")
	public void TC76_Search_by_description_text(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) {
		pom.Type_in_Search_Box(Description);
		pom.Click_Search_Icon();
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca : red bags");
	}
	@Test(dataProvider="testdata")
	public void TC77_Search_by_partial_item_text(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) {
		pom.Type_in_Search_Box(PartialText);
		pom.Click_Search_Icon();
		String text=driver.findElement(By.id("n/667823011")).getText();
		Assert.assertEquals(text, "Electronics");
	}
	@Test(dataProvider="testdata")
	public void TC78_Search_by_item_number(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) {
		pom.Type_in_Search_Box(Item);
		pom.Click_Search_Icon();
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca : B07GQ2CF4T");
	}
	@Test(dataProvider="testdata") //Failed TC
	public void TC79_Search_by_partial_item_number(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) {
		pom.Type_in_Search_Box(PartialItem);
		pom.Click_Search_Icon();
		Assert.assertEquals(pom.Get_Title(), "Amazon.ca : B07GQ2CF4T");
	}
	@Test(dataProvider="testdata")
	public void TC80_Search_by_category(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) {
		pom.Select_Search_Drop_Down(Category);
		pom.Click_Search_Icon();
		Assert.assertEquals(pom.Get_Title(), "Electronics: Amazon.ca");
	}
	@Test(dataProvider="testdata")//Failed TC
	public void TC83_Number_of_products_per_page(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) {
		pom.Type_in_Search_Box(Search);
		pom.Click_Search_Icon();
		String text=driver.findElement(By.xpath("//span[contains(text(),'1-48 of over')]")).getText();
		Assert.assertEquals(text, "1-60 of over 100,000 results for");
	}
	@Test(dataProvider="testdata")
	public void TC84_Next_page(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) throws InterruptedException {
		pom.Type_in_Search_Box(Search);
		pom.Click_Search_Icon();
		driver.findElement(By.linkText("Next")).click();
		Thread.sleep(3000);
		String text=driver.findElement(By.xpath("//span[contains(text(),'49-96 of over 100,000 results for')]")).getText();
		Assert.assertEquals(text, "49-96 of over 100,000 results for");
	}
	@Test(dataProvider="testdata")
	public void TC87_Filter_by_Customer_Review(String Search,String Description,String PartialText,String Item,String PartialItem,String Category) throws InterruptedException {
		pom.Type_in_Search_Box(Search);
		pom.Click_Search_Icon();
		driver.findElement(By.id("p_72/11192170011")).click();
		Thread.sleep(3000);
		String text=driver.findElement(By.cssSelector("#reviewsRefinements > ul > li.a-spacing-micro.s-list-item > span > a")).getText();
		Assert.assertEquals(text, "Clear");}
	
	@AfterMethod
	public void screenshots() {
		obj.assertAll();
		i=i+1;
		timeutils.pageloading();
		screenshots("Search "+ i);	
	}
	@AfterTest
	public void close(){
		driver.close();
	}
}
