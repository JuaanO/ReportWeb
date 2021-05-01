package steps;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private static WebDriver driver;
    private static int numberOfCase = 0;

    @Before
    public void setUp() throws IOException {
        numberOfCase++;
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        System.out.println("Scenario: " + numberOfCase + " is running ..");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("enableVNC", true);
        URL url = new URL(props.getProperty("url_local"));
        driver = new RemoteWebDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(props.getProperty("production"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(props.getProperty("user"), props.getProperty("password"));
        loginPage.assertionLogin();
        driver.manage().window().maximize();
    }

    @AfterStep
    public void embedPhotoAfter(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    @BeforeStep
    public void embedPhotoBefore(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
