package ikiNhaber_CaseStudy.tests;

import ikiNhaber_CaseStudy.pages.HomePage;
import ikiNhaber_CaseStudy.utilities.ConfigReader;
import ikiNhaber_CaseStudy.utilities.Driver;
import ikiNhaber_CaseStudy.utilities.ExtentReportUtils;
import ikiNhaber_CaseStudy.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase_02_SearchButton {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());


    @Test(description = "TC02_Ziyaretci Açılan inputa “İstanbul” yazarak arama yapmalı ve çıkan sonuçların ilk sayfasındaki 8.haberin detayına gitmelidir")
    public void TC02_Search() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberUrl"));
        ExtentReportUtils.extentTestInfo("Siteye gidilir");
        WaitUtils.waitFor(2);
        homePage.searchPopupDiv.click();
        ExtentReportUtils.extentTestInfo("Search ikonuna tıklanır");

        homePage.searchField.sendKeys("İstanbul", Keys.ENTER);
        ExtentReportUtils.extentTestInfo("İnput kısmına -İstanbul- girilir");
        String orderOfNews = "8";
        String orderRequested = "(//h3//a)[" + orderOfNews + "]";
        WebElement element = Driver.getDriver().findElement(By.xpath(orderRequested));
        actions.moveToElement(element).perform();
        WaitUtils.waitFor(3);
        element.click();
        ExtentReportUtils.extentTestInfo(orderRequested+".habere tıklanır");
        String expectedData="İletişim – 2N Haber";
        String actualData = Driver.getDriver().getTitle();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData,expectedData);
        ExtentReportUtils.extentTestInfo("Haberin detayına gidilebildigi dogrulanır");

    }

}






