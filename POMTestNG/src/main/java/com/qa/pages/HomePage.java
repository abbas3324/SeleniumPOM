package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	//ContactsPage contactpage;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//i[@class='users icon']") WebElement ContactsLink;
	@FindBy(xpath="//span[@class='item-text']") WebElement ContactsButton;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']") WebElement ContactsText;
	
	public ContactsPage navigateToContactsPage() throws InterruptedException {
		ContactsLink.click();
		Thread.sleep(2000);
		//ContactsButton.click();
//		Actions act = new Actions(driver);
//		act.moveToElement(ContactsLink);
//		act.click(ContactsButton);
		Thread.sleep(5000);
		//ContactsButton.click();
		return new ContactsPage();
	}
	
	public boolean ContactsPageDisplayed() {
		return ContactsText.isDisplayed();
	}

}
