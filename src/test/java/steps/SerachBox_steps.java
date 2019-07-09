package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SearchResultPage;
import pages.StateDataPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SerachBox_steps {
	SearchResultPage srp = new SearchResultPage();
	StateDataPage sdp = new StateDataPage();
	
	@Then("verify that search box is visible")
	public void verify_that_search_box_is_visible() {
	    Assert.assertTrue(sdp.SearchBox.isDisplayed());
	}

	@When("user types {string} in the search box on the top and click on the search button")
	public void user_types_in_the_search_box_on_the_top_and_click_on_the_search_button(String string) {
	    sdp.SearchBox.sendKeys(string + Keys.ENTER);
	}

	@Then("results should include {string} keyword")
	public void results_should_include_keyword(String string) {
	   String actual = srp.SearchResult.getText();
	   Assert.assertEquals(string, actual);
	}

	@Then("results should automatically listed under State Data")
	public void results_should_automatically_listed_under_State_Data() {
//	   List<WebElement> list = Driver.getDriver().findElements(By.xpath("//section[@class='search-results-wrapper']/article/h5"));
//	   for (WebElement webElement : list) {
//		System.out.println(webElement.getText());
		List<String> ls = BrowserUtils.getElementsText(By.xpath("//section[@class='search-results-wrapper']/article/h5"));
		for (String string : ls) {
			System.out.println(string);
		}
	}
	
	@Given("user goes to State Health Facts page")
	public void user_goes_to_State_Health_Facts_page() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}
	
	@When("user scrolls down till New and Update Indicators")
	public void user_scrolls_down_till_New_and_Update_Indicators() throws InterruptedException {
		BrowserUtils.scrollDown("800");
		Thread.sleep(1000);
	}

	@Then("Verify that articles are sorted in descending order, newest being at the top")
	public void verify_that_articles_are_sorted_in_descending_order_newest_being_at_the_top() {
		List<String> ls = BrowserUtils.getElementsText(By.xpath("//div[@class='indicators-list']//p"));
	     for (String string : ls) {
			System.out.println(string);
		}
	     
	     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
	     System.out.println(LocalDate.now());
	     
	     
	     for (String string : ls) {
	    	 System.out.println(dtf.format(LocalDate.now()));
		}
	     
	}
	
	
	
	
}




