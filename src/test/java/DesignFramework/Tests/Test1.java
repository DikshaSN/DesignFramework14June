package DesignFramework.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DesignFramework.BaseTest.BaseTest;
import DesignFramework.BaseTest.Retry;
import DesignFramework.Pages.CartPage;
import DesignFramework.Pages.CheckoutPage;
import DesignFramework.Pages.ProductCatalogue;

public class Test1 extends BaseTest{
  
	
	@Test(dataProvider="Json Data", retryAnalyzer = Retry.class)
	public void submitOrder(HashMap<String,String> input) throws InterruptedException {
		ProductCatalogue product = landing.launchApplication(input.get("email"), input.get("password"));
		List<WebElement> productlist = product.getProductList();
		product.addProduct(input.get("product"));
		CartPage cart =product.goToCart();
		Boolean match = cart.verifyCartTile(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkpage = cart.goTocheckpage();
		checkpage.selectCountry("India");
		checkpage.placeOrder();
		
	}
	
	@DataProvider(name="Json Data")
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> data = getJsonData("D:\\Selenium\\Scripts\\DesignFramework\\src\\test\\java\\DesignFramework\\Data\\data.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
