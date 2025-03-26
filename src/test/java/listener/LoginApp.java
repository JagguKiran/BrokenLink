package listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginApp {
	@Test
	public void login() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		try{Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
		driver.get("https://www.google.com");
		try{Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
		driver.quit();
	}
}
