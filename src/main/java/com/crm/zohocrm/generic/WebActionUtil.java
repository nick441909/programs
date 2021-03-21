package com.crm.zohocrm.generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil {
	
	WebDriverWait wait;
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	
	public WebActionUtil(WebDriver driver,long ETO) {
		this.driver=driver;
		wait = new WebDriverWait(driver,ETO);
		js = (JavascriptExecutor)driver;
		actions = new Actions(driver);
	}
	
	public void enterData(WebElement target, String text) {
		wait.until(ExpectedConditions.visibilityOf(target));
		target.clear();
		target.sendKeys(text);
	}
	
	public void click(WebElement target) {
		wait.until(ExpectedConditions.elementToBeClickable((target)));
		target.click();
	}
	
	public void staleClick(WebElement target) {
		wait.until(ExpectedConditions.stalenessOf((target)));
		target.click();
	}
	
	public void jsClick(WebElement target) {
		js.executeScript("arguments[0].click();", target);
	}
	
	public void scrollToEnd() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	public void scrollToTop() {
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	}
	
	public void jsEnterData(WebElement target, String text) {
		js.executeScript("arguments[0].value=arguments[1];", target, text);
	}
	
	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}
	
	public void mouseHover(WebElement target) {
		actions.moveToElement(target).perform();
	}
	
	public void doubleClick(WebElement target) {
		actions.doubleClick(target).perform();
	}
	
	public void selectByVisibleText(WebElement listboxElement,String text) {
		Select select = new Select(listboxElement);
		select.deselectByVisibleText(text);
	}
	
	public void switchToFrame(String idNameOrIndex) {
		try {
			int index = Integer.parseInt(idNameOrIndex);
			driver.switchTo().frame(index);
		} catch(NumberFormatException e) {
			driver.switchTo().frame(idNameOrIndex);
		}
	}
}
