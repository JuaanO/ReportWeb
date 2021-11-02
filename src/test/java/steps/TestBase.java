package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;
import pages.Reports.DetailedReportPage;
import pages.Reports.smsReportPage;
import pages.Sms.SmsFastCampaignPage;
import pages.Sms.SmsMassiveCampaignPage;
import pages.Voice.VoiceFastCampaignPage;
import pages.Voice.VoiceMassiveCampaignPage;
import pages.WhatsApp.WhatsAppFastCampaignPage;
import pages.WhatsApp.WhatsAppMassiveCampaignPage;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected static Logger logger = LogManager.getLogger();

    protected DetailedReportPage detailedReportPage = new DetailedReportPage(driver);
    protected pages.Reports.smsReportPage smsReportPage = new smsReportPage(driver);

    protected MashUpPage mashUpPage = new MashUpPage(driver);

    protected Commons commons = new Commons(driver);

    protected SmsFastCampaignPage smsFastCampaignPage = new SmsFastCampaignPage(driver);
    protected SmsMassiveCampaignPage smsMassiveCampaignPage = new SmsMassiveCampaignPage(driver);

    protected VoiceFastCampaignPage voiceFastCampaignPage = new VoiceFastCampaignPage(driver);
    protected VoiceMassiveCampaignPage voiceMassiveCampaignPage = new VoiceMassiveCampaignPage(driver);

    protected WhatsAppFastCampaignPage whatsAppFastCampaignPage = new WhatsAppFastCampaignPage(driver);
    protected WhatsAppMassiveCampaignPage whatsAppMassiveCampaignPage = new WhatsAppMassiveCampaignPage(driver);

}
