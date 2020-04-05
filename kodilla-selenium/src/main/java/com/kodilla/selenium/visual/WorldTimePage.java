package com.kodilla.selenium.visual;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;
@Snap("WorldTime.png")
public class WorldTimePage {
    private static final String pageUrl = "https://www.worldtimeserver.com/current_time_in_AW.aspx";
    private WebDriver driver;

    public WorldTimePage(WebDriver driver) {
        this.driver = driver;
    }
    public void open (){
        driver.get(pageUrl);
    }
    public void close(){
        driver.quit();
    }

    public void compare() {
        Ocular.snapshot()
                .from(this)
                .sample().using(driver)
                .compare();
    }
}
