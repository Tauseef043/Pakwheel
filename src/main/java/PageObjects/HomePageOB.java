package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.CustomCommands;

public class HomePageOB {
	public WebDriver driver;

private By mainbannerTxt1=By.xpath("//div[@id='main-container']/section[2]/div/h1");
private By mainbannerTxt2=By.xpath("//div[@id='main-container']/section[2]/div/p");
private By searchFeild=By.id("home-query");
private By search_selectCityDropDown=By.id("UsedCity_chzn");
private By search_selectCityDropDownInputField=By.xpath("//div[@class='chzn-drop']/div/input");

private By search_selectCityDropDownInput_noResult=By.xpath("//div[@class='no-results']");
private By search_priceRange_FIlter=By.id("pr-range-filter");
private By search_priceRange_Min=By.id("pr_from");
private By search_priceRange_Max=By.id("pr_to");
private By searchBtn=By.id("home-search-btn");
	public HomePageOB(WebDriver driver) throws IOException
	{
		
		 
		 
		this.driver=driver;
		
	}
	public WebElement mainBannerTxt1()
	{
		return driver.findElement(mainbannerTxt1);
	}
	public WebElement mainBannerTxt2()
	{
		return driver.findElement(mainbannerTxt2);
	}
	public WebElement searchFeild()
	{
		return driver.findElement(searchFeild);
	}
	public WebElement search_selectCityDropDown()
	{
		return driver.findElement(search_selectCityDropDown);
	}
	public WebElement search_priceRange_FIlter()
	{
		return driver.findElement(search_priceRange_FIlter);
	}
	public WebElement searchBtn()
	{
		return driver.findElement(searchBtn);
	}
	public WebElement search_selectCityDropDownInputField()
	{
		return driver.findElement(search_selectCityDropDownInputField);
	}
	public WebElement search_priceRange_Min()
	{
		return driver.findElement(search_priceRange_Min);
	}
	public WebElement search_priceRange_Max()
	{
		return driver.findElement(search_priceRange_Max);
	}
	public WebElement search_selectCityDropDownInput_noResult()
	{
		return driver.findElement(search_selectCityDropDownInput_noResult);
	}
}
