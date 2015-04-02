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

public class TestSelenium  {
	final static String username="pure_sk129@hotmail.com";
	final static String password="pure0859669610";
		
	
	
	
	private WebDriver driver;
	private DesiredCapabilities DesireCaps;
	private boolean facebookLogin=false;
	
	public TestSelenium(){
		DesireCaps = new DesiredCapabilities();
		DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-1.9.2-macosx/bin/phantomjs");
		driver=new PhantomJSDriver(DesireCaps);
	}
	
	public void quit(){
		driver.quit();
	}
	
	public void loginFacebook(String mail,String pwd) {
		
//	    WebDriver driver=new FirefoxDriver();
	    driver.get("https://www.facebook.com/");
	    driver.findElement(By.id("email")).sendKeys(mail);
	    driver.findElement(By.id("pass")).sendKeys(pwd);
	    driver.findElement(By.id("loginbutton")).click();
	}
	public void loginFacebook() {
		
//	    WebDriver driver=new FirefoxDriver();
	    driver.get("https://www.facebook.com/");
	    driver.findElement(By.id("email")).sendKeys(username);
	    driver.findElement(By.id("pass")).sendKeys(password);
	    driver.findElement(By.id("loginbutton")).click();
	    facebookLogin=true;
	 }
	
	public void logoutFacebook(){
		if(facebookLogin){
//			List<WebElement> logoutbutton = driver.findElements(By.xpath("//div[@class='_5h60 _30f']"));
			driver.findElement(By.id("logout_form")).submit();
			facebookLogin=false;
		}
	}
	
	public void getUserLiked(String user) throws IOException{
		
//		WebDriver driver=new FirefoxDriver();
//		DesiredCapabilities DesireCaps = new DesiredCapabilities();
//		DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-2.0.0-macosx/bin/phantomjs");
//		WebDriver driver=new PhantomJSDriver(DesireCaps);
	    
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element=new WebElement();
//		driver.get("https://www.facebook.com/");
//	    driver.findElement(By.id("email")).sendKeys(username);
//	    driver.findElement(By.id("pass")).sendKeys(password);
//	    driver.findElement(By.id("loginbutton")).click();
		loginFacebook();
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
		String userUrl=currentUrl.substring(0, index);
		String likedUrl = userUrl+"/likes";
		driver.get(likedUrl);
		
		File outFile=new File("userLikes.html");
	    FileWriter fw=new FileWriter(outFile);
	    
//		List<WebElement> likes = driver.findElements(By.xpath("//div[@class='_5h60 _30f']"));
//		for(WebElement like:likes){
//			System.out.println(like.getText());
//		}
	    
		logoutFacebook();
		driver.get(userUrl);

		driver.findElement(By.xpath("//a[@class='infoSeeMore showAll']")).click();
		
		List<WebElement> mediaLikes=driver.findElements(By.xpath("//ul[@class='uiList pbl mediaRow _509- _4ki _6-h _704 _6-i']"));
		for(WebElement mLikes:mediaLikes){
			List<WebElement>meLikes=mLikes.findElements(By.tagName("li"));
			for(WebElement like:meLikes){
				WebElement l=like.findElement(By.tagName("a"));
				String li=l.getAttribute("href");
				fw.write("<a href="+li+">"+l.getText()+"</a><br>");
				System.out.println(l.getText());
				System.out.println(li);
			}
		}
		List<WebElement> allLikes = driver.findElements(By.xpath("//div[@id='u_0_6']/span"));
		for(WebElement alLikes:allLikes){
			List<WebElement> aLikes=alLikes.findElements(By.tagName("a"));
			System.out.println("size : "+aLikes.size());
			for(WebElement like:aLikes){
				String l=like.getAttribute("href");
				fw.write("<a href="+l+">"+like.getText()+"</a><br>");
				System.out.println(like.getText());
				System.out.println(l);
			}
		}
		driver.quit();
		fw.close();
		
	}
	
