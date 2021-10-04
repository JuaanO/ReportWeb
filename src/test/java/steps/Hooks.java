package steps;

import helpers.Helpers;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Hooks {

    private static WebDriver driver;
    private static int numberOfCase = 0;

    @Before
    public void setUp() throws IOException {
        numberOfCase++;
            Properties props = new Properties();
            props.load(new FileReader("src/test/resources/config.properties"));
            System.out.println("Scenario: " + numberOfCase + " is running ..");
        try
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            capabilities.setCapability("videoName", "Test Execution at " + Helpers.generateDate() + ".mp4");
            capabilities.setCapability("enableLog", true);
            URL url = new URL(props.getProperty("url_local"));
            driver = new RemoteWebDriver(url, capabilities);
            Capabilities.initDocker(driver);

        }
        catch(UnreachableBrowserException e1)
        {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            Capabilities.initLocal(driver);
        }
    }

//    @AfterStep
//    public void embedPhotoAfter(Scenario scenario){
//        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.embed(screenshot, "image/jpeg");
//    }

//    @BeforeStep
//    public void embedPhotoBefore(Scenario scenario){
//        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.embed(screenshot, "image/png");
//    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/jpeg");
        }
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
