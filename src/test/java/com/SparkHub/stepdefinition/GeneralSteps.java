package com.SparkHub.stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SparkHub.Spark_Hub_Automation.utilityClass;
import com.SparkHub.stepdefinition.Hooks;
import com.SparkHub.stepdefinition.PropertiesMapping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GeneralSteps {

	WebDriver driver ;
	Hooks hooks;

	public GeneralSteps (Hooks hooks) throws IOException {	
		this.hooks = hooks;
		this.driver = hooks.getDriver();
	   
	}

	PropertiesMapping Property = new PropertiesMapping () ;

	@When("I click {string} on {string} page")
	
	public void clickWebElement (String webElement, String screen) throws Throwable, InterruptedException {
		
		String WebElementLocator = Property.getObjData(screen.replaceAll("\\s+","") +"_"+webElement.replaceAll("\\s+",""));
		
		Duration duration = Duration.ofSeconds(60);
		WebDriverWait wait = new WebDriverWait (driver, duration);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElementLocator)));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WebElementLocator)));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			driver.findElement(By.xpath(WebElementLocator)).click();

		} catch (Exception e) {

		}
		}

		@When("I enter {string} in {string} on {string} page") // sendkeys

		public void sendKeys (String value, String webElement, String screen) throws Throwable, InterruptedException {
		String WebElementLocator = Property.getObjData(screen.replaceAll("\\s+","")+"_"+webElement.replaceAll("\\s+",""));
		
		Duration duration = Duration.ofSeconds(60);
		WebDriverWait wait = new WebDriverWait (driver, duration);
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElementLocator)));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WebElementLocator)));
			JavascriptExecutor js = (JavascriptExecutor) driver;

		   WebElement element	= driver.findElement(By.xpath(WebElementLocator));

		   element.clear();
		   element.sendKeys(value);
		   

		} catch (Exception e) {


		}

	}

     @Given ("I am logged in BrokerHub")  // BrokerHub login

     public void loginSparkplug() throws IOException, InterruptedException{

    	    	
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	 driver.manage().window().maximize();
    	 
    	 driver.get(Property.getEnvData("EnvURL"));

    	 driver.findElement(By.xpath(Property.getObjData("Login_User_Locator"))).sendKeys(Property.getEnvData("LoginUser"));


    	 try {

    	 		driver.findElement(By.xpath(Property.getObjData("Login_Button_Locator"))).click();

    	 		}catch(Exception e) {

    	 					}
    	
    	 driver.findElement(By.id(Property.getObjData("Login_Password_Locator"))).sendKeys(Property.getEnvData("LoginPwd"));


    	 try {

 	 		driver.findElement(By.xpath(Property.getObjData("Login_Button_Locator_new"))).click();

 	 		}catch(Exception e) {

 	 					}
}
     
     @And("I select {string} in {string} for {string} on {string} page")  // suggestion handling
		

		public void selectOppCustomer (String value , String webElement ,String baseWebElement, String screen) throws Throwable, InterruptedException {
    	
 		String WebElementLocator = Property.getObjData(screen.replaceAll("\\s+","") +"_"+webElement.replaceAll("\\s+",""));
 		String baseWebElementLocator = Property.getObjData(baseWebElement.replaceAll("\\s+",""));
 		
		Duration duration = Duration.ofSeconds(60);
		WebDriverWait wait = new WebDriverWait (driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(WebElementLocator)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		try {

			List <WebElement> elements = driver.findElement (By.id(baseWebElementLocator)).findElements(By.cssSelector(WebElementLocator));
			for (WebElement element : elements) {
				
			if (element.getText().contains(value)) {
				element.click();
				break;
			} 
			
			}

		} catch (Exception e) {
              

		}

	}
     
     @And("I select radio button {string} on {string} page") // Radio button handling
     
     public void selectRadioButton (String webElement, String screen) {
    	 
    	 String WebElementLocator = Property.getObjData(screen.replaceAll("\\s+","")+"_"+webElement.replaceAll("\\s+",""));
    	 
    	 Duration duration = Duration.ofSeconds(60);
 		WebDriverWait wait = new WebDriverWait (driver, duration);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(WebElementLocator)));
 		JavascriptExecutor js = (JavascriptExecutor) driver;
 		
    	 
    	 try {
    		 
    		driver.findElement(By.cssSelector(WebElementLocator)).click();
    		 
    		 
    	 } catch (Exception e) {
    		 
    		 
    	 }
    	 
     }
     
     @And("I select {string} from current date on {string} page") 
    	 
    	 public void startDateAfter15days (String webElement , String screen)  {
    	 
    	String WebElementLocator = Property.getObjData(screen.replaceAll("\\s+","")+"_"+webElement.replaceAll("\\s+",""));
    	
    	Duration duration = Duration.ofSeconds(60);
 		WebDriverWait wait = new WebDriverWait (driver, duration);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElementLocator)));
 		JavascriptExecutor js = (JavascriptExecutor) driver; 
 		
 		try {
 			
 			WebElement element = driver.findElement(By.xpath(WebElementLocator));
 			element.clear();
 					element.click();
 			utilityClass util = new utilityClass();
 		String startDate	= util.getStartDate();
 			element.sendKeys(startDate);
 			
 		} catch (Exception e) {
 			
 			
 		}
    	
    	
     }
     
     
    

}
