package com.sel.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailAccount {

	private WebDriver driver;
	
	public GmailAccount(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(xpath="//a[@text=Sent Mail]")
	private WebElement sentLink;
	
	@FindBy(xpath="//*[@id=':99']/div/div")
	private WebElement compose;
	
	@FindBy(xpath="//textarea[@name='to']")
	private WebElement recipients;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	private WebElement subject;

	@FindBy(xpath="//div[@aria-label='Message Body']")
	private WebElement body;
	
	@FindBy(xpath="//div[contains(string(),'Send')]")
	private WebElement send;
	
	public void sent() {
		this.sentLink.click();
	}
	
	public void send() {
		this.send.click();
	}
	
	public void compose() {
		//WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=':99']/div/div")));
		this.compose.click();
	}
	
	public void setRecipients(String recipients) {
		this.recipients.sendKeys(recipients);
	}
	
	public void setSubject(String subject) {
		this.subject.sendKeys(subject);
	}
	
	public void setBody(String body) {
		this.body.sendKeys(body);
	}
}
