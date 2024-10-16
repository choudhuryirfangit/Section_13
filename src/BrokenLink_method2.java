import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import dev.failsafe.internal.util.Assert;

public class BrokenLink_method2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a=new SoftAssert();
		
		List<WebElement> links=driver.findElements(By.cssSelector(".gf-li a"));
		
		for(WebElement link:links) {
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode=conn.getResponseCode();
			System.out.println(resCode);
			a.assertTrue(resCode<400, "The Link with text "+link.getText()+"is broken with "+resCode);
			
//			
//			if(resCode>400) {
//				System.out.println("The Link with text "+link.getText()+" "+resCode);
//				Assert.assertTrue(false);
//			}
//			
		}
		a.assertAll();

	}

}
