package steps;

import helpers.Helpers;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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
    private static String BROWSER = "chrome";
    static Logger logger = LogManager.getLogger();

    @Before
    public void setUp() throws IOException {
        numberOfCase++;
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        logger.info("Scenario: " + numberOfCase + " is running ..");
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            capabilities.setCapability("videoName", "Test Execution at " + Helpers.generateDate() + ".mp4");
            capabilities.setCapability("enableLog", true);
            URL url = new URL(props.getProperty("url_local"));
            driver = new RemoteWebDriver(url, capabilities);
            Capabilities.initDocker(driver);

        } catch (UnreachableBrowserException e) {
//            if (BROWSER.equalsIgnoreCase("chrome")) {
//                System.setProperty("webdriver.chrome.driver", "src/test/resources/linux/chromedriver");
//                driver = new ChromeDriver();
//                Capabilities.initLocal(driver);
//                logger.info("-------> Local Execution from Chrome!!");
//            } else if (BROWSER.equalsIgnoreCase("firefox")) {
//                System.setProperty("webdriver.gecko.driver", "src/test/resources/linux/chromedriver");
//                FirefoxProfile profile = new FirefoxProfile();
//                FirefoxOptions options = new FirefoxOptions();
//                profile.setPreference("intl.accept_languages", "en-GB");
//                options.setCapability("Marionette", false);
//                options.setProfile(profile);
//                driver = new FirefoxDriver(options);
//                Capabilities.initLocal(driver);
//                logger.info("-------> Local Execution from Firefox!!");
//            }
            logger.error("SE EJECUTO LOCAL NO SE PORQUE");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/jpeg");
        }
        driver.close();
        logger.info("-------> Close Driver !!");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
