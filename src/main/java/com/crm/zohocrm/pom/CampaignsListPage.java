package com.crm.zohocrm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.zohocrm.generic.WebActionUtil;

public class CampaignsListPage extends BasePage {
	
	@FindBy(xpath="//input[@value='New Campaign']")
	private WebElement newCampaignButton;
	
	@FindBy(name="property(Campaign Name)")
	private WebElement newCampainNameTextField;
	
	@FindBy(xpath="//td[contains(text(),'Campaign Information')]/ancestor::table[@id='secHead1']/preceding-sibling::table//input[@value='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//td[@class='title hline']")
	private WebElement titleText;
	
	@FindBy(xpath="//td[@class='tableData']/a")
	private List<WebElement> allCampaignsList;
	
	
	public WebElement getNewCampaignButton() {
		return newCampaignButton;
	}

	public WebElement getNewCampainNameTextField() {
		return newCampainNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getTitleText() {
		return titleText;
	}

	public List<WebElement> getAllCampaignsList() {
		return allCampaignsList;
	}


	public CampaignsListPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	/**
	 * creates a campaign with mandatory field Campaign Name
	 */
	public void createCampaign(String campaignName) {
		webActionUtil.click(newCampaignButton);
		webActionUtil.enterData(newCampainNameTextField, campaignName);
		webActionUtil.click(saveButton);
	}
	
	public boolean verifyCampaign(String campaignName) {
		for(WebElement ele:allCampaignsList) {
			if(ele.getText().equalsIgnoreCase(campaignName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyAllCampaignsTitle() {
		return titleText.getText().contains("All Campaigns");
	}
	
	public boolean verifyCreateCampaignTitle() {
		return titleText.getText().contains("Create Campaign");
	}
	
	public boolean verifyCampaignDetailsTitle() {
		return titleText.getText().contains("Campaign Details");
	}
	
	
}
