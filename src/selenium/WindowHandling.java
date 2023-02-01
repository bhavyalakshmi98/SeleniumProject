package test;

 

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

 

public class WindowHandling {
    public final String s1 = new String();
    public final String s2 = new String();

 

    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        //WebElement clkBut = driver.findElement(By.xpath("//button[contains(@id,'windowButton')]"));
//        WebElement clkBut = driver.findElement(By.xpath("//button[starts-with(@id,'wind')]"));
        
//        WebElement clkBut = driver.findElement(By.xpath("//button[text()=\"New Window\"]"));
        
//          WebElement clkBut = driver.findElement(By.xpath("//*[text()=\"New Window\"]"));
        
//        WebElement clkBut = driver.findElement(By.xpath("//*[@id='windowButton' and @type = 'button']"));
        
        WebElement clkBut = driver.findElement(By.xpath("//*[@id='windowButton' or @type = 'button']"));
          
        

 

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", clkBut);
        //<button id="windowButton" type="button" class="mt-4 btn btn-primary">New Window</button>


        clkBut = driver.findElement(By.id("messageWindowButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", clkBut);
        //<button id="messageWindowButton" type="button" class="btn btn-primary">New Window Message</button>

        String main_window = driver.getWindowHandle();
        System.out.println("Main window handle: " + main_window);

        Set <String> window_handles = driver.getWindowHandles();

        Iterator value = window_handles.iterator();
        String child_window = new String();

 

        while(value.hasNext())
        {
            child_window = (String) value.next();

            if(!main_window.equalsIgnoreCase(child_window))
            {

                driver.switchTo().window(child_window);

                System.out.println("Child window handle is: "+ child_window);
                Thread.sleep(5000);
                driver.close();
                System.out.println(child_window + " closed");

            }

        }

 


        driver.switchTo().window(main_window);
        driver.quit();

 



    }

 

}