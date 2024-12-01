package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.Loginpage;

public class Airbnb_Hotel_Booking {
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.airbnb.co.in/");
	driver.manage().window().maximize();
	
	
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(5))
			.ignoring(NoSuchElementException.class);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='bigsearch-query-location-input']"))).click();
	driver.findElement(By.xpath("//input[@id='bigsearch-query-location-input']")).sendKeys("Lonavala, Maharashtra");
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='bigsearch-query-location-listbox']")));
      
		Wait<WebDriver> wait12 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		 //wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='bigsearch-query-location-listbox']//div[text()='Lonavala, Maharashtra']"))).click();
		wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='bigsearch-query-location-suggestion-0']"))).click();


      Wait<WebDriver> wait19 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		 //wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Move forward to change to the next month.']"))).click();
      wait19.until(ExpectedConditions.elementToBeClickable(By.className("_qz9x4fc"))).click();
      Wait<WebDriver> wait16 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		 //wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Move forward to change to the next month.']"))).click();
        wait16.until(ExpectedConditions.elementToBeClickable(By.className("_qz9x4fc"))).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.findElement(By.xpath("//*[contains(@data-testid,'25/02/2025')]")).click();
      
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.findElement(By.xpath("//*[contains(@data-testid,'28/02/2025')]")).click();
      


      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.findElement(By.className("p1m42al0")).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.findElement(By.xpath("//button[contains(@data-testid,'stepper-adults-increase-button')]")).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.findElement(By.xpath("//button[contains(@data-testid,'stepper-adults-increase-button')]")).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.findElement(By.xpath("//button[contains(@data-testid,'stepper-children-increase-button')]")).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.findElement(By.xpath("//button[contains(@data-testid,'stepper-children-increase-button')]")).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.findElement(By.xpath("//button[contains(@data-testid,'structured-search-input-search-button')]")).click();

	  
	  Wait<WebDriver> wait29 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		 //wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Move forward to change to the next month.']"))).click();
        wait29.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-testid,'category-bar-filter-button')]"))).click();


        driver.findElement(By.xpath("//a[normalize-space()='Show 1,000+ places']")).click();
        //List<WebElement> top5Locations = driver.findElements(By.cssSelector(".l1icvf1x.atm_h3_p5ox87.atm_h3_idpfg4_13mkcot.l14cupch.atm_gq_p5ox87.atm_gq_idpfg4_8dt821.dir.dir-ltr"));

        Wait<WebDriver> wait36 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
        WebElement storeAddress=  wait36.until(ExpectedConditions.visibilityOfElementLocated(By.className("gsgwcjk"))); 

       

        

        List<WebElement> locationElements = driver.findElements(By.className("gsgwcjk"));
        int count = 0;  // Track the number of locations found

;
        for (WebElement locationElement : locationElements) {
            WebElement ratingElement = locationElement.findElement(By.xpath(".//div[@data-testid='listing-rating']"));
            String ratingText = ratingElement.getText();
            double rating = Double.parseDouble(ratingText.substring(0, 3));

            if (rating >= 4.5) {
                WebElement nameElement = locationElement.findElement(By.xpath(".//div[@data-testid='listing-title']"));
                String name = nameElement.getText();
                System.out.println((count + 1) + ". " + name + " (Rating: " + rating + ")");
                count++;
            }

            if (count == 5) {
                break;
            }
        }
    }
}