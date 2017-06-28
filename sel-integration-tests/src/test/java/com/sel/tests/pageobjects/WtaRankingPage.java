package com.sel.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WtaRankingPage {

	private WebDriver driver;

	public WtaRankingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath="//*[@id='table-rankings-footable']/thead/tr[1]/th/form/div[2]/div/input")
	private WebElement searchBy;

	@FindBy(css=".btn .btn-primary")
	private WebElement search;

	@FindBy(xpath="//*[@id='table-rankings-footable']/tbody/tr/td[1]")
	private WebElement rank;

	public void search() {
		search.click();
	}

	public void searchBy(String text) {
		this.searchBy.sendKeys(text);
	}

	public String getRank() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fooicon-remove"))); 
		return rank.getText();
	}
}
