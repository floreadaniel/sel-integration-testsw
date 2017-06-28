package com.sel.tests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WtaPage {
	
	private WebDriver driver;

	public WtaPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	@FindBy(xpath="//a[text() = 'Rankings']")
	private WebElement ranking;
	
	public WtaRankingPage gotoRanking() {
		ranking.click();
		return PageFactory.initElements(driver, WtaRankingPage.class);
	}
}
