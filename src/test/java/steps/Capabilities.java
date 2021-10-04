package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Capabilities extends TestBase {

    private static int TIMEOUT = 30;

    public static Properties properties() throws IOException{
        Properties properties = new Properties();
        properties.load(new FileReader("src/test/resources/config.properties"));
        return properties;
    }

    public static void initDocker(WebDriver driver) throws IOException {
        System.out.println("-------> Docker Execution..!!");
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(properties().getProperty("production"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(properties().getProperty("user"), properties().getProperty("password"));
        loginPage.assertionLogin();
    }

    public static void initLocal(WebDriver driver) throws IOException {
        System.out.println("-------> Local Execution..!!");
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(properties().getProperty("production"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(properties().getProperty("user"), properties().getProperty("password"));
        loginPage.assertionLogin();
    }
}
