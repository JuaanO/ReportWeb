package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Helpers {

    public void sleepSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateDate() {
        Date objDate = new Date();
//        String strDateFormat = "EEEE MMMM d HH:mm:ss";
        String strDateFormat = "EEEE MMMM d";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat, Locale.UK);
        return objSDF.format(objDate);
    }

    public static void takeScrenshoot(WebDriver driver){
        File screenshoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshoot, new File(
                    "src/test/resources/output/screenshots/Screnshoot_"+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
