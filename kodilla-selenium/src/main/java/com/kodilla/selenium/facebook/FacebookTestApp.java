package com.kodilla.selenium.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestApp {
    /*TODO: It is better to run such tests with JUnit, so that statistics will be displayed - numnber of tests passed and failed*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        WebElement yearCombo = driver.findElement(By.xpath("//*[@id=\"birthday_wrapper\"]/div/span/span/select[3]"));
        Select yearSelect = new Select(yearCombo);
        yearSelect.selectByIndex(5);

        /*  TODO: It's better to select items by value. When run next year, selectByIndex will pick a different date*/
        yearSelect.selectByValue("2011");

        //driver.close();
    }
}
