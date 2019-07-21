package org.loc;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Call {
	static WebDriver wq;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TK\\Downloads\\Eclipse oxygen2\\eclipse-committers-oxygen-2-win32-x86_64\\Programs\\Sat\\driver\\chromedriver.exe");
		wq = new ChromeDriver();
		wq.get("http://demo.automationtesting.in/Register.html");
	}

	@Test
	public void test1() throws AWTException {
		Assert.assertTrue("Verify URL", wq.getCurrentUrl().contains("automationtesting"));
		Assert.assertTrue("Verify Title", wq.getTitle().contains("Register"));
		WebElement firstName = wq.findElement(By.xpath("(//input[@type='text'])[1]"));
		firstName.sendKeys("Mathi");
		Assert.assertEquals("Verify FirstName", "Mathi", firstName.getAttribute("value"));

		WebElement lastName = wq.findElement(By.xpath("(//input[@type='text'])[2]"));
		lastName.sendKeys("T");
		Assert.assertEquals("Verify LastName", "T", lastName.getAttribute("value"));

		WebElement address = wq.findElement(By.xpath("//textarea[@rows='3']"));
		address.sendKeys("89/3,sivanagar, Salem");
		Assert.assertEquals("Verify Address", "89/3,sivanagar, Salem", address.getAttribute("value"));

		WebElement mail = wq.findElement(By.xpath("//input[@type='email']"));
		mail.sendKeys("mathi@gmail.com");
		Assert.assertEquals("Verify Mail", "mathi@gmail.com", mail.getAttribute("value"));

		WebElement mobNo = wq.findElement(By.xpath("//input[@type='tel']"));
		mobNo.sendKeys("9952221903");
		Assert.assertEquals("Verify MobNo", "9952221903", mobNo.getAttribute("value"));

		WebElement gender = wq.findElement(By.xpath("(//input[@type='radio'])[1]"));
		gender.click();
		Assert.assertEquals("Verify Gender", "Male", gender.getAttribute("value"));

		WebElement hobbie = wq.findElement(By.xpath("//input[@id='checkbox1']"));
		hobbie.click();
		Assert.assertEquals("Verify hobbie", "Cricket", hobbie.getAttribute("value"));

		WebElement skill = wq.findElement(By.xpath("//select[@id='Skills']"));
		Select sd = new Select(skill);
		sd.selectByIndex(2);
		Assert.assertEquals("Verify skill", "Adobe Photoshop", skill.getAttribute("value"));

		WebElement country = wq.findElement(By.xpath("//select[@id='countries']"));
		Select s1 = new Select(country);
		s1.selectByValue("India");
		Assert.assertEquals("Verify country", "India", country.getAttribute("value"));

		WebElement seCountry = wq.findElement(By.xpath("//span[@role='combobox']"));
		seCountry.click();
		WebElement search = wq.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("India");
		search.click();
		// Assert.assertEquals("Verify
		// seCountry","India",seCountry.getAttribute("value"));

		WebElement year = wq.findElement(By.xpath("//select[@id='yearbox']"));
		Select s3 = new Select(year);
		s3.selectByValue("1996");
		Assert.assertEquals("Verify year", "1996", year.getAttribute("value"));

		WebElement month = wq.findElement(By.xpath("//select[@placeholder='Month']"));
		Select s4 = new Select(month);
		s4.selectByValue("November");
		Assert.assertEquals("Verify month", "November", month.getAttribute("value"));

		WebElement day = wq.findElement(By.xpath("//select[@id='daybox']"));
		Select s5 = new Select(day);
		s5.selectByValue("3");
		Assert.assertEquals("Verify day", "3", day.getAttribute("value"));

		WebElement password = wq.findElement(By.xpath("//input[@id='firstpassword']"));
		password.sendKeys("mathi1234567");
		Assert.assertEquals("Verify password", "mathi1234567", password.getAttribute("value"));

		WebElement cnfmPassword = wq.findElement(By.xpath("//input[@id='secondpassword']"));
		cnfmPassword.sendKeys("mathi1234567");
		Assert.assertEquals("Verify cnfmPassword", "mathi1234567", cnfmPassword.getAttribute("value"));

		WebElement submit = wq.findElement(By.xpath("//input[@id='secondpassword']"));
		submit.click();
		// Assert.assertEquals("Verify
		// submit","mathi1234567",submit.getAttribute("value"));

	}

	@Before
	public void beforeMethod() {
	}

	@After
	public void afterMethod() {
	}
}
