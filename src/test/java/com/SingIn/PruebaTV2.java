package com.SingIn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaTV2 {

	private WebDriver driver;

	// para habilitar el check
	// true = se selecciona el check
	// false = no selecciona el check
	public boolean SelectAdressEnable = true;
	public boolean SelectTermsEnable = true;
	
	
	@Before
	
public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");	
	}
	
	
	@Test
	
	public void setloginusuario() throws InterruptedException, IOException {
		
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("alexisherrerasalazar9293@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageHeading = driver.findElement(By.className("page-heading")).getText();
		System.out.println("Page Heading: " +pageHeading);
	
		WebElement optionsSearch = driver.findElement(By.id("search_query_top"));
		optionsSearch.sendKeys("blouse");
		WebElement buttonsearch = driver.findElement(By.xpath("//button[@class=\"btn btn-default button-search\"]"));
		buttonsearch.click();
		
		driver.findElement(By.id("search")).click();
		driver.findElement(By.id("color_8")).click();
		
		WebElement buttonimage = driver.findElement(By.xpath("//img[@class=\"replace-2x img-responsive\"]"));
		buttonimage.click();
		WebElement button_AddCard = driver.findElement(By.xpath("//button[@class=\"exclusive\"]"));
		button_AddCard.click();
		
		//WebElement buttonCross = driver.findElement(By.xpath("//span[@class=\"cross\"]"));
		//buttonCross.click();
		
		//driver.findElement(By.className("cross")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("http://automationpractice.com/index.php?controller=order");
		
		
		WebElement buttonSummary = driver.findElement(By.xpath("//a[@class=\"button btn btn-default standard-checkout button-medium\"]"));
		buttonSummary.click();
					

		WebElement CheckAddress = driver.findElement(By.id("addressesAreEquals"));
		if(SelectAdressEnable) CheckAddress.click();
		
		WebElement button_Address = driver.findElement(By.xpath("//button[@class=\"button btn btn-default button-medium\"]"));
		button_Address.click();
		
		WebElement Check_Terms = driver.findElement(By.id("cgv"));
		if(SelectTermsEnable) Check_Terms.click();
		
		WebElement button_Shipping = driver.findElement(By.xpath("//button[@class=\"button btn btn-default standard-checkout button-medium\"]"));
		button_Shipping.click();
		
		WebElement button_PayBank = driver.findElement(By.xpath("//a[@class=\"bankwire\"]"));
		button_PayBank.click();
		
		WebElement button_ConfirmOrder = driver.findElement(By.xpath("//button[@class=\"button btn btn-default button-medium\"]"));
		button_ConfirmOrder.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	//@After
	//public void tearDown() {
		// TODO Auto-generated method stub
		//driver.quit();
			//}
}
