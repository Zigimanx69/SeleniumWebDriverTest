package TestoviNovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxes {
    private WebDriver driver;



    @Test(priority = 1)
    public void chekcBox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://link.edgepilot.com/s/12227a84/DmLjQJRwu0ilPD33ZRk1pA?u=https://the-internet.herokuapp.com/checkboxes");
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//form[@id ='checkboxes']/input")));

        WebElement checkbox = driver.findElement(By.xpath("//form[@id ='checkboxes']/input[1]"));
        System.out.println("The checkbox is selection state is - " + checkbox.isSelected());

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id ='checkboxes']/input[2]"));
        System.out.println("The checkbox is selection state is - " + checkbox1.isSelected());


         driver.quit();

    }

    @Test(priority = 2)
    public void checkBoxFirst(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://link.edgepilot.com/s/12227a84/DmLjQJRwu0ilPD33ZRk1pA?u=https://the-internet.herokuapp.com/checkboxes");
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//form[@id ='checkboxes']/input")));

        WebElement checkbox = driver.findElement(By.xpath("//form[@id ='checkboxes']/input[1]"));
        if(!checkbox.isSelected())
            checkbox.click();
        System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
        driver.quit();
    }

    @Test(priority = 3)
    public void checkBoxUncheckd(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://link.edgepilot.com/s/12227a84/DmLjQJRwu0ilPD33ZRk1pA?u=https://the-internet.herokuapp.com/checkboxes");
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//form[@id ='checkboxes']/input")));
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id ='checkboxes']/input[2]"));
        if(checkbox1.isSelected())
            checkbox1.click();
        System.out.println("The checkbox is selection state is - " + checkbox1.isSelected());
        driver.quit();

    }
}
