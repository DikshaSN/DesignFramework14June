package DesignFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DesignFramework.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> productlist;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productList = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.id("toast-container");

	public List<WebElement> getProductList() {
		waitforElementToAppear(productList);
		return productlist;

	}

	public WebElement getProductByName(String product) {
		WebElement product1= getProductList().stream().filter(s->s.findElement(By.tagName("b")).getText().equalsIgnoreCase(product)).findFirst().orElse(null);
		return product1;
	}
	
	public void addProduct(String product) throws InterruptedException {
		WebElement prod = getProductByName(product);
		prod.findElement(addToCart).click();
		waitforElementToAppear(toastMessage);
		waitforElementToDisAppear(spinner);
	}

}
