package TestoviNovi;

import NoviTest.BasicTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.*;

public class FileDownloadAndValidationFile extends BasicTest {
    @Test(priority = 1)
    public void pickFile() throws InterruptedException, IOException {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'text.txt')]")).click();
        Thread.sleep(3000);
        File file= new File("C:\\Users\\zigim\\Downloads\\text.txt");
        if(file.exists()){
            System.out.println("File is in directory");
        }else{
            System.out.println("File is not in directory");
        }
        try {
            File file1 = new File("C:\\Users\\zigim\\Downloads\\text.txt");
            FileReader fr = new FileReader(file1);
            char[] data = new char[(int) file1.length()];
            fr.read(data);
            System.out.println(data);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 2)
    public void deleteFile(){
        File file1 = new File("C:\\Users\\zigim\\Downloads\\text.txt");
        file1.delete();
    }
}
