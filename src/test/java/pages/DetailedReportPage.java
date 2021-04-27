package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class DetailedReportPage {

    private WebDriver driver;
    private final By userDropDownButton, userDropUpButton, selectAllCheck;
    private final By searchInputName, selectNameOption, referenceIntput;
    private final By menuButton, typeDropDownButton, typeDropUpButton;
    private final By typeOptionCheck, searchButton, downloadButton;
    private final By mainButton, detailReport, smsButton, backReportButton;
    private final By idSendLink;

    public DetailedReportPage(WebDriver driver){
        this.driver = driver;
        userDropDownButton = By.xpath("//*[@id='multiSelectUser']/div/div[1]/span");
        userDropUpButton = By.xpath("//*[@id='multiSelectUser']/div/div[1]/span");
        selectAllCheck = By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[1]/li[1]/div");
        searchInputName = By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[1]/li[2]/input");
        selectNameOption = By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[2]/li");
        referenceIntput = By.xpath("//input[@placeholder='Reference']");
        menuButton = By.xpath("/html/body/app-root/div[2]/app-header/header/nav/div[1]/a/i");
        typeDropDownButton = By.xpath("//*[@id='multiSelectMessageType']/div/div[1]/span");
        typeDropUpButton = By.xpath("//*[@id='multiSelectMessageType']/div/div[1]/span");
        typeOptionCheck = By.xpath("//div[normalize-space()='SMS']");
        searchButton = By.xpath("//button[normalize-space()='Search']");
        downloadButton = By.xpath("//i[@class='fas fa-file-download fa-2x']");
        mainButton = By.xpath("//a[@class='navbar-brand']//img");
        detailReport = By.xpath("//*[@id='SmsSubMenu']/li[2]/a");
        smsButton = By.xpath("//span[normalize-space()='SMS']");
        backReportButton = By.xpath("//i[@class='fas fa-arrow-left fa-lg']");
        idSendLink = By.xpath("//*[contains(@class, 'align-middle name processStatusTooltip')]");
    }

    public void openMenu(){
        driver.findElement(menuButton).click();
        driver.findElement(smsButton).click();
        driver.findElement(detailReport).click();
    }

    public void fillForm(String user, String reference){
        driver.findElement(menuButton).click();
        driver.findElement(userDropDownButton).click();
        driver.findElement(selectAllCheck).click();
        driver.findElement(searchInputName).sendKeys(user);
        driver.findElement(selectNameOption).click();
        driver.findElement(userDropUpButton).click();
        driver.findElement(referenceIntput).sendKeys(reference);
        driver.findElement(typeDropDownButton).click();
        driver.findElement(typeOptionCheck).click();
        driver.findElement(typeDropUpButton).click();
    }


    public void inputReference(String reference){
        driver.findElement(referenceIntput).sendKeys(reference);
    }

    public void chooseType(){
        driver.findElement(typeDropDownButton).click();
        driver.findElement(typeOptionCheck).click();
        driver.findElement(typeDropUpButton).click();
    }

    public void searchReport(){
        driver.findElement(searchButton).click();
    }

    public void openDetailedFilter(){
        driver.findElement(By.xpath("//p[@class='text-center mb-0 tx-color-secondary btn-more pointer']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'align-middle name processStatusTooltip')]"));

    }

    public void clickIdSend() {
        List<WebElement> idSends = driver.findElements(idSendLink);
        for(int i = 1; i < idSends.size(); i++){
            System.out.println("//tbody/tr["+i+"]/th[1]");
            driver.findElement(By.xpath("//tbody/tr["+i+"]/th[1]")).click();
            driver.findElement(backReportButton).click();

        }
    }

    public void downloadReport(){
        driver.findElement(downloadButton).click();
    }

    public void returnMainPage() throws InterruptedException {
        driver.findElement(mainButton).click();
        sleep(3000);
    }

    public void assertionReportPage(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Detailed Report']")).getText().contains("Detailed Report"));
    }
}
