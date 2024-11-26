package ikiNhaber_CaseStudy.tests;

import ikiNhaber_CaseStudy.utilities.ExtentReportUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
public class TestCase_01_NavbarElements {

@Test(description = "TC01_Ziyaretci Navbar Elementlere sırası ile tıklanmalıdır")
public void TC01_accesstoNavbarElements() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://2nhaber.com/");
    ExtentReportUtils.extentTestInfo("Siteye gidilir");
    Actions actions = new Actions(driver);

    List<WebElement> mainCategories = driver.findElements(By.xpath("//ul[@id='menu-1-5dc673f1']/li"));

    for (int mainIndex = 0; mainIndex < mainCategories.size(); mainIndex++) {
        mainCategories = driver.findElements(By.xpath("//ul[@id='menu-1-5dc673f1']/li"));
        ExtentReportUtils.extentTestInfo("Herbir element sırasıyla tıklanır");

        WebElement mainCategory = mainCategories.get(mainIndex);
        actions.moveToElement(mainCategory).perform();
        Thread.sleep(1000);

        List<WebElement> subCategories = mainCategory.findElements(By.xpath(".//ul/li/a"));

        for (int subIndex = 0; subIndex < subCategories.size(); subIndex++) {
            subCategories = mainCategory.findElements(By.xpath(".//ul/li/a"));

            WebElement subCategory = subCategories.get(subIndex);
            String subCategoryText = subCategory.getText();
            subCategory.click();
            Thread.sleep(1000);
            ExtentReportUtils.extentTestInfo("Herbir alt kategori sırasıyla tıklanır");

            String pageTitle = driver.getTitle();
            System.out.println("Alt kategoriye tıklandı: " + subCategoryText);
            System.out.println("Sayfa başlığı: " + pageTitle);
            ExtentReportUtils.extentTestInfo("Sayfa başlıgı alınır");

            Assert.assertTrue("Sayfa başlığı doğru değil!", pageTitle.contains(subCategoryText));
            ExtentReportUtils.extentTestInfo("Sayfa başlıgı dogrulanır");

            WebElement pageHeader = driver.findElement(By.tagName("h1"));
            Assert.assertTrue("Sayfada beklenen başlık bulunamadı!", pageHeader.isDisplayed());

            driver.navigate().back();
            Thread.sleep(1000);

            mainCategories = driver.findElements(By.xpath("//ul[@id='menu-1-5dc673f1']/li"));
            mainCategory = mainCategories.get(mainIndex);
            actions.moveToElement(mainCategory).perform();
            Thread.sleep(1000);
        }
    }

    driver.quit();
    }

}
