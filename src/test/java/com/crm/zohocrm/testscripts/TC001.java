package com.crm.zohocrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crm.zohocrm.pom.CampaignsListPage;

public class TC001 extends BaseTest {
	@Test(description="To Create A Campain and Verify in Campaign Details Page")
	public void testCampaignIsDisplayed() {
		
		Assert.assertEquals(homePage.verifyTitle(),true,"Home Page Title is Not Correct");
				
		CampaignsListPage campaignsListPage=(CampaignsListPage) homePage.clickOnNavTabLink("Campaigns");
		
		Assert.assertEquals(campaignsListPage.verifyAllCampaignsTitle(),
					true, "All Campaigns Title is not displayed");
		
		campaignsListPage.createCampaign("IphoneMobile");
		
		Assert.assertEquals(campaignsListPage.verifyCampaignDetailsTitle(),
				true, "Campaigns Details Title is not displayed");
		
		homePage.clickOnNavTabLink("Campaigns");
		
		Assert.assertEquals(((CampaignsListPage) homePage.clickOnNavTabLink("Campaigns")).verifyAllCampaignsTitle(),
					true, "All Campaigns Title is not displayed");
		
		Assert.assertEquals(campaignsListPage.verifyCampaign("IphoneMobile"),true,
						"Home Page Title is Not Correct");
	}
	
	@AfterMethod
	public void deleteCampaign() {
		System.out.println("Before Logout===> delete campaign");
	}
}
