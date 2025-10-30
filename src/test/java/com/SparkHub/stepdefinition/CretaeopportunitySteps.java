package com.SparkHub.stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.tsp.ers.SortedHashList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CretaeopportunitySteps {
	
	WebDriver driver;
	Hooks hooks;
	PropertiesMapping Property = new PropertiesMapping ();
	
	public CretaeopportunitySteps (Hooks hooks) throws IOException {	
		this.hooks = hooks;
		this.driver = hooks.getDriver();
	}	
	
	 @And ("I enter and select {string} in {string} on {string} page") // select searched keyword
	 	
	 	public void selectkeyword (String value, String webElement, String screen)throws Throwable, InterruptedException {
		 	 		
		 String WebElementLocator = Property.getObjData(screen.replaceAll("\\s+","")+"_"+webElement.replaceAll("\\s+",""));
			
			Duration duration = Duration.ofSeconds(60);
			WebDriverWait wait = new WebDriverWait (driver, duration);
			
			try {
				

			   
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElementLocator)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WebElementLocator)));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				WebElement element	= driver.findElement(By.xpath(WebElementLocator));
				   System.out.println("WebElementLocator" + WebElementLocator);
				

			  
			   element.sendKeys(value);
			   element.sendKeys(Keys.ENTER);
			   

			} catch (Exception e) {


			}

	 }
	 
	 
	 
}
