package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class selectClassDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement lb = driver.findElement(By.xpath("(//select[@class='col-lg-3'])[2]"));
        lb.click();
        Select s = new Select(lb);
        //s.selectByValue("avatar");
        s.selectByVisibleText("Big Baby Cat");
        List<WebElement> opt = s.getAllSelectedOptions(); // if multiple select possible, get all selected options
        System.out.println(opt.size());
        driver.close();
    }
}