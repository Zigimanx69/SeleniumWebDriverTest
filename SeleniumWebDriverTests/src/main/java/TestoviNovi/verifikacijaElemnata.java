package TestoviNovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifikacijaElemnata {

    private WebDriver driver;

    @Test(priority = 1)
    public void verifikacija(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        String text = driver.findElement(By.xpath("//div[contains(@class,'large-10')]/table/tbody/tr[7]/td[1]")).getText();
        Assert.assertEquals(text,"Iuvaret6","Text do not contain message that need to be");
        String text1 = driver.findElement(By.xpath("//div[contains(@class,'large-10')]/table/tbody/tr[7]/td[2]")).getText();
        Assert.assertEquals(text1,"Apeirian6","Text do not contain message that need to be");
        String text2 = driver.findElement(By.xpath("//div[contains(@class,'large-10')]/table/tbody/tr[7]/td[3]")).getText();
        Assert.assertEquals(text2,"Adipisci6","Text do not contain message that need to be");
        String text3 = driver.findElement(By.xpath("//div[contains(@class,'large-10')]/table/tbody/tr[7]/td[4]")).getText();
        Assert.assertEquals(text3,"Definiebas6","Text do not contain message that need to be");
        String text4 = driver.findElement(By.xpath("//div[contains(@class,'large-10')]/table/tbody/tr[7]/td[5]")).getText();
        Assert.assertEquals(text4,"Consequuntur6","Text do not contain message that need to be");
        String text5 = driver.findElement(By.xpath("//div[contains(@class,'large-10')]/table/tbody/tr[7]/td[6]")).getText();
        Assert.assertEquals(text5,"Phaedrum6","Text do not contain message that need to be");

        driver.quit();
    }
}
