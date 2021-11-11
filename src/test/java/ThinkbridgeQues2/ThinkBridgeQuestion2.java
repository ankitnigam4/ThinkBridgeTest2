package ThinkbridgeQues2;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThinkBridgeQuestion2 {

	@SuppressWarnings("deprecation")
	@Test
	public void BrowserLaunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jt-dev.azurewebsites.net/#/SignUp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//*[@id=\"language\"]/div[1]/span")).click();
		driver.findElement(By.id("language")).click();
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='ng-binding ng-scope']"));
		System.out.println("The total Languages are" + values.size());
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i).getText());
		}

		driver.findElement(By.xpath("//div[contains(text(),'English')]")).click();
		driver.findElement(By.id("name")).sendKeys("Ankit Nigam");
		driver.findElement(By.name("orgName")).sendKeys("IBM");
		driver.findElement(By.name("email")).sendKeys("anktest6788@gmail.com");
		driver.findElement(By.xpath("//span[@class='black-color ng-binding']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		//driver.close();

		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys("anktest6789@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		driver.findElement(By.name("password")).sendKeys("Ank7890$");
		WebDriverWait wait = new WebDriverWait(driver, 5, 1); // WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]"))).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

	}

}
