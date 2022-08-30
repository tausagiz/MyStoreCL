package pl.coderslab.mystore.testlab.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseFunctions {
    public static void waitFor(int seconds) {
        int milliseconds = seconds * 1000;
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String formattedDate = formatter.format(date);
        String filename = formattedDate + "screenshot.png";
        String filenameWithPath = "screenshots/" + filename;
        File DestFile = new File(filenameWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
