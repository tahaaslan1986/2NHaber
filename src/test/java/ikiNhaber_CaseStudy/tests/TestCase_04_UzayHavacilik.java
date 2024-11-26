package ikiNhaber_CaseStudy.tests;

import ikiNhaber_CaseStudy.pages.HomePage;
import ikiNhaber_CaseStudy.utilities.ConfigReader;
import ikiNhaber_CaseStudy.utilities.Driver;
import ikiNhaber_CaseStudy.utilities.ExtentReportUtils;
import ikiNhaber_CaseStudy.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class TestCase_04_UzayHavacilik {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    Set<String> allWindows;
    JavascriptExecutor js;

    @Test(description = "TC04_01_Ziyaretci Nasıl>Uzay/Havacılık sekmesindeki haber detayından facebook ikonu ile facebook'a erişebilmelidir")
    public void TC04_01_SocialMediaIconsTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberUrl"));
        ExtentReportUtils.extentTestInfo("Siteye gidilir");
        WaitUtils.waitFor(2);
        actions.moveToElement(homePage.mainMenuNasil).perform();
        ExtentReportUtils.extentTestInfo("Nasıl menüsü üzerine gidilir");

        homePage.subMenuUzayHavacilik.click();
        ExtentReportUtils.extentTestInfo("Uzay/Havacılık sekmesi tıklanır");

        actions.moveToElement(homePage.linkPlastikAtiklar).click().perform();
        ExtentReportUtils.extentTestInfo("Plastik atıklar uzaydan tespit edilecek haberi tıklanır");

        WaitUtils.waitFor(3);
        actions.moveToElement(homePage.facebookIcon).click().perform();
        ExtentReportUtils.extentTestInfo("Facebook ikonu tıklanır");


        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                Driver.getDriver().switchTo().window(window);
                break;
            }
        }

        String currentPage = Driver.getDriver().getTitle();
        System.out.println("Yeni sekmenin başlığı: " + currentPage);
        Assert.assertTrue(currentPage.toLowerCase().contains("facebook"));
        ExtentReportUtils.extentTestInfo("Facebook sayfasına erişildiği doğrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC04_02_Ziyaretci Nasıl>Uzay/Havacılık sekmesindeki haber detayından instagram ikonu ile instagram'a erişebilmelidir")
    public void TC04_02_SocialMediaIconsTest() {
        homePage = new HomePage();
        // Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberUrl"));
        ExtentReportUtils.extentTestInfo("Siteye gidilir");
        WaitUtils.waitFor(2);
        actions.moveToElement(homePage.mainMenuNasil).perform();
        ExtentReportUtils.extentTestInfo("Nasıl menüsü üzerine gidilir");

        homePage.subMenuUzayHavacilik.click();
        ExtentReportUtils.extentTestInfo("Uzay/Havacılık sekmesi tıklanır");

        actions.moveToElement(homePage.linkPlastikAtiklar).click().perform();
        ExtentReportUtils.extentTestInfo("Plastik atıklar uzaydan tespit edilecek haberi tıklanır");

        WaitUtils.waitFor(3);
        actions.moveToElement(homePage.instagramLink).click().perform();
        ExtentReportUtils.extentTestInfo("Instagram ikonu tıklanır");


        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                Driver.getDriver().switchTo().window(window);
                break;
            }
        }

        String currentPage = Driver.getDriver().getTitle();
        System.out.println("Yeni sekmenin başlığı: " + currentPage);
        Assert.assertTrue(currentPage.toLowerCase().contains("instagram"));
        ExtentReportUtils.extentTestInfo("Instagram sayfasına erişildiği doğrulanır");
        Driver.getDriver().switchTo().window(currentWindow);
        WaitUtils.waitFor(2);

    }

    @Test(description = "TC04_03_Ziyaretci Nasıl>Uzay/Havacılık sekmesindeki haber detayından youtube ikonu ile youtube'a erişebilmelidir")
    public void TC04_03_SocialMediaIconsTest() {
        homePage = new HomePage();
        // Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberUrl"));
        ExtentReportUtils.extentTestInfo("Siteye gidilir");
        WaitUtils.waitFor(2);
        actions.moveToElement(homePage.mainMenuNasil).perform();
        ExtentReportUtils.extentTestInfo("Nasıl menüsü üzerine gidilir");

        homePage.subMenuUzayHavacilik.click();
        ExtentReportUtils.extentTestInfo("Uzay/Havacılık sekmesi tıklanır");

        actions.moveToElement(homePage.linkPlastikAtiklar).click().perform();
        ExtentReportUtils.extentTestInfo("Plastik atıklar uzaydan tespit edilecek haberi tıklanır");

        WaitUtils.waitFor(3);
        actions.moveToElement(homePage.youtubeLink).click().perform();
        ExtentReportUtils.extentTestInfo("YouTube ikonu tıklanır");


        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                Driver.getDriver().switchTo().window(window);
                break;
            }
        }

        String currentPage = Driver.getDriver().getTitle();
        System.out.println("Yeni sekmenin başlığı: " + currentPage);
        Assert.assertTrue(currentPage.toLowerCase().contains("youtube"));
        ExtentReportUtils.extentTestInfo("YouTube sayfasına erişildiği doğrulanır");
        Driver.getDriver().switchTo().window(currentWindow);
        WaitUtils.waitFor(2);
    }

    @Test(description = "TC04_03_Ziyaretci Nasıl>Uzay/Havacılık sekmesindeki haber detayından twitter ikonu ile twitter'a erişebilmelidir")
    public void TC04_04_SocialMediaIconsTest() {
        homePage = new HomePage();
        // Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberUrl"));
        ExtentReportUtils.extentTestInfo("Siteye gidilir");
        WaitUtils.waitFor(2);
        actions.moveToElement(homePage.mainMenuNasil).perform();
        ExtentReportUtils.extentTestInfo("Nasıl menüsü üzerine gidilir");

        homePage.subMenuUzayHavacilik.click();
        ExtentReportUtils.extentTestInfo("Uzay/Havacılık sekmesi tıklanır");

        actions.moveToElement(homePage.linkPlastikAtiklar).click().perform();
        ExtentReportUtils.extentTestInfo("Plastik atıklar uzaydan tespit edilecek haberi tıklanır");

        WaitUtils.waitFor(3);
        actions.moveToElement(homePage.twitterLink).click().perform();
        ExtentReportUtils.extentTestInfo("Twitter ikonu tıklanır");


        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                Driver.getDriver().switchTo().window(window);
                break;
            }
        }

        String currentPage = Driver.getDriver().getTitle();
        System.out.println("Yeni sekmenin başlığı: " + currentPage);
        Assert.assertTrue(currentPage.toLowerCase().contains("2n_news"));
        ExtentReportUtils.extentTestInfo("Twitter sayfasına erişildiği doğrulanır");
        Driver.getDriver().switchTo().window(currentWindow);
        WaitUtils.waitFor(2);
    }

}





