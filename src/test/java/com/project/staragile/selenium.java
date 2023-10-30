package com.project.staragile;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class selenium {
	@SuppressWarnings({ "deprecation" })
	public static void main(final String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		//chromeOptions.addArguments(new String[] { "--headless" });
		//chromeOptions.addArguments(new String[] { "--no-sandbox" });
		//chromeOptions.addArguments(new String[] { "--disable-dev-shm-usage" });
		final WebDriver driver = (WebDriver) new ChromeDriver(chromeOptions);
		driver.get("http://34.235.126.141:31111/contact.html");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[placeholder='Your Name']")).sendKeys("Numbrith");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234567899");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Numbrith@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Message']")).sendKeys(new CharSequence[] { "Welcome to the DevOps doubt session" });
		driver.findElement(By.id("sendButton")).click();
		final String message = driver.findElement(By.id("response")).getText();
		if (message.equals("Email sent")) {
			System.out.println("Script executed Successfully");
		} else {
			System.out.println("Script failed");
		}
		//Thread.sleep(3000L);
		//driver.quit();
		}
}
