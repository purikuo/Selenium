package sele;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

public class Test2  {
	final static String username="pure_sk129@hotmail.com";
	final static String password="pure0859669610";
		
	
	
	
	WebDriver driver;
	DesiredCapabilities DesireCaps;
	
	
	public Test2(){
		DesireCaps = new DesiredCapabilities();
		DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-1.9.2-macosx/bin/phantomjs");
		driver=new PhantomJSDriver(DesireCaps);
	}
	
	public void loginFacebook(String mail,String pwd) 
	   {
//	    WebDriver driver=new FirefoxDriver();
	    driver.get("https://www.facebook.com/");
	    driver.findElement(By.id("email")).sendKeys(mail);
	    driver.findElement(By.id("pass")).sendKeys(pwd);
	    driver.findElement(By.id("loginbutton")).click();
	   }
	
	public void getUserLiked(String user){
		WebDriver driver=new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element=new WebElement();
		driver.get("https://www.facebook.com/");
	    driver.findElement(By.id("email")).sendKeys(username);
	    driver.findElement(By.id("pass")).sendKeys(password);
	    driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.name("q")).sendKeys(user);
		try {
			 Thread.sleep(700);
		} catch (InterruptedException e) {}
		
		final String previousUrl=driver.getCurrentUrl();
		
		WebElement elem = driver.findElement(By.id("q")); // obtain an element
		elem.sendKeys(org.openqa.selenium.Keys.ENTER); // this sends an Enter key to the element

		try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
	    ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
	          public Boolean apply(WebDriver d) {
	            return (d.getCurrentUrl() != previousUrl);
	          }
	        };

	    wait.until(e);
		
		String currentUrl=driver.getCurrentUrl();
		int index = currentUrl.indexOf("?");
		String likedUrl = currentUrl.substring(0, index)+"/likes";
		driver.get(likedUrl);
		
		WebElement likes = driver.findElement(By.id("pagelet_timeline_app_collection_1064067421:2409997254:96"));
		
		String script=likes.getAttribute("innerHTML");
        System.out.println(((JavascriptExecutor) driver).executeScript(script));//.executeJavaScript<string>("return arguments[0].innerHTML", demoDiv));
		
		/** Declare variables **/
		String descriptionTextXPath = "//div[contains(@id='pagelet_timeline_app_collection_1064067421:2409997254:96')]/div";

		/** Find the element **/
		WebElement element = driver.findElement(By.xpath(descriptionTextXPath));

		/** Grab the text **/
		String descriptionText = element.getText();
		
		System.out.println(descriptionText);
	}
	
	public static String getAboutUser(String user) throws IOException{
		
		WebDriver driver=new FirefoxDriver();
//		DesiredCapabilities DesireCaps = new DesiredCapabilities();
//		DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-2.0.0-macosx/bin/phantomjs");
//		WebDriver driver=new PhantomJSDriver(DesireCaps);

		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element=new WebElement();
		driver.get("https://www.facebook.com/");
	    driver.findElement(By.id("email")).sendKeys(username);
	    driver.findElement(By.id("pass")).sendKeys(password);
	    driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.name("q")).sendKeys(user);
		try {
			 Thread.sleep(700);
		} catch (InterruptedException e) {}
		
//		final String previousUrl=driver.getCurrentUrl();
		
		WebElement elem = driver.findElement(By.id("q")); // obtain an element
		elem.sendKeys(org.openqa.selenium.Keys.ENTER); // this sends an Enter key to the element

		try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
//	    ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
//	          public Boolean apply(WebDriver d) {
//	            return (d.getCurrentUrl() != previousUrl);
//	          }
//	        };
//	    wait.until(e);
		
	    File outFile=new File("out.html");
	    FileWriter fw=new FileWriter(outFile);
