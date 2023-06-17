package com.dealsdray.testscript;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class FunctionalTesting {

	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver=new ChromeDriver();

		driver.get("https://demo.dealsdray.com/");

		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");

		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");

		driver.findElement(By.xpath("//button[@type=\'submit']")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[text()='chevron_right']")).click();

		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement (By. xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/div[2]/button")).click();
		File f=new File("./data/demo-data.xlsx");
		String input = f.getAbsolutePath();

		driver.findElement(By.xpath("//input[@type='file']")).sendKeys (input);

		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[3]/button")).click();
    	driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
    	WebDriverWait wait=new WebDriverWait(driver, 6000);
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	TakesScreenshot s=(TakesScreenshot) driver;
    	File a=s.getScreenshotAs(OutputType.FILE);
    	Files.copy(a, new File("./screenshot/ss.png"));
    	driver.close();
    	
    	

}
}
