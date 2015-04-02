package sele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test3 {
    public static void main(String[] args) {
    
    	WebDriver driver = new FirefoxDriver();
    	
		 //   	DesiredCapabilities DesireCaps = new DesiredCapabilities();
		  //  	DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-2.0.0-macosx/bin/phantomjs");
		   // 	WebDriver driver=new PhantomJSDriver(DesireCaps);

		        // And now use this to visit Google
		        driver.get("http://www.google.com");
		        // Alternatively the same thing can be done like this
		        // driver.navigate().to("http://www.google.com");

		        // Find the text input element by its name
		        WebElement element = driver.findElement(By.name("q"));

		        // Enter something to search for
		        element.sendKeys("Cheese!");

		        // Now submit the form. WebDriver will find the form for us from the element
		        element.submit();

		        // Check the title of the page
		        System.out.println("Page title is: " + driver.getTitle());
		        
		        // Google's search is rendered dynamically with JavaScript.
		        // Wait for the page to load, timeout after 10 seconds
		       

		        // Should see: "cheese! - Google Search"
		        System.out.println("Page title is: " + driver.getTitle());
		        
		        //Close the browser
		        
    }
}
