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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase_03_Form {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test(description = "TC03_01_Ziyaretci 1. ve 2. adımı eksiksiz doldurarak formu başarılı bir şekilde göndermelidir")
    public void TC01_Form_PositiveTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        ExtentReportUtils.extentTestInfo("Siteye gidilir");
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("30196111111", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05419773434", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("eng.TahaAslan@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\TAHAASLAN_Eng_Resume_2024_20_November.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        homePage.testEngineerText.click();
        ExtentReportUtils.extentTestInfo("Test Engineer pozisyonu secilir");
        actions.moveToElement(homePage.sendButtonText).perform();
        WaitUtils.waitFor(1);
        homePage.sendButtonText.click();
        ExtentReportUtils.extentTestInfo("Gönder butonuna tıklanarak Form gönderilir");
        String expectedData = "Form Başarı ile gönderildi. Katıldığınız için teşekkür ederiz.";
        String actualData = homePage.successMessageText.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);
        ExtentReportUtils.extentTestInfo("Gecerli verilerle Form'un basarı ile gönderildigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_02_Ziyaretci 1. adımda Ad Soyad bilgisini girmediğinde 2.adıma geçememelidir")
    public void TC02_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        //homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilMEZ");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("30999999999", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05419773638", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("eng.tahaaslan@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "Ad Soyad zorunludur";
        String actualData = homePage.nameErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        Driver.getDriver().close();
    }

    @Test(description = "TC03_03_Ziyaretci 1. adımda Ad Soyad bilgisini digit girdiğinde 2.adıma geçememelidir")
    public void TC03_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("1986", Keys.TAB);
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("30000000000", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05209773612", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("etaha@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        homePage.testEngineerText.click();
        ExtentReportUtils.extentTestInfo("Test Engineer pozisyonu secilir");
        actions.moveToElement(homePage.sendButtonText).perform();
        WaitUtils.waitFor(1);
        homePage.sendButtonText.click();
        ExtentReportUtils.extentTestInfo("Gönder butonuna tıklanarak Form gönderilir");
        System.out.println("homePage.successMessageText.getText() = " + homePage.successMessageText.getText());
        Assert.assertFalse(homePage.successMessageText.getText().contains("Başarı"));
        ExtentReportUtils.extentTestInfo("Gecersiz Ad Soyad verisiyle Form'un basarı ile gönderildigi dogrulanır");
        Driver.getDriver().close();
    }


    @Test(description = "TC03_04_Ziyaretci 1. adımda dogum günü bilgisini girmediğinde de formu başarılı bir şekilde göndermelidir")
    public void TC04_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        //homePage.birthDateField.sendKeys("26021986",Keys.TAB);
        homePage.tcKimlikField.sendKeys("50999999951", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05919773691", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("slan86@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        homePage.testEngineerText.click();
        ExtentReportUtils.extentTestInfo("Test Engineer pozisyonu secilir");
        actions.moveToElement(homePage.sendButtonText).perform();
        WaitUtils.waitFor(1);
        homePage.sendButtonText.click();
        ExtentReportUtils.extentTestInfo("Gönder butonuna tıklanarak Form gönderilir");
        String expectedData = "Form Başarı ile gönderildi. Katıldığınız için teşekkür ederiz.";
        String actualData = homePage.successMessageText.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);
        ExtentReportUtils.extentTestInfo("Gecerli verilerle Form'un basarı ile gönderildigi dogrulanır");
        Driver.getDriver().close();
    }

    @Test(description = "TC03_05_Ziyaretci 1. adımda T.C. Kimlik No bilgisini girmediğinde 2.adıma geçememelidir")
    public void TC05_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        //homePage.tcKimlikField.sendKeys("30999999999",Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik No girilMEZ");
        homePage.phoneField.sendKeys("05449773601", Keys.TAB);
        homePage.emailField.sendKeys("engaslan@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "T.C. Kimlik Numarası zorunludur";
        String actualData = homePage.tcKimlikErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_06_Ziyaretci 1. adımda T.C. Kimlik No bilgisini 10 hane girdiğinde 2.adıma geçememelidir")
    public void TC06_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("4099999999", Keys.TAB); //10 hane girildi
        ExtentReportUtils.extentTestInfo("T.C. Kimlik 10 hane girilir");
        homePage.phoneField.sendKeys("05449773602", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("engaslan@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "T.C. Kimlik Numarası 11 haneli olmalıdır";
        String actualData = homePage.tcKimlikLengthErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }


    @Test(description = "TC03_07_Ziyaretci 1. adımda T.C. Kimlik No bilgisini 12 hane girdiğinde 2.adıma geçememelidir")
    public void TC07_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("409999999912", Keys.TAB); //12 hane girildi
        ExtentReportUtils.extentTestInfo("T.C. Kimlik No 12 Hane girilir");
        homePage.phoneField.sendKeys("05449773602", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("engaslan@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");

        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "T.C. Kimlik Numarası 11 haneli olmalıdır";
        String actualData = homePage.tcKimlikLengthErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_08_Ziyaretci 1. adımda T.C. Kimlik No bilgisini 11 hane ama ilk hane 0 girdiğinde 2.adıma geçememelidir")
    public void TC08_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("94999959991", Keys.TAB); //11 hane ama 0 ile baslandi
        ExtentReportUtils.extentTestInfo("T.C. Kimlik No 0 ile başlar girilir");
        homePage.phoneField.sendKeys("05119773604", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("engaslTH@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);

        homePage.testEngineerText.click();
        ExtentReportUtils.extentTestInfo("Test Engineer pozisyonu secilir");
        WaitUtils.waitFor(1);
        actions.moveToElement(homePage.sendButtonText).perform();
        WaitUtils.waitFor(1);
        homePage.sendButtonText.click();
        ExtentReportUtils.extentTestInfo("Gönder butonuna tıklanarak Form gönderilir");
        System.out.println("homePage.successMessageText.getText() = " + homePage.successMessageText.getText());
        Assert.assertFalse(homePage.successMessageText.getText().contains("Başarı"));
        ExtentReportUtils.extentTestInfo("Hatalı T.C. Kimlik No ile Form'un gönderildigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_09_Ziyaretci 1. adımda T.C. Kimlik No bilgisini 11 hane karakter girdiğinde 2.adıma geçememelidir")
    public void TC09_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("abcd.efg?<9", Keys.TAB); //11 hane karakter girildi
        ExtentReportUtils.extentTestInfo("T.C. Kimlik No 11 karakter(not digit) girilir");
        homePage.phoneField.sendKeys("05449773607", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("enlan@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "T.C. Kimlik Numarası 11 haneli olmalıdır";
        String actualData = homePage.tcKimlikLengthErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();
    }

    @Test(description = "TC03_10_Ziyaretci 1. adımda T.C. Kimlik No bilgisini 11 hane her Hane 0 girdiğinde 2.adıma geçememelidir")
    public void TC10_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha BUGHUNTER2", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26022015", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("00000000005", Keys.TAB); //11 hane ama tamamı 0 girildi, son hane tc çakışması hata vermesin diye 1 girildi, çünkü hepsi 0 olan bir kayıt zaten mevcuttur.
        ExtentReportUtils.extentTestInfo("T.C. Kimlik 11 hanesi de 0 girilir");
        homePage.phoneField.sendKeys("05883373606", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("engabcTHTH@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        homePage.testEngineerText.click();
        ExtentReportUtils.extentTestInfo("Test Engineer pozisyonu secilir");
        actions.moveToElement(homePage.sendButtonText).perform();
        WaitUtils.waitFor(1);
        homePage.sendButtonText.click();
        ExtentReportUtils.extentTestInfo("Gönder butonuna tıklanarak Form gönderilir");
        System.out.println("homePage.successMessageText.getText() = " + homePage.successMessageText.getText());
        Assert.assertFalse(homePage.successMessageText.getText().contains("Başarı"));
        ExtentReportUtils.extentTestInfo("Hatalı T.C. Kimlik No ile Form'un gönderildigi dogrulanır");
        Driver.getDriver().close();
    }


    @Test(description = "TC03_11_Ziyaretci 1. adımda telefonu +90 sonrası girdiğinde 2.adıma geçmelidir.")
    public void TC11_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("66655544487", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("5419773607", Keys.TAB); //+90 sonrası girildi
        ExtentReportUtils.extentTestInfo("Telefon bilgisi +90'ın devamı seklinde girilir");
        homePage.emailField.sendKeys("enln@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertFalse(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_12_Ziyaretci 1. adımda telefon bilgisini girmediğinde 2.adıma geçememelidir")
    public void TC12_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("12121212123", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        //homePage.phoneField.sendKeys("05449773607",Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilMEZ");
        homePage.emailField.sendKeys("enlan@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "Telefon numarası zorunludur";
        String actualData = homePage.phoneNumberErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_13_Ziyaretci 1. adımda e-Mail bilgisini girmediğinde 2.adıma geçememelidir")
    public void TC13_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("12121212123", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05449773607", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        //homePage.emailField.sendKeys("enlan@gmail.com",Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilMEZ");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "E-posta adresi zorunludur";
        String actualData = homePage.emailErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_14_Ziyaretci 1. adımda e-Mail bilgisini @ işaretsiz girdiğinde 2.adıma geçememelidir")
    public void TC14_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("12121212123", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05449773607", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("enlangmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi @ işareti olmadan girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "Geçerli bir e-posta adresi giriniz";
        String actualData = homePage.invalidEmailErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_15_Ziyaretci 1. adımda e-Mail bilgisini . işaretsiz girdiğinde 2.adıma geçememelidir")
    public void TC15_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("1071 Taha Hunter", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("12199218129", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05440153608", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("eng_noktasizmail2@gmailcom", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi . işareti olmadan girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);

        homePage.testEngineerText.click();
        ExtentReportUtils.extentTestInfo("Test Engineer pozisyonu secilir");
        actions.moveToElement(homePage.sendButtonText).perform();
        WaitUtils.waitFor(1);
        homePage.sendButtonText.click();
        ExtentReportUtils.extentTestInfo("Gönder butonuna tıklanarak Form gönderilir");
        System.out.println("homePage.successMessageText.getText() = " + homePage.successMessageText.getText());
        Assert.assertFalse(homePage.successMessageText.getText().contains("Başarı"));
        ExtentReportUtils.extentTestInfo("Hatalı e-Mail ile Form'un gönderildigi dogrulanır");
        Driver.getDriver().close();
    }

    @Test(description = "TC03_16_Ziyaretci 1. adımda CV Upload etmediğinde 2.adıma geçememelidir")
    public void TC16_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("12121212123", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05449773607", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("engineer@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        //String filePath="C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        //homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilMEZ");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "CV yüklemek zorunludur";
        String actualData = homePage.cvUploadErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();
    }

    @Test(description = "TC03_17_Ziyaretci 1. adımda eğitim seviyesi bilgisini girmediğinde 2.adıma geçememelidir")
    public void TC17_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("12121212123", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05449773607", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("engineer@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        //homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilMEZ");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "Lütfen bir eğitim seviyesi seçiniz";
        String actualData = homePage.educationLevelErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_18_Ziyaretci 1. adımda kvkk checkBox tıklamadıgında 2.adıma geçememelidir")
    public void TC18_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Taha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("12121212123", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05449773607", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("engineer@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.kvkkConsentCheckbox.click();
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        String expectedData = "Onay vermeniz gerekmektedir";
        String actualData = homePage.consentErrorMsg.getText();
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(actualData, expectedData);//ErrorMessage test edilir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Test Engineer')]")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu."); //2.adım'a geçmediği test edilir
        ExtentReportUtils.extentTestInfo("2.adıma geçilemedigi dogrulanır");
        Driver.getDriver().close();

    }

    @Test(description = "TC03_19_Ziyaretci 2. adımda Test Engineer pozisyonunu secmediginde Formu başarılı gönderememelidir.")
    public void TC19_Form_NegativeTest() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ikiNhaberFormUrl"));
        WaitUtils.waitFor(2);
        homePage.nameField.sendKeys("Bug_ha ASLAN", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Ad Soyad girilir");
        homePage.birthDateField.sendKeys("26021986", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Dogum tarihi girilir");
        homePage.tcKimlikField.sendKeys("30999999011", Keys.TAB);
        ExtentReportUtils.extentTestInfo("T.C. Kimlik girilir");
        homePage.phoneField.sendKeys("05439773630", Keys.TAB);
        ExtentReportUtils.extentTestInfo("Telefon bilgisi girilir");
        homePage.emailField.sendKeys("eng.tah@gmail.com", Keys.TAB);
        ExtentReportUtils.extentTestInfo("e-Mail bilgisi girilir");
        String filePath = "C:\\Users\\SONY\\Desktop\\Resume\\QA_ResumeandCoverLetter_English\\Eng\\tahadenemebosdosya.pdf";
        homePage.cvUploadField.sendKeys(filePath);
        ExtentReportUtils.extentTestInfo("CV Upload edilir");
        homePage.bachelorDegreeButton.click();
        ExtentReportUtils.extentTestInfo("Eğitim seviyesi bilgisi secilir");
        homePage.submitButton.click();
        ExtentReportUtils.extentTestInfo("İleri butonuna tıklanır");
        WaitUtils.waitFor(2);
        //homePage.testEngineerText.click();
        ExtentReportUtils.extentTestInfo("Test Engineer pozisyonu secilMEZ");
        homePage.GonderButton.click();
        ExtentReportUtils.extentTestInfo("Gönder butonuna tıklanır");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='text-[16px] flex justify-start items-start leading-6' " +
                "and text()='Form Başarı ile gönderildi. Katıldığınız için teşekkür ederiz.']")));
        Assert.assertTrue(isElementInvisible, "Element görünüyor, ama görünmemesi bekleniyordu.");
        ExtentReportUtils.extentTestInfo("Form'un TestEngineer pozisyonu seçilmeden gönderileMEDIGI dogrulanır");
        Driver.getDriver().close();
    }

}





