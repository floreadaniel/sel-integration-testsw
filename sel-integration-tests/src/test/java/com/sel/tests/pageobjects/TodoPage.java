package com.sel.tests.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage {
	
	private WebDriver driver;

	public TodoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	@FindBy(id = "new-todo")
	WebElement todo;
	
	@FindBy(id = "filters")
	WebElement filters;

	@FindBy(xpath="//strong[@class='ng-binding']")
	WebElement items;
	
	@FindBy(xpath="//button[@class='destroy']")
	List<WebElement> deleteButtons;
	
    public void setTodo(String todo) {
		if (this.todo.isDisplayed()) {
			this.todo.sendKeys(todo);
			this.todo.sendKeys(Keys.ENTER);
		}
	}

	public String getItems() {
		return items.getText();
	}
	
	public void deleteAll() {
		for (WebElement deleteButton : deleteButtons) {
			deleteButton.click();
		}
	}
	
	public boolean checkFilters() {
		return this.filters.isDisplayed();
	}

}
