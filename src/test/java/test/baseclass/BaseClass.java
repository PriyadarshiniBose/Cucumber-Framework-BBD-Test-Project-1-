package test.baseclass;
import java.time.Duration;

import javax.swing.text.Document;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.cucumberexpressions.Argument;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	private static final String JavascriptExecutor = null;
	public static WebDriver driver;
	
	public static void lanchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void url(String url) {
		driver.get(url);
		
	}
	public static void fillTheTextBox(WebElement element ,String text) {
		element.sendKeys(text);
	}
	public static void buttonClick(WebElement element) {
		element.click();
	}
	
	 public static void selectDropDown( WebElement e1,String selectByValue) {
		Select select = new Select(e1);
		 select.selectByValue(selectByValue);
	}
     public static void selectDropDown(WebElement e1, int selectByIndex) {
    	 Select select = new Select(e1);
		 select.selectByIndex(selectByIndex);
	}
     public static void selectDropDown( String selectByVisibleText, WebElement e1) {
    	 Select select = new Select(e1);
		 select.selectByVisibleText(selectByVisibleText);
	}
     public static void waiting(int sec) {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
     }
     public static void utilWait(WebElement e1, int sec) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	 wait.until(ExpectedConditions.elementToBeClickable(e1)).click();
     }
     public static void scrollByElement(WebElement e1) {   	 
    	 JavascriptExecutor jse = (JavascriptExecutor)driver;
    	 jse.executeScript("arguments[0].scrollIntoView();", e1);
    	 
     }


}