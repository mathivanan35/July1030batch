package org.loc;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Date {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TK\\Downloads\\Eclipse oxygen2\\eclipse-committers-oxygen-2-win32-x86_64\\Programs\\Snapdeal\\driver\\chromedriver.exe");

		WebDriver wq = new ChromeDriver();
		wq.get("https://www.snapdeal.com/");
		wq.manage().window().maximize();
		WebElement mobile = wq.findElement(By.xpath("//span[text()='Mobile & Tablets']"));
		Actions acc = new Actions(wq);
		acc.moveToElement(mobile).perform();;
		WebElement item1 = wq.findElement(By.xpath("(//span[text()='Samsung'])[2]"));
		item1.click();
		Thread.sleep(3000);
		WebElement item = wq.findElement(By.xpath("//p[@class='product-title ']"));
		item.click();
		String par = wq.getWindowHandle();
		Set<String>All=wq.getWindowHandles();
		for (String x : All) {
			if(!x.equals(par)) {
				wq.switchTo().window(x);
			}
		}
		WebElement addCart = wq.findElement(By.xpath("//span[text()='add to cart']"));
		addCart.click();
	}

}
