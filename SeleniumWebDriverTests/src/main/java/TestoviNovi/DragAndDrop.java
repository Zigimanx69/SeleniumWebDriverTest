package TestoviNovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DragAndDrop {
    private WebDriver driver;

    @Test(priority = 1)
    public void dragAndDrop() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);


        WebElement fromElement =driver.findElement(By.cssSelector("#column-a"));
        WebElement toElement = driver.findElement(By.cssSelector("#column-b"));
        Actions builder = new Actions(driver);
         builder.dragAndDrop(fromElement, toElement).perform();

           driver.quit();
    }
}
