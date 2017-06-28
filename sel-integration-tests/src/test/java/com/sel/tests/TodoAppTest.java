package com.sel.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sel.tests.pageobjects.TodoPage;
import com.sel.tests.utils.TestHelper;

public class TodoAppTest extends AbstractTest{

	private static String TODO_FIRST = "first";
	private static String TODO_SECOND = "second";
	private static String TODO_THIRD = "third";
	private TodoPage todo;

//	@Test(groups= {"ignore"})
//	public void testTodoAdd() throws Exception {
//
//		todo = PageFactory.initElements(driver, TodoPage.class);
//		driver.get(TestHelper.TODO_TARGET_SERVER_URL);
//
//		todo.setTodo(TODO_FIRST);
//
//		TestHelper.takeScreenShot(driver, reporter, "Todo lists");
//		assertEquals(todo.getItems(), "1", "Wrong number of items");
//
//		TestHelper.clearLocalStorage(driver);
//		TestHelper.takeScreenShot(driver, reporter, "Cleared todo lists");
//	}
//
//	@Test(groups= {"ignore"})
//	public void testTodoDelete() throws Exception {
//
//		todo = PageFactory.initElements(driver, TodoPage.class);
//		driver.get(TestHelper.TODO_TARGET_SERVER_URL);
//
//		todo.setTodo(TODO_FIRST);
//
//		TestHelper.takeScreenShot(driver,reporter, "testTodoDelete Todo lists");
//		assertEquals(todo.getItems(), "1", "Wrong number of items");
//
//		todo.setTodo(TODO_SECOND);
//		todo.setTodo(TODO_THIRD);
//
//		TestHelper.takeScreenShot(driver,reporter, "testTodoDelete Todo lists");
//		assertEquals(todo.getItems(), "3", "Wrong number of items");
//
//		todo.deleteFirst();
//		assertEquals(todo.getItems(), "2", "Wrong number of items");
//		TestHelper.takeScreenShot(driver,reporter, "testTodoDelete Todo new list");
//		
//		assertFalse(todo.checkFilters(), "Filters are visible");
//		TestHelper.clearLocalStorage(driver);
//	}

	@Test(groups={"uitest"})
	public void testTodoComplete() throws Exception {

		todo = PageFactory.initElements(driver, TodoPage.class);
		driver.get(TestHelper.TODO_TARGET_SERVER_URL);

		todo.setTodo(TODO_FIRST);
		todo.setTodo(TODO_SECOND);
		TestHelper.takeScreenShot(driver,reporter, "Todo lists");

		assertEquals(todo.getItems(), "2", "Wrong number of items");
		todo.completeFirst();
		assertEquals(todo.getItems(), "1", "Wrong number of items");
		TestHelper.takeScreenShot(driver,reporter, "testTodoComplete Todo new list");
		
		todo.showCompleted();
		assertEquals(todo.getItems(), "1", "Wrong number of items");
		TestHelper.takeScreenShot(driver,reporter, "testTodoComplete Completed list");
		
		TestHelper.clearLocalStorage(driver);
	}
}
