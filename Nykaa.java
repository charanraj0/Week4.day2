package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.nykaa.com/");
		Thread.sleep(15000);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions a = new Actions(driver);
		a.moveToElement(brands).perform();
		Thread.sleep(2000);
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal");
		Thread.sleep(2000);
		driver.getTitle();
		driver.findElement(By.xpath("//*[@id=\"scroller-container\"]/div[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("sort-name")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("css-11gn9r6")).click();
		//Switching to other windows
		Set<String> allwindows = driver.getWindowHandles();
		List<String> allhandles= new ArrayList<String>(allwindows);
		driver.switchTo().window(allhandles.get(1));
		WebElement sizeDropdown = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dropDown = new Select(sizeDropdown);
		dropDown.selectByIndex(2);
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		System.out.println("Price of the shampoo :"+price);
		driver.findElement(By.className("btn-text")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("cart-count")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("Total Price of the shampoo :"+grandTotal);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
	}

}
