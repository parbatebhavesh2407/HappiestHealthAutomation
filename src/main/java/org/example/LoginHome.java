package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class LoginHome {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.staging.happiesthealth.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        //to accept cookies
        driver.findElement(By.xpath("//span[text()='Accept']")).click();

        //Click on "View All" - Web Stories and After Navigating Click on Home Again
        driver.findElement(RelativeLocator.with(By.xpath("//a[@href='/webstory-testing']")).toRightOf(By.xpath("//*[normalize-space(text())='Web Stories']"))).click();
        driver.findElement(RelativeLocator.with(By.xpath("//a[@href='https://qa.staging.happiesthealth.com']")).toLeftOf(By.xpath("//h1[contains(text(),'Webstories')]"))).click();

        //Click on "View All" - Podcasts and After Navigating Click on Home Again
        driver.findElement(RelativeLocator.with(By.xpath("//a[@href='/podcasts']")).toRightOf(By.xpath("//*[normalize-space(text())='PODCASTS']"))).click();
        driver.findElement(RelativeLocator.with(By.xpath("//a[@href='https://qa.staging.happiesthealth.com']")).toLeftOf(By.xpath("//h1[contains(text(),'Podcasts')]"))).click();

        //Click on "View All" - Trending and After Navigating Click on Home Again
        driver.findElement(RelativeLocator.with(By.xpath("//a[@href='/trending']")).toRightOf(By.xpath("//*[normalize-space(text())='Trending']"))).click();
        Thread.sleep(1000);
        driver.findElement(RelativeLocator.with(By.xpath("//a[@href='https://qa.staging.happiesthealth.com']")).toLeftOf(By.xpath("//h1[contains(text(),'Trending')]"))).click();

        //Click on "View All" - Doc Tales and After Navigating Click on Home Again
        driver.findElement(By.xpath("(//a[@href='/discussions'])[1]")).click();
        driver.findElement(By.xpath("(//span[text()='Home'])[2]")).click();

        //Click on "View All" - Health Champion and After Navigating Click on Home Again
        driver.findElement(By.xpath("(//a[@href='/health-champions/en/health-champions/videos'])[1]")).click();
        driver.findElement(By.xpath("//*[normalize-space(text())='Home']")).click();

        driver.close();
    }
}