	public void getAboutUser(String user) throws IOException, InterruptedException{
		
//		WebDriver driver=new FirefoxDriver();
//		DesiredCapabilities DesireCaps = new DesiredCapabilities();
//		DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-2.0.0-macosx/bin/phantomjs");
//		WebDriver driver=new PhantomJSDriver(DesireCaps);

		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element=new WebElement();
//		driver.get("https://www.facebook.com/");
//	    driver.findElement(By.id("email")).sendKeys(username);
//	    driver.findElement(By.id("pass")).sendKeys(password);
//	    driver.findElement(By.id("loginbutton")).click();
		loginFacebook();
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
		
	    File outFile=new File("tmp/out.html");
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
		fw.write("<h3><u>ความสัมพันธ์</u></h3>");
		List<WebElement> relInfo = driver.findElements(By.xpath("//div[@class='_4qm1 editAnchor']"));
		for(WebElement link:relInfo){
			String line=link.getText();
			String[] text=line.split("\n");	
			System.out.println(text.length);

			if(text.length<=1){
				System.out.println("0");
				fw.write("-");
			}
			else if(text.length>2){
				System.out.println("2");
				System.out.println(text[0]);
				System.out.println(text[2]);
				System.out.println(text[1]);
				fw.write(text[2]+"<br>");
				fw.write(text[1]);
			}
			else if(text.length>1){
				System.out.println("1");
				if(text[1].equals("ไม่มีข้อมูลการคบหาให้แสดง")) text[1]="-";
				System.out.println(text[0]);
				System.out.println(text[1]);
				fw.write(text[1]);
			}
			
		}
		fw.write("<br><br>");
		
		driver.get(aboutUrl+"bio");
		fw.write("<h3><u>รายละเอียดอื่นๆ</u></h3>");
//		List<WebElement> otherInfo = driver.findElements(By.xpath("//div[@class='_4qm1']"));
		List<WebElement> aboutHeader = driver.findElements(By.xpath("//div[@class='clearfix _h71']"));
		List<WebElement> aboutInfo1 = driver.findElements(By.xpath("//span[@class='_50f4']"));
		List<WebElement> aboutInfo2 = driver.findElements(By.xpath("//span[@class='_c24 _50f4']"));
		List<WebElement> aboutExp = driver.findElements(By.xpath("//div[@class='fsm fwn fcg']"));
	//	int steve=0;
		Iterator<WebElement> header=aboutHeader.iterator();
		Iterator<WebElement> info=aboutExp.iterator();
		info.next();
		String h=header.next().getText();
		System.out.println(h);
		fw.write("<b>"+h+"</b><br>");
		if(!aboutInfo2.isEmpty()){
			System.out.println(aboutInfo2.get(0).getText());
			fw.write(aboutInfo2.get(0).getText()+"<br>");
		}else{
			fw.write("-<br>");
		}
		if(aboutHeader.size()>2){
			h=header.next().getText();
			System.out.println(h);
			fw.write("<b>"+h+"</b><br>");
			for(WebElement link:aboutInfo1){
				String ss=info.next().getText();
				System.out.println(link.getText());
	//			System.out.println(steve++);
				fw.write(link.getText()+" : "+ss+"<br>");
			}
		}
		h=header.next().getText();
		System.out.println(h);
		fw.write("<b>"+h+"</b><br>");
		System.out.println(aboutInfo2.get(1).getText());
		fw.write(aboutInfo2.get(1).getText()+"<br>");
		fw.write("<br><br>");
/*		
		driver.get(aboutUrl+"year-overviews");
		wait(2000);
		fw.write("<h3><u>เหตุการณ์ในชีวิต</u></h3>");
//		List<WebElement> yearOverview = driver.findElements(By.xpath("//div[@class='_4qm1']"));
		List<WebElement> yearOverview = driver.findElements(By.xpath("//li[@class='_2pi4']"));
//		List<WebElement> year=driver.findElements(By.xpath("//span[@class='_50f8 _50f4']"));
//		Iterator<WebElement> ye=year.iterator(); 
		for(WebElement link:yearOverview){
//			WebElement y;
//			if(ye.next()!=null) y=ye.next();
//			else break;
			System.out.println("1");
			WebElement year=link.findElement(By.xpath("//span[@class='_50f8 _50f4']"));
			System.out.println("2");
			List<WebElement> overview=link.findElements(By.tagName("li"));
			System.out.println(year.getText());
			fw.write("<b>"+year.getText()+"</b><br>");
			for(WebElement w:overview){
				System.out.println(w.getText());
				fw.write(w.getText()+"<br>");
			}
		}*/
		driver.quit();
		fw.close();
		
//		WebElement likes = driver.findElement(By.id("pagelet_timeline_app_collection_1064067421:2409997254:96"));
		
	}
	
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
//    	WebDriver driver = new FirefoxDriver();
        DesiredCapabilities DesireCaps = new DesiredCapabilities();
        DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-1.9.2-macosx/bin/phantomjs");
        WebDriver driver=new PhantomJSDriver(DesireCaps);

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
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();
        TestSelenium t = new TestSelenium();
        t.getAboutUser("ณัฐ อำนวยผลวิวัฒน์");
    }
}

