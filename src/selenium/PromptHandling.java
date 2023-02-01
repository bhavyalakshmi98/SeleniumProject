package selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromptHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://demoqa.com/alerts");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alertButton")).click();
		Alert promtAlert1 = driver.switchTo().alert();
		System.out.println(promtAlert1.getText());
		promtAlert1.accept();
		
		
		WebElement promtAlert2 = driver.findElement(By.id("timerAlertButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", promtAlert2);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
//		Alert promtAlert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.accept();
		

		WebElement Alert3 = driver.findElement(By.id("confirmButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", Alert3);
		Alert promtAlert3 = driver.switchTo().alert();
		System.out.println(promtAlert3.getText());
		promtAlert3.accept();
		
		
		//click on button
		WebElement prompt1 = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", prompt1);
		//switch to alert
		Alert promtAlert = driver.switchTo().alert();
		System.out.println(promtAlert.getText());
		promtAlert.sendKeys("Don");
		promtAlert.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		driver.quit();

	}

}

