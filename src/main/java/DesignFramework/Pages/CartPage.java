package DesignFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DesignFramework.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartTitles;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkButton;
	
	public Boolean verifyCartTile(String product) {
		Boolean match = cartTitles.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}
	
	public CheckoutPage goTocheckpage() {
		checkButton.click();
		CheckoutPage checkpage = new CheckoutPage(driver);
		return checkpage;
	}

}
