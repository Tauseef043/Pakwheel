package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.CustomCommands;

public class HeaderPageOB {
	public WebDriver driver;

private By mainLogo=By.xpath("//body[1]/div[1]/div[2]/div[1]/a[1]/img[1]");
private By downloadAppPopup=By.xpath("//div[@class='mt20']");
private By downloadAppBtn=By.xpath("//a[@class='pull-left btn-mini-app']");
private By urduBtn=By.className("urdu-img");
	public HeaderPageOB(WebDriver driver) throws IOException
	{
		
		 
		 
		this.driver=driver;
		
	}
public WebElement mainLogoIMG() {
	return driver.findElement(mainLogo);
}


public WebElement downlaodAppBtn() {
	return driver.findElement(downloadAppBtn);
}
public WebElement downlaodAppPopup() {
	return driver.findElement(downloadAppPopup);
}

public WebElement urduBtn() {
	return driver.findElement(urduBtn);
}


}
