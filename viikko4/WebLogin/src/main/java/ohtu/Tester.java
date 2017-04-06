package ohtu;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
        element.sendKeys("make");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("esko");
        element = driver.findElement(By.name("password"));
        element.sendKeys("seko");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        sleep(3);
        
        driver.findElement(By.linkText("back to home")).click();
        
        sleep(3);
        
        driver.findElement(By.linkText("register new user")).click();
        
        sleep(3);
        
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("esko");
        element = driver.findElement(By.name("password"));
        element.sendKeys("seko");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("seko");
        
        sleep(2);
        driver.findElement(By.name("signup")).click();
        
        sleep(2);
        
        driver.findElement(By.partialLinkText("continue to application mainpage")).click();
        
        sleep(2);
        
        driver.findElement(By.partialLinkText("logout")).click();
      
        sleep(2);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
