package ru.pflb.pages;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.pflb.DriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractPage implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String screenName = new SimpleDateFormat("HH-mm-ss_dd-MM-yyyy").format(new Date()) + ".png";
        String path = new File("").getAbsolutePath() + File.separator + "target" +
                File.separator + "ScreenshotResults" +
                File.separator + screenName;
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            Allure.addAttachment(path, new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static String generationEmail(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            stringBuilder.append((char)((Math.random() * 123 ) + 97));
            System.out.println((int)((Math.random() * 123 ) - 97));
        }
        stringBuilder.append("@1secmail.com");
        return stringBuilder.toString();
    }

    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy(0, 10000)", "");
    }

    public static void main(String[] args) {
        System.out.println(generationEmail());
    }
}
