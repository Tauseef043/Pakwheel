package Automation.Pakwheel;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HeaderPageOB;
import PageObjects.HomePageOB;
import resources.CustomCommands;
import resources.base;

public class HomePageTest extends base{
	
	private HeaderPageOB headerPG;
	private HomePageOB hm;

	private CustomCommands comand;

	
	@BeforeTest
	public void Initialization() throws IOException
	{
		
		driver=InitializeDriver();
	

		driver.get(prop.getProperty("baseURL"));
		headerPG=new HeaderPageOB(driver);
		hm=new HomePageOB(driver);
		 comand=new CustomCommands();

		 comand.ImlicitWait(driver);
		
	}
	
	@Test(priority = 1)
	public void SubscribeNewsLetterCancel() {
		
		if(driver.findElement(By.id("onesignal-slidedown-dialog")).isDisplayed())
		{
			driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
		}
	}
	@Test(priority = 2)
	public void mainLogoVisibility()
	{
		Assert.assertTrue(headerPG.mainLogoIMG().isDisplayed());
	}
	@Test(priority = 3)
	public void DownloadAppBtn() throws InterruptedException {
		
		comand.buttonClick(headerPG.downlaodAppBtn());
//		headerPG.downlaodAppBtn().click();
		if(headerPG.downlaodAppPopup().isDisplayed())
		{
			headerPG.downlaodAppBtn().sendKeys(Keys.ENTER);
		}
	}
	@Test(priority = 4)
	public void urduLanguageBtn() throws IOException
	{
//		
//		Assert.assertTrue(headerPG.urduBtn().isDisplayed());
//		headerPG.urduBtn().click();
		
		comand.buttonClick(headerPG.urduBtn());
		
		comand.webPageVarication(driver.getCurrentUrl(),prop.getProperty("urduLandingPageURL"));
		driver.navigate().back();
	}
	@Test(priority =5)
	public void main_banner_text_verification() throws IOException
	{
		//text 1 verification
		comand.textVerification(hm.mainBannerTxt1().getText().toString().toLowerCase(), prop.getProperty("mainBanner_text1").toLowerCase());
//		text 2 verification
		comand.textVerification(hm.mainBannerTxt2().getText().toString().toLowerCase(), prop.getProperty("mainBanner_text2").toLowerCase());

	}
	@Test(priority =6)
	public void search_query_test() throws IOException {
		
		//enter car model
		hm.searchFeild().sendKeys("honda");
		hm.searchFeild().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		//select city
		
		hm.search_selectCityDropDown().click();
		hm.search_selectCityDropDownInputField().sendKeys("lahore");
		if(hm.search_selectCityDropDownInput_noResult().getText().toString().toLowerCase().contains("No results matched"))
		{	
			hm.search_selectCityDropDown().click();
			
			
			}
		
		//select price range filter
		
		hm.search_priceRange_FIlter().click();
		hm.search_priceRange_Min().sendKeys("20");
		hm.search_priceRange_Max().sendKeys("80");
		
		//search
		
		hm.searchBtn().click();
		
//		Validations
		
		comand.webPageVarication(driver.getCurrentUrl(),prop.getProperty("searchURl"));
		comand.textVerification(driver.getTitle(), prop.getProperty("searchPage"));
		
		
		
	}
}

