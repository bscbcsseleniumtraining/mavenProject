package com.vTigerMaven;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTigerMaven.ObjectRepository.CreateNewProductPage;
import com.vTigerMaven.ObjectRepository.HomePage;
import com.vTigerMaven.ObjectRepository.ProductsPage;

@Listeners(com.vTigerMaven.ListenerImp.class)
public class CreateProductTest extends Base
{
	public HomePage hp;
	public ProductsPage pp;
	public CreateNewProductPage cnp;	
	public Utility util = new Utility();
	
	
	@DataProvider
	public Object[][] giveData()
	{
		return util.getAllData("./src/main/java/com/vTigerMaven/testData/testData.xlsx", "Products");
	}
	
	@Test(dataProvider="giveData")
	public void createProductTest(String prodName, String man, String cat, String ven, String imgPath)
	{
		hp = PageFactory.initElements(driver, HomePage.class);
		pp = PageFactory.initElements(driver, ProductsPage.class);
		cnp = PageFactory.initElements(driver, CreateNewProductPage.class);
		
		hp.getProductsLink().click();
		pp.getCreateProductImg().click();
		
		cnp.createProduct(prodName, man, cat, ven, imgPath, driver);
		
		System.out.println("Bye");		
	}
}
