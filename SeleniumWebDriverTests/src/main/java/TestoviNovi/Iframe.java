package TestoviNovi;

import NoviTest.BasicTest;
import io.netty.handler.ssl.util.KeyManagerFactoryWrapper;
import net.bytebuddy.asm.Advice;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Iframe extends BasicTest {


    @Test(priority = 1)
    public void openFileMeni() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.findElement(By.xpath("//button[contains(@class,'tox-mbtn')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'tox-menu-nav__js')]")).click();
        WebElement frame1 = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame1);
        WebElement frame1Element = driver.findElement(By.id("tinymce"));
        Thread.sleep(2000);
        String frame1Text = frame1Element.getAttribute("text");
        if (frame1Text.isEmpty()) {
            System.out.println("Text filed is empty");
        } else {
            System.out.println("Text field have some text");
        }
    }

    @Test (priority = 2)
    public void checkIframeInput() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frame1 = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("iFrameTest");
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
         driver.findElement(By.xpath("//span[contains(text(),'Format')]")).click();
         driver.findElement(By.xpath("//div[contains(text(),'Formats')]")).click();
         driver.findElement(By.xpath("//div[contains(text(),'Headings')]")).click();
         driver.findElement(By.xpath("//h3[contains(text(),'Heading 3')]")).click();
        Thread.sleep(2000);
        String actualTitle = driver.findElement(By.xpath("//*[contains(@class,'tox-statusbar__path')]")).getText();
        String expectedTitle = "H3";
        Assert.assertEquals(actualTitle, expectedTitle, "Value don't have text H3");
    }
    @Test(priority = 3)
    public void changeTextStyle() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frame1 = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("tinymce")).sendKeys("Paragraph text");
        WebElement tekst =  driver.findElement(By.id("tinymce"));
        tekst.sendKeys(Keys.CONTROL , Keys.SHIFT , Keys.ARROW_LEFT);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//span[contains(text(),'Format')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Bold')]")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//*[contains(@class,'tox-statusbar__path')]")).getText();
        System.out.println(actualText);
        if(actualText.contains("P\n»\nSTRONG")){
            System.out.println("Text is contain P » STRONG");
        }else{
            System.out.println("Text is not containing text that expected");
        }
        driver.quit();
    }
    @Test(priority = 4)
    public void selectAllText() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frame1 = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame1);
        WebElement tekst =  driver.findElement(By.id("tinymce"));
        tekst.sendKeys(Keys.CONTROL + "a");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//span[contains(text(),'Format')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Align')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Center')]")).click();
        driver.switchTo().frame(frame1);
        String stil =  driver.findElement(By.xpath("//body/p[1]")).getAttribute("style");
        if(stil.equals("text-align: center;")){
            System.out.println("Text is align");
        }else{
            System.out.println("Text is not in center");
        }
        driver.switchTo().defaultContent();
        driver.quit();
    }
    @Test(priority = 5)
    public void checkTextRed(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frame1 = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame1);
        WebElement tekst =  driver.findElement(By.id("tinymce"));
        tekst.sendKeys(Keys.CONTROL + "a");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//span[contains(text(),'Format')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Text color')]")).click();
        driver.findElement(By.xpath("//div[@title='Red']")).click();
        driver.switchTo().frame(frame1);
        String color =  driver.findElement(By.xpath("//span[contains(text(),'Your content goes here.')]")).getAttribute("data-mce-style");
        if(color.equals("color: #e03e2d;")){
            System.out.println("Text is red color");
        }else{
            System.out.println("Text is not red");
        }
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
