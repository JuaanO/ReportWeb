package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected SmsPage smsPage = new SmsPage(driver);
    protected DetailedReportPage detailedReportPage = new DetailedReportPage(driver);
    protected smsReportPage smsReportPage = new smsReportPage(driver);
    protected MashUpPage mashUpPage = new MashUpPage(driver);
    protected WhatsAppPage whatsAppPage = new WhatsAppPage(driver);
    protected VoicePage voicePage = new VoicePage(driver);
    protected static Logger logger = LogManager.getLogger();

}
