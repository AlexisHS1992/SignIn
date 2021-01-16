package com.SingIn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaTV2 {

	private WebDriver driver;

	// para habilitar el check
	// true = se selecciona el check
	// false = no selecciona el check
	public boolean SelectSignUpEnable = true;
	public boolean OffersEnable = true;
	
	
	@Before
	
public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");	
	}
	
	
	@Test
	
	public void testNewEXperience( ) {
		
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("alexisherrerasalazar9293@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageHeading = driver.findElement(By.className("page-heading")).getText();
		System.out.println("Page Heading: " +pageHeading);
	
	}
	@After
	private void tearDown() {
		// TODO Auto-generated method stub
		driver.quit();
			}
}
