package concurrent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThirdTest {
	private static ThreadLocal<WebDriver> drivers=new ThreadLocal<WebDriver>();
	@Test
	public void crossBrowserThird() {
		setDriver();
		getDriver().manage().window().maximize();
		try {Thread.sleep(4000);}catch(Exception e) {e.printStackTrace();}
		getDriver().get("https://www.google.com/");
		try {Thread.sleep(4000);}catch(Exception e) {e.printStackTrace();}
		getDriver().quit();
		removeDriver();
	}
	public static void setDriver() {
		WebDriverManager.chromedriver().setup();
		drivers.set(new ChromeDriver());
	}
	public static WebDriver getDriver() {
		return drivers.get();
	}
	public static void removeDriver() {
		drivers.remove();
	}
}
