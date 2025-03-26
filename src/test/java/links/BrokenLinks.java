package links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BrokenLinks {
	@Test
	public void testBrokenLinks() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("file:///D:/BrokenLink.html");
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		int countSuccess=0,countBroken=0;
		String value="";
		for(WebElement element:elements) {
			try {
				value=element.getAttribute("href");
				URL url=new URL(value);
				HttpURLConnection connection =(HttpURLConnection)url.openConnection();
				connection.setConnectTimeout(3000);
				connection.connect();
				if(connection.getResponseCode()>=200&&connection.getResponseCode()<300) {
					System.out.println(value+" is valid URL");
					countSuccess++;
				}else {
					System.out.println(value+" is invalid URL");
					countBroken++;
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println(value+" is invalid URL");
				countBroken++;
			}
		}
		System.out.println("Total Url "+elements.size());
		System.out.println("Successful "+countSuccess);
		System.out.println("Broken "+countBroken);
		System.out.println("kiran");
		driver.close();
	}
}
