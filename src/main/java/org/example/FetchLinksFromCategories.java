package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class FetchLinksFromCategories {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.staging.happiesthealth.com/");
        //driver.get(("https://www.happiesthealth.com/"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[text()='Accept']")).click();
        Actions ac = new Actions(driver);
        WebElement cat = driver.findElement(By.xpath("//ul[@id=\"menu-1-3d3ecd9e\"]//a[@href='https://qa.staging.happiesthealth.com/all-categories']"));
        ac.moveToElement(cat).build().perform();
        List<WebElement> links = driver.findElements(By.xpath("//li[@class='cat-item cat-item-2 active_cls exp_cat_li']/a"));
        System.out.println("Total links on CATEGORIES :" + links.size());
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }
        driver.close();
    }
}
