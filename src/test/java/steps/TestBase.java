package steps;

import org.openqa.selenium.WebDriver;
import pages.*;
import steps.Sms.SendMessage;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
//    protected MainPage mainPage = new MainPage(driver);
    protected SmsPage smsPage = new SmsPage(driver);
    protected DetailedReportPage detailedReportPage = new DetailedReportPage(driver);
    protected smsReportPage smsReportPage = new smsReportPage(driver);
    protected MashUpPage mashUpPage = new MashUpPage(driver);

//    protected SmsPage smsPage = new SmsPage(driver);
}
