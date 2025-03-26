package crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	@Test
	@Parameters({"browser"})
	public void crossBrowser(String br) {
		WebDriver driver;
		br=br.trim().toLowerCase();
		switch(br) {
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:driver=new ChromeDriver();break;
		}
		driver.manage().window().maximize();
		try{Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
		driver.get("https://www.google.com");
		try{Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
		driver.quit();
		
	}
}
