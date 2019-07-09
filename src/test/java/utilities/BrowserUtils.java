package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class BrowserUtils {
	
	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	}
	
	public static void scrollDown(String sr) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scrollBy(0," + sr + ")");
	}
	
	public static void scrollDown1() {
		Actions actions = new Actions(Driver.getDriver());
		actions.sendKeys(Keys.PAGE_DOWN).perform();
	}
	
	public static void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("argument[0].scrollIntoView(true)", element);
	}
	
	
	public static List<String> getElementsText(By locator){
		List<WebElement> elems = Driver.getDriver().findElements(locator);
		List<String> elemText = new ArrayList<>();
		
		for (WebElement el : elems) {
			if(!el.getText().isEmpty()) {
				elemText.add(el.getText());
			}
		}
		return  elemText;
	}
	

	
	

}
