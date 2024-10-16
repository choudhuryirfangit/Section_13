import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//		
//		HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		int resCode=conn.getResponseCode();
//		System.out.println(resCode);
		
		WebElement footer=driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		List<WebElement> tags= footer.findElements(By.tagName("a"));
		for(int i=0;i<tags.size();i++) {
			String link=tags.get(i).getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(link).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode=conn.getResponseCode();
			System.out.println(resCode);
			if(resCode>400) {
				System.out.println("The Link with text "+tags.get(i).getText()+" "+resCode);
			}
			
		}
		
		
		

	}

}
