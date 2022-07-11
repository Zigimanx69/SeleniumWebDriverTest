package TestoviNovi;

import NoviTest.BasicTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Before;

public class LoginAute extends BasicTest {

    @Test(priority = 1)
  public void succcsesfulLogin(){
        driver.navigate().to(baseUrl);
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("fa-sign-in")).click();
        String provera = driver.findElement(By.xpath("//div[contains(text(),'You logged into a secure area!')]")).getText();
        String expectedHeading = "You logged into a secure area!\n×";
        Assert.assertEquals(provera,expectedHeading,"Poruka ne sadrzi tekst koji je u opisu");

    }

    @Test (priority = 2)
    public void logOut(){
        driver.navigate().to(baseUrl);
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("fa-sign-in")).click();
        driver.findElement(By.xpath("//*[contains(@class,'icon-signout')]")).click();
        String provera = driver.findElement(By.xpath("//div[contains(text(),'You logged out of the secure area!')]")).getText();
        String expectedHeading = "You logged out of the secure area!\n×";
        Assert.assertEquals(provera,expectedHeading,"Poruka ne sadrzi tekst koji je u opisu");
    }

    @Test(priority = 3)
    public void wrongLogin(){
        driver.navigate().to(baseUrl);
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("fa-sign-in")).click();
        String provera = driver.findElement(By.xpath("//div[contains(text(),'Your username is invalid!')]")).getText();
        String expectedHeading = "Your username is invalid!\n×";
        Assert.assertEquals(provera,expectedHeading,"Poruka ne sadrzi tekst koji je u opisu");
    }
}
