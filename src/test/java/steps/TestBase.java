package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected SmsPage smsPage = new SmsPage(driver);
    protected DetailedReportPage detailedReportPage = new DetailedReportPage(driver);
    protected smsReportPage smsReportPage = new smsReportPage(driver);
    protected MashUpPage mashUpPage = new MashUpPage(driver);
    protected WhatsAppPage whatsAppPage = new WhatsAppPage(driver);
}
