package DesignFramework.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DesignFramework.Pages.CartPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartButton;
	
	public void waitforElementToAppear(By ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	public void waitforElementToDisAppear(WebElement ele) throws InterruptedException {
		Thread.sleep(3000);
	}
	
	public CartPage goToCart() {
		cartButton.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}

}