//	    BufferedWriter br= new BufferedWriter(fw);
	    
		String currentUrl=driver.getCurrentUrl();
		int index = currentUrl.indexOf("?");
		String aboutUrl = currentUrl.substring(0, index)+"/about?section=";
		
		driver.get(aboutUrl+"education");
		fw.write("<h3><u>การศึกษาและการทำงาน</u></h3>");
		List<WebElement> edLinks = driver.findElements(By.xpath("//div[@class='_2lzr _50f5 _50f7']/a"));
		System.out.println("links : "+edLinks.size());
		for(WebElement link:edLinks){
			System.out.println("<a href=\""+link.getAttribute("href")+"\">"+link.getText()+"</a>");
			fw.write("<a href=\""+link.getAttribute("href")+"\">"+link.getText()+"</a>"+"<br>");
		}
		fw.write("<br><br>");
		
		driver.get(aboutUrl+"living");
		fw.write("<h3><u>ที่อยู่</u></h3>");
		List<WebElement> livInfo = driver.findElements(By.xpath("//span[@class='_50f5 _50f7']/a"));
		System.out.println("links : "+livInfo.size());
		for(WebElement link:livInfo){
			System.out.println(link.getText());
			fw.write(link.getText()+"<br>");
		}
		fw.write("<br><br>");
		
		driver.get(aboutUrl+"contact-info");
		fw.write("<h3><u>ข้อมูลการติดต่อและข้อมูลพื้นฐาน</u></h3>");
//		List<WebElement> conInfo = driver.findElements(By.xpath("//a[@class='_4ea3']"));
//		List<WebElement> conInfo = driver.findElements(By.xpath("//ul[@class='uiList _4kg _6-h _704 _6-i']/li/span"));
		List<WebElement> othInfo = driver.findElements(By.xpath("//span[@class='_50f4']"));
		List<WebElement> types = driver.findElements(By.xpath("//span[@class='_50f8 _50f4 _5kx5']"));
		//		System.out.println("links : "+conInfo.size());
		System.out.println("links : "+othInfo.size());
/*		for(WebElement link:conInfo){
			System.out.println(link.getText());
			fw.write(link.getText()+"<br>");
		}*/
		Iterator<WebElement> type= types.iterator();
		for(WebElement link:othInfo){
			String ty=type.next().getText();
			System.out.print(ty+" : ");
			String text=link.getText();
			if(text.length()>5 && text.substring(0, 6).equals("ขอทราบ")) text="-";
			System.out.println(text);
			fw.write("<b><u>"+ty+"</u></b> :&nbsp;&nbsp;&nbsp;"+text+"<br>");
		}
		fw.write("<br><br>");
		
		driver.get(aboutUrl+"relationship");
		fw.write("<h3><u>ครอบครัวและความสัมพันธ์</u></h3>");
		List<WebElement> relInfo = driver.findElements(By.xpath("//div[@class='_4qm1 editAnchor']"));
		for(WebElement link:relInfo){
			String line=link.getText();
			String[] text=line.split("\n");	
			System.out.println(text.length);

			if(text.length<=1){
				
			}
			else if(text.length>1){
				if(text[1].equals("ไม่มีข้อมูลการคบหาให้แสดง")) text[1]="-";
				System.out.println(text[0]);
				System.out.println(text[1]);
				fw.write(text[0]+"<br>");
				fw.write(text[1]);
			}
			else if(text.length>2){
				System.out.println(text[0]);
				System.out.println(text[2]);
				System.out.println(text[1]);
				fw.write(text[0]+"<br>");
				fw.write(text[2]+"<br>");
				fw.write(text[1]);
			}
			
		}
		fw.write("<br><br>");
		
		driver.get(aboutUrl+"bio");
		fw.write("<h3><u>รายละเอียดอื่นๆ</u></h3>");
		List<WebElement> otherInfo = driver.findElements(By.xpath("//div[@class='_4qm1 editAnchor']"));
		for(WebElement link:otherInfo){
			System.out.println(link.getText());
		}
		fw.write("<br><br>");
		
		driver.get(aboutUrl+"year-overviews");
		fw.write("<h3><u>เหตุการณ์ในชีวิต</u></h3>");
		
		driver.quit();
		fw.close();
		return "Hello";
		
//		WebElement likes = driver.findElement(By.id("pagelet_timeline_app_collection_1064067421:2409997254:96"));
		
	}
	
    public static void main(String[] args) throws IOException {
    	  // prepare capabilities
       
        Test2 t = new Test2();
        t.getAboutUser("ณัฐ อำนวยผลวิวัฒน์");
    }
}

