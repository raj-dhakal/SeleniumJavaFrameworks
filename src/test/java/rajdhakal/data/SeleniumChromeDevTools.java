package rajdhakal.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.emulation.Emulation;

public class SeleniumChromeDevTools {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\userisraj\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
	//this selenium wrapper method to invoke CDP methods to invoke devtools element
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), 
		Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https:rahulshettyacademy.com/angularAppdemo/");
		
		
	
		
		
		
		
		
	}

}//end class

class ChromeDevTools{
	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\userisraj\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//drirect execute CDP methods incase selenium do not have wrapper methods
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("width", 600);
		map.put("height", 1000);
		map.put("deviceScaleFactor", 50);
		map.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);		
		driver.get("https:rahulshettyacademy.com/angularAppdemo/");
		
	 }
	
	
	
}

class GeoLocation{
	
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "D:\\userisraj\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	DevTools devTools = driver.getDevTools();
	devTools.createSession();
	
	Map<String, Object> map1 = new HashMap<String, Object>();
	map1.put("latitude", 40);
	map1.put("longitude", 3);
	map1.put("accuracy", 1);
	
	driver.executeCdpCommand("Emulation.setGeolocationOverride", map1);
	driver.get("https://www.google.com/");
	driver.findElement(By.name("q")).sendKeys("Netflex", Keys.ENTER);
	driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
	System.out.println(driver.getTitle());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
