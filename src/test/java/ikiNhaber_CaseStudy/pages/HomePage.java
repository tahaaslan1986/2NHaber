package ikiNhaber_CaseStudy.pages;

import ikiNhaber_CaseStudy.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//svg[contains(@class, 'e-fas-search')]")
    public WebElement searchIcon;
    @FindBy(xpath = "//input[@type='search' and @placeholder='Keşfet...']")
    public WebElement searchField;
    @FindBy(xpath = "//div[@class='elementor-widget-cmsmasters-search__popup-trigger-inner']")
    public WebElement searchPopupDiv;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameField;
    @FindBy(xpath = "//input[@id='birth']")
    public WebElement birthDateField;
    @FindBy(xpath = "//input[@id='tcKimlik']")
    public WebElement tcKimlikField;
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneField;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailField;
    @FindBy(xpath = "//input[@id='cv_field']")
    public WebElement cvUploadField;
    @FindBy(xpath = "//button[text()='Önlisans']")
    public WebElement associateDegreeButton;
    @FindBy(xpath = "//button[text()='Lisans']")
    public WebElement bachelorDegreeButton;
    @FindBy(xpath = "//button[text()='Yüksek Lisans']")
    public WebElement masterDegreeButton;
    @FindBy(xpath = "//button[text()='Doktora']")
    public WebElement phdDegreeButton;
    @FindBy(xpath = "//button[text()='Lise']")
    public WebElement highSchoolButton;
    @FindBy(xpath = "//input[@id='pdp1']")
    public WebElement kvkkConsentCheckbox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@class='w-8 h-8 cursor-not-allowed']")
    public WebElement disabledNextStepButton;
    @FindBy(xpath = "//label[@for='cv_field']")
    public WebElement cvUploadLabel;
    @FindBy(css = ".elementor-widget-cmsmasters-search__popup-trigger-inner")
    public WebElement searchPopupTrigger;
    @FindBy(xpath = "//span[@class='text-[15px] font-semibold text-[#333333] group-hover:text-white' and text()='Test Engineer']")
    public WebElement testEngineerText;
    @FindBy(xpath = "//div[@class='text-white flex justify-center items-center text-[14px] py-2 px-4 rounded-full bg-[#DF1F29] cursor-pointer' and text()='Gönder']")
    public WebElement sendButtonText;
    @FindBy(xpath = "//p[@class='text-[16px] flex justify-start items-start leading-6' and text()='Form Başarı ile gönderildi. Katıldığınız için teşekkür ederiz.']")
    public WebElement successMessageText;
    @FindBy(xpath = "//a[@href='https://2nhaber.com/spor/' and @aria-label='Menu item' and text()='Spor']")
    public WebElement sportLink;
    @FindBy(xpath = "//svg[@class='e-font-icon-svg e-fas-bars']")
    public WebElement hamburgerMenu;
    //    @FindBy(xpath = "//svg[@class='e-font-icon-svg e-fas-bars']")
//    public WebElement menuIcon;
    @FindBy(xpath = "//span[contains(@class, 'elementor-widget-cmsmasters-offcanvas__trigger-icon')]/svg")
    public WebElement menuIcon;
    @FindBy(css = "div.text-white.flex.justify-center.items-center.text-[14px].py-2.px-4.rounded-full.bg-[#DF1F29].cursor-pointer")
    public WebElement sendButton;
    @FindBy(xpath = "//div[text()='Gönder']")
    public WebElement GonderButton;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement forwardButton;
    @FindBy(xpath = "//div[@class='w-8 h-8 cursor-not-allowed']/svg")
    public WebElement backButton;
    @FindBy(xpath = "//div[contains(@class, 'group') and .//span[contains(text(), 'Test Engineer')]]")
    public WebElement testEngineerCard;
    @FindBy(xpath = "//li[@id='menu-item-31623']/a")
    public WebElement mainMenuNasil;
    @FindBy(xpath = "//li[@id='menu-item-31912']/a")
    public WebElement subMenuUzayHavacilik;
    @FindBy(xpath = "//a[text()='Plastik atıklar uzaydan tespit edilecek']")
    public WebElement linkPlastikAtiklar;
    @FindBy(css = ".elementor-social-icon-facebook")
    public WebElement facebookIcon;
    @FindBy(xpath = "//a[@href='https://www.facebook.com/2nnews']")
    public WebElement facebookIconOnHamburgerMenu;
    @FindBy(xpath = "//a[@href='#' and contains(@class, 'elementor-social-icon-instagram')]")
    public WebElement instagramLink;
    @FindBy(xpath = "(//a[contains(@class, 'elementor-social-icon-youtube')])[2]")
    public WebElement youtubeLink;
    @FindBy(xpath = "//a[contains(@class, 'elementor-social-icon-twitter')]")
    public WebElement twitterLink;


    //Error Messages
    @FindBy(xpath = "//input[@id='name']/following-sibling::div")
    public WebElement nameErrorMsg;
    @FindBy(xpath = "//input[@id='tcKimlik']/following-sibling::div")
    public WebElement tcKimlikErrorMsg;
    @FindBy(xpath = "//div[@class='text-red-500 text-sm' and contains(text(), 'T.C. Kimlik Numarası 11 haneli olmalıdır')]")
    public WebElement tcKimlikLengthErrorMsg;
    @FindBy(xpath = "//div[text()='Telefon numarası zorunludur']")
    public WebElement phoneNumberErrorMsg;
    @FindBy(xpath = "//input[@id='phone']/following-sibling::div")
    public WebElement phoneErrorMsg;
    @FindBy(xpath = "//div[@class='text-red-500 text-sm' and contains(text(), 'Geçerli bir telefon numarası giriniz')]")
    public WebElement invalidPhoneNumberErrorMsg;
    @FindBy(xpath = "//input[@id='email']/following-sibling::div")
    public WebElement emailErrorMsg;
    @FindBy(xpath = "//div[@class='text-red-500 text-sm' and contains(text(), 'Geçerli bir e-posta adresi giriniz')]")
    public WebElement invalidEmailErrorMsg;
    @FindBy(xpath = "//input[@id='cv_field']/following-sibling::div")
    public WebElement CVErrorMessage;
    @FindBy(xpath = "//div[text()='CV yüklemek zorunludur']")
    public WebElement cvUploadErrorMsg;
    @FindBy(xpath = "//input[@id='pdp1']/following-sibling::div")
    public WebElement kvkkErrorMsg;
    @FindBy(xpath = "//div[text()='Lütfen bir eğitim seviyesi seçiniz']")
    public WebElement educationLevelErrorMsg;
    @FindBy(xpath = "//div[text()='Onay vermeniz gerekmektedir']")
    public WebElement consentErrorMsg;


}
