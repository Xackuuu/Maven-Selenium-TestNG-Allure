package ru.pflb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;

    public DriverManager(){}

    public static WebDriver getDriver(){
        if (driver != null) {
            return driver;
        }

        InputStream inputStream = DriverManager.class.getClassLoader().getResourceAsStream("cfg.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("");
        String pathDriver = file.getAbsolutePath()+file.separator+"src"+file.separator+"main"+file.separator
                +"resources"+file.separator+"Driver"+file.separator+"chromedriver.exe";
        String urlTestStand = properties.getProperty("selenium.testStand");
        System.setProperty("webdriver.chrome.driver", pathDriver);
        int timeWaitSecond = Integer.parseInt(properties.getProperty("timeWaitSecond"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeWaitSecond, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(timeWaitSecond, TimeUnit.SECONDS);
        driver.get(urlTestStand);
        return driver;
    }
}
