package com.sel.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sel.tests.pageobjects.WtaPage;
import com.sel.tests.pageobjects.WtaRankingPage;
import com.sel.tests.utils.TestHelper;

public class CheckHalepRankTest extends AbstractTest{

	private WtaPage wta;
	private WtaRankingPage wtaRanking;
	
	@Test(groups={"uitest"})
	public void checkHalepRanking() {
		
		wta = PageFactory.initElements(driver, WtaPage.class);
		driver.get(TestHelper.WTA_SERVER_URL);
		TestHelper.takeScreenShot(driver,reporter, "Wta site");
		
		wtaRanking = wta.gotoRanking();
		
		wtaRanking.searchBy("halep");
		//wtaRanking.search();
		TestHelper.takeScreenShot(driver,reporter, "Wta site");
		
		assertEquals(wtaRanking.getRank(), "2", "Wrong rank for Halep");
	}
}
