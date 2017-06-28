package com.sel.tests.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {
private WebDriver driver;
	
	public GmailLoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(id="identifierId")
	private WebElement username;
	
	@FindBy(id="identifierNext")
	private WebElement next;
	
	@FindBy(id="passwordNext")
	private WebElement login;

	@FindBy(xpath="//*[@id='password']/div[1]/div/div[1]/input")
	private WebElement password;
	
	public void setPassword(String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))); 
        driver.findElement(By.id("password")).sendKeys(pass);
	}
	
	public GmailAccount login() {
		this.login.click();
		return PageFactory.initElements(driver, GmailAccount.class);
	}

	public void setUsername(String username) {
		this.username.sendKeys(username);
	}

	public void next() {
		this.next.click();
	}
}
