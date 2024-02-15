package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.staging.happiesthealth.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        //to accept cookies
        driver.findElement(By.xpath("(//a[@class='elementor-button elementor-button-link elementor-size-xs'])[11]")).click();
        Thread.sleep(2000);

        // getText()
        String txt = driver.findElement(By.xpath("(//span[@class=\"wpml-ls-native\"])[1]")).getText();
        System.out.println("Getting Text Present: " + txt);

        //click()
        driver.findElement(By.xpath("(//a[@href=\"https://qa.staging.happiesthealth.com/login?redirectUrl=https%3A%2F%2Fqa.staging.happiesthealth.com%2F\"])[1]")).click();
        Thread.sleep(1000);
        //isSelected() - used to verify radio button checkbox is selected or not
        // boolean p = driver.findElement(By.xpath("(//input[@class=\'PrivateSwitchBase-input css-1m9pwf3\'])[1]")).isSelected();
        boolean checkb = driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected();
        System.out.println("CheckBox Result: " + checkb);
        if (checkb == true) {
            System.out.println("CheckBox is Enabled");
        } else {
            System.out.println("CheckBox is Disabled");
        }
        driver.navigate().back();

        // sendKeys()
        WebElement tx = driver.findElement(By.xpath("//input[@id='elementor-search-form-8a090a2']"));
        tx.sendKeys("Heart"); // to enter value in SearchBox
        tx.clear(); // clear value
        tx.sendKeys("Lungs");
        // to perform enter operation
        tx.sendKeys(Keys.ENTER); // perform Enter operation after entering value in searchBox

        //isEnabled() - verify element is enabled or disabled
        boolean result = driver.findElement(By.xpath("//ul[@id='menu-1-3d3ecd9e']//a[@href=\"https://qa.staging.happiesthealth.com/all-categories\"]")).isEnabled();
        System.out.println("Is Element Enabled: " + result);
        if (result == true) {
            System.out.println("Element is Enabled");
        } else {
            System.out.println("Element is not Enabled");
        }

        //isDisplayed() - used to verify element is present or not
        boolean ans = driver.findElement(By.xpath("//img[@class=\"attachment-large size-large wp-image-9004111222226628\"]")).isDisplayed();
        System.out.println("Element is Displayed: " + ans);
        if (ans == true) {
            System.out.println("Element is Displayed");
        } else {
            System.out.println("Element is Not Displayed");
        }
        driver.close();
    }
}
