package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class FetchLinksFromVideos {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.staging.happiesthealth.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[text()='Accept']")).click();
        Actions act = new Actions(driver);
        System.out.println("------------------ All Links Under Videos ----------------------");
        WebElement video = driver.findElement(By.xpath("//ul[@id=\"menu-1-3d3ecd9e\"]/descendant::a[@href=\"https://qa.staging.happiesthealth.com/videos/\"]"));
        act.moveToElement(video).build().perform();
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class=\"main_cmenu menu_videos\"]/li/a"));
        System.out.println("Total links on VIDEOS :" + links.size());
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }

        System.out.println("------------------ Video Links for Individual Items from DropDown - Under Recent ----------------------");
        List<WebElement> intVideolinks = driver.findElements(By.xpath("//div[@class=\"menu_recent\"]//span[@class=\"post_name\"]/a"));
        System.out.println("Total Link Size - Video - :" + intVideolinks.size());
        for (WebElement intVideoLink : intVideolinks) {
            System.out.println(intVideoLink.getAttribute("href"));
        }

        System.out.println("------------------ Video Links for Individual Items from DropDown - Under Featured ----------------------");
        List<WebElement> intVideolinksFeatured = driver.findElements(By.xpath("//div[@class=\"menu_featured\"]//span[@class=\"post_name\"]/a"));
        System.out.println("Total Link Size - Video - :" + intVideolinksFeatured.size());
        for (WebElement intVideoLinkFeat : intVideolinksFeatured) {
            System.out.println(intVideoLinkFeat.getAttribute("href"));
        }
        driver.close();
    }
}