package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Tester {

    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new HtmlUnitDriver();
        //WebDriver driver = new FirefoxDriver();
        final String URL = "http://localhost:4567";
        driver.get(URL);
        
        System.out.println(driver.getPageSource());
        //sleep(2);
        
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        //System.out.println(driver.getPageSource());
//        sleep(2);
        
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));

//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("login"));

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        System.out.println(driver.getPageSource());
        //sleep(2);
        Random r = new Random();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("otra");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("otra");
        element = driver.findElement(By.name("signup"));
        
        System.out.println(driver.getPageSource());
        //sleep(2);
        element.submit();

        System.out.println(driver.getPageSource());
        //sleep(2);
        
        WebElement element2 = driver.findElement(By.linkText("continue to application mainpage"));
        element2.click();
        System.out.println(driver.getPageSource());
        //sleep(2);
        
        WebElement element3 = driver.findElement(By.linkText("logout"));
        element3.click();
        System.out.println(driver.getPageSource());
        //sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
