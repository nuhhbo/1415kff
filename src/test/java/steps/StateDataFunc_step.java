package steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.StateDataPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class StateDataFunc_step {
	
	StateDataPage stateDataPage = new StateDataPage();
	
	@Given("users goes to State Health Facts page")
	public void users_goes_to_State_Health_Facts_page() {
	    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	@Then("United States map should be visible")
	public void united_States_map_should_be_visible() {
		Assert.assertTrue(stateDataPage.WholeMap.isDisplayed());
	}

	@When("user hover mouse over Texas")
	public void user_hover_mouse_over_Texas() throws InterruptedException {
	   BrowserUtils.scrollDown("300");
	   BrowserUtils.hover(stateDataPage.TexasMap);
	}

	@When("user hover mouse over following states")
	public void user_hover_mouse_over_following_states(List<String> products) throws InterruptedException {
//		BrowserUtils.scrollDown("300");
		BrowserUtils.scrollDown1();
		for (String string : products) {
			BrowserUtils.hover(stateDataPage.item(string));
			Thread.sleep(500);
		}
	}
	
	@Then("following states text should be displayed")
	public void following_states_text_should_be_displayed(List<String> products) {
		for (String string : products) {
			Assert.assertTrue(stateDataPage.item(string).isDisplayed());
		}
		
	}
	
	@Then("Texas text should be displayed")
	public void texas_text_should_be_displayed() {
	   String str = stateDataPage.TexasText.getText();
	   Assert.assertEquals("Texas", str);
	}

	@When("user clicks on the Ohio state on map")
	public void user_clicks_on_the_Ohio_state_on_map() {	
	   BrowserUtils.scrollDown("400");
	   stateDataPage.OhioMap.click();
	}
	
	@Then("url should be {string}")
	public void url_should_be(String expected) {
		String actual = Driver.getDriver().getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	
	
	
	
	

	}



