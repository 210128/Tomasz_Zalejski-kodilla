package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllegroTestingApp {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.allegro.pl/");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       WebElement cancelButton = driver.findElement(By.xpath("//*[@data-box-name=\"allegro.rodoConsentModal\"]/div/div/div/button"));
        cancelButton.click();

        WebElement filtersSelectedCombo = driver.findElement(By.xpath("//*[@class=\"_r65gb _1fwkl\"]/select"));
        Select categorySelect = new Select(filtersSelectedCombo);
        categorySelect.selectByIndex(3);

        WebElement inputField = driver.findElement(By.xpath("//*[@data-box-name=\"allegro.metrumHeader.search\"]/div/form/input"));
        inputField.sendKeys("Mavic mini");
        inputField.submit();
    }
}
