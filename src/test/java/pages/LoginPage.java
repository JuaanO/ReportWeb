package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By userField;
    private final By passwordField;
    private final By loginButton;
    private final By assetionMainPage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        userField = By.xpath("//*[@id='username']");
        passwordField = By.xpath("//*[@id='password']");
        loginButton = By.cssSelector("button[type='submit']");
        assetionMainPage = By.xpath("//h2[normalize-space()='Products']");
    }

    public void login(String user, String pass){
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public void assertionLogin(){

        Assert.assertTrue(driver.findElement(assetionMainPage).getText().contains("Products"));
        try {
            Assert.assertTrue(driver.findElement(assetionMainPage).getText().contains("Products"));
        }
        catch (NoSuchElementException e){
            System.out.println("El elemento no esta presente!! " +assetionMainPage);
        }
    }
}