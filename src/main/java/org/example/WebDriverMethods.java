//WebDriver and Methods
package org.example;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.staging.happiesthealth.com/"); //enter url in browser
        Dimension a = driver.manage().window().getSize();
        System.out.println("Size of Browser" + a); // to get size of browser
        driver.manage().window().maximize(); //use to maximize browser
        driver.navigate().to("https://qa.staging.happiesthealth.com/health-champions/en/health-champions/videos");
        driver.navigate().back(); // navigate back
        driver.navigate().refresh(); // refresh browser
        String url = driver.getCurrentUrl(); //get current url
        System.out.println("Current URL: " + url);
        String title = driver.getTitle();
        System.out.println("Title of WebPage: " + title); // get title of a webpage
        String actualTitle = "Home Redesign v4 - Happiest Health";
        if (actualTitle.equals(title)) {
            System.out.println("Actual and Expected Title Matched");
        } else {
            System.out.println("Actual and Expected Title Not Matched");
        }
        driver.get("https://qa.staging.happiesthealth.com/editors-pick-2/");
        Dimension d = new Dimension(600, 300); // to set size of browser
        driver.manage().window().setSize(d);
        Thread.sleep(2000);
        Point o = new Point(500, 400); // to set position of browser
        driver.manage().window().setPosition(o);
        System.out.println("Position of Browser is : " + driver.manage().window().getPosition());
        driver.quit(); //close all tabs present in browser
        // driver.close(); //close current browser
    }
}