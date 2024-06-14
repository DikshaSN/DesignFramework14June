package DesignFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DesignFramework.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[placeholder='Select Country']")
	WebElement textbox;
	
	@FindBy(css=".list-group-item")
	List<WebElement> countries;
	
	@FindBy(css=".action__submit")
	WebElement orderButton;
	
	public void selectCountry(String coun) {
		textbox.sendKeys("ind");
		WebElement India = countries.stream().filter(s->s.getText().equalsIgnoreCase(coun)).findFirst().orElse(null);
		India.click();
	}
	
	public void placeOrder() {
		orderButton.click();
	}
	
}
