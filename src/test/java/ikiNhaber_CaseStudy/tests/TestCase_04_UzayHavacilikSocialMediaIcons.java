package ikiNhaber_CaseStudy.tests;

import ikiNhaber_CaseStudy.pages.HomePage;
import ikiNhaber_CaseStudy.utilities.ConfigReader;
import ikiNhaber_CaseStudy.utilities.Driver;
import ikiNhaber_CaseStudy.utilities.ExtentReportUtils;
import ikiNhaber_CaseStudy.utilities.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TestCase_04_UzayHavacilikSocialMediaIcons {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    Set<String> allWindows;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberUrl"));
        ExtentReportUtils.extentTestInfo("Siteye gidilir");
        actions.moveToElement(homePage.mainMenuNasil).perform();
        ExtentReportUtils.extentTestInfo("Nasıl menüsü üzerine gidilir");
        homePage.subMenuUzayHavacilik.click();
        ExtentReportUtils.extentTestInfo("Uzay/Havacılık sekmesi tıklanır");
        actions.moveToElement(homePage.linkPlastikAtiklar).click().perform();
        ExtentReportUtils.extentTestInfo("Plastik atıklar uzaydan tespit edilecek haberi tıklanır");
    }

    public void switchToNewWindow() {
        String currentWindow = Driver.getDriver().getWindowHandle();
        allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                Driver.getDriver().switchTo().window(window);
                break;
            }
        }
    }

    public void switchBackToMainWindow(String currentWindow) {
        Driver.getDriver().switchTo().window(currentWindow);
    }

    // Facebook test
    @Test(description = "TC04_01_Ziyaretci Nasıl>Uzay/Havacılık sekmesindeki haber detayından facebook ikonu ile facebook'a erişebilmelidir")
    public void TC04_01_SocialMediaIconsTest() {
        actions.moveToElement(homePage.facebookIcon).click().perform();
        ExtentReportUtils.extentTestInfo("Facebook ikonu tıklanır");

        String currentWindow = Driver.getDriver().getWindowHandle();
        switchToNewWindow();

        String currentPage = Driver.getDriver().getTitle();
        System.out.println("Yeni sekmenin başlığı: " + currentPage);
        Assert.assertTrue(currentPage.toLowerCase().contains("facebook"));
        ExtentReportUtils.extentTestInfo("Facebook sayfasına erişildiği doğrulanır");

        Driver.getDriver().close();
        switchBackToMainWindow(currentWindow);
    }

    // Instagram test
    @Test(description = "TC04_02_Ziyaretci Nasıl>Uzay/Havacılık sekmesindeki haber detayından instagram ikonu ile instagram'a erişebilmelidir")
    public void TC04_02_SocialMediaIconsTest() {
        actions.moveToElement(homePage.instagramLink).click().perform();
        ExtentReportUtils.extentTestInfo("Instagram ikonu tıklanır");

        String currentWindow = Driver.getDriver().getWindowHandle();
        switchToNewWindow();

        String currentPage = Driver.getDriver().getTitle();
        System.out.println("Yeni sekmenin başlığı: " + currentPage);
        Assert.assertTrue(currentPage.toLowerCase().contains("instagram"));
        ExtentReportUtils.extentTestInfo("Instagram sayfasına erişildiği doğrulanır");

        switchBackToMainWindow(currentWindow);
    }

    // YouTube test
    @Test(description = "TC04_03_Ziyaretci Nasıl>Uzay/Havacılık sekmesindeki haber detayından youtube ikonu ile youtube'a erişebilmelidir")
    public void TC04_03_SocialMediaIconsTest() {
        actions.moveToElement(homePage.youtubeLink).click().perform();
        ExtentReportUtils.extentTestInfo("YouTube ikonu tıklanır");

        String currentWindow = Driver.getDriver().getWindowHandle();
        switchToNewWindow();

        String currentPage = Driver.getDriver().getTitle();
        System.out.println("Yeni sekmenin başlığı: " + currentPage);
        Assert.assertTrue(currentPage.toLowerCase().contains("youtube"));
        ExtentReportUtils.extentTestInfo("YouTube sayfasına erişildiği doğrulanır");

        switchBackToMainWindow(currentWindow);
    }

    // Twitter test
    @Test(description = "TC04_04_Ziyaretci Nasıl>Uzay/Havacılık sekmesindeki haber detayından twitter ikonu ile twitter'a erişebilmelidir")
    public void TC04_04_SocialMediaIconsTest() {
        actions.moveToElement(homePage.twitterLink).click().perform();
        ExtentReportUtils.extentTestInfo("Twitter ikonu tıklanır");

        String currentWindow = Driver.getDriver().getWindowHandle();
        switchToNewWindow();

        String currentPage = Driver.getDriver().getTitle();
        System.out.println("Yeni sekmenin başlığı: " + currentPage);
        Assert.assertTrue(currentPage.toLowerCase().contains("2n_news"));
        ExtentReportUtils.extentTestInfo("Twitter sayfasına erişildiği doğrulanır");

        switchBackToMainWindow(currentWindow);
    }

    @AfterMethod
    public void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.getDriver().quit();  // WebDriver oturumunu tamamen kapat
        }
    }
}



