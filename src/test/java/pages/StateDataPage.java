package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class StateDataPage {
	
	WebDriver driver;

	public StateDataPage() {
		driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "map-container")
	public WebElement WholeMap;
	
	@FindBy(xpath = "//*[@class='datamaps-subunit TX']")
	public WebElement TexasMap;
	
	@FindBy(xpath = "(//div[@class='datamaps-hover']//span)[3]")
	public WebElement TexasText;
	
	@FindBy(xpath = "//*[@class='datamaps-subunit OH']")
	public WebElement OhioMap;
	
	@FindBy(id = "search-field")
	public WebElement SearchBox;
	
	public WebElement item(String item) {
		String xpath = "//*[@class='datamaps-subunit " +item+ "']";
		return Driver.getDriver().findElement(By.xpath(xpath));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
