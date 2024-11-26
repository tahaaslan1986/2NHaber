package ikiNhaber_CaseStudy.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ExtentReportsListener implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    /**
     * onstart==> Tum testlerden once tek bir kez cagrilir
     * Böylece icine yazdigimiz kodlar sayesinde test başladığında raporlama baslatilir.
     *
     * @param context TestNG context nesnesi
     */
    @Override
    public void onStart(ITestContext context) {
        ExtentReportUtils.setUpExtentReport(context.getCurrentXmlTest().getName());
    }

    /**
     * onTestStart==> her bir @Test methodundan once bir kez cagrilir
     * Böylece Test methoduna başlandığında, testName ve description verileri alınarak rapora eklenir.
     *
     * @param result Test sonucu nesnesi
     */
    @Override
    public void onTestStart(ITestResult result) {

        // Metod ismini kullanarak test aciklamasina baslik olarak ekliyoruz
        String testName = result.getMethod().getMethodName();
        //Test methodlarinin parantez icined description parametresiyle yazmis oldugumuz aciklamalari
        // dynamic olarak rapora ne testi oldugunu yansitabiliriz
        // mesela test caselerdeki test objective buraya yazilabilir
        String description = result.getMethod().getDescription(); // Metod açıklamasını kullanarak description alıyoruz

        try {
            ExtentReportUtils.createExtentTest(description, testName);
        }catch (Exception e){
            // Metod açıklamasını kullanarak description eklenmez ise nullPointer almamak icin method ismini rapora ekliyoruz
            ExtentReportUtils.createExtentTest(result.getName(), testName);
        }

    }

    /**
     * onTestSuccess==> sadece pass olan testlerden sonra bir kez cagrilir
     * Test başarılı olduğunda, başarılı mesajı eklenir.
     *
     * @param result Test sonucu nesnesi
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        /*
        Bu kod, Extent Reports ile bir testin başarıyla tamamlandığını belirten bir mesajı raporlamak için kullanılır.
        Mesaj, HTML biçimlendirmesi ile yeşil ve kalın bir şekilde görüntülenir ve sonuna bir yeşil onay işareti eklenir.
        Bu, test raporunda görsel olarak belirgin bir başarı işareti sağlar.
         */
        String passIsareti = "&#9989";
        ExtentReportUtils.extentTestPass("<span style='color:green; font-weight:bold'>"+result.getName()+" Testi başarıyla tamamlandı. </span>" + passIsareti);
    }

    /**
     * onTestFailure==> sadece fail olan testlerden sonra bir kez cagrilir
     * Test başarısız olduğunda, ekran görüntüsü alınır ve raporlama oluşturulur.
     *
     * @param result Test sonucu nesnesi
     */
    @Override
    public void onTestFailure(ITestResult result) {
        /*
        Bu kod, Extent Reports ile bir testin başarısız olduğunu belirten bir mesajı raporlamak için kullanılır.
        Mesaj, HTML biçimlendirmesi ile kırmızı ve kalın bir şekilde görüntülenir ve sonuna bir kırmızı çarpı işareti eklenir.
        Bu, test raporunda görsel olarak belirgin bir başarısızlık işareti sağlar.
         */
        // Fail mesajı ekleme
        String failIsareti = "&#10060";

        ExtentReportUtils.extentTestFail("<span style='color:red; font-weight:bold'>"+ result.getName()+" Testi başarısız oldu! </span>" + failIsareti);

        // rapora ekran görüntüsü ekleme
        try {
            ExtentReportUtils.addScreenShotToReport();
        } catch (Exception e) {
            ExtentReportUtils.extentTestInfo("Rapora ekran görüntüsü eklenirken hata meydana geldi");
        } finally {
            Driver.closeDriver();
        }
    }

    /**
     * onTestSkipped==> sadece skip olan (atlanan) testlerden sonra bir kez cagrilir.
     * Test atlandığında, bu durum rapora kaydedilir ve raporda belirtilir.
     *
     * @param result Test sonucu nesnesi
     */
    @Override
    public void onTestSkipped(ITestResult result) {
    /*
    Bu kod, Extent Reports ile bir testin atlandığını belirten bir mesajı raporlamak için kullanılır.
    Mesaj, HTML biçimlendirmesi ile sarı ve kalın bir şekilde görüntülenir ve sonuna yasak işareti eklenir.
    Bu, test raporunda görsel olarak belirgin bir atlama işareti sağlar.
    */
        // Skip mesajı ekleme
        String skipIsareti = "<img src='URL_TO_IMAGE' alt='skip_icon' style='width:16px;height:16px;'>";  // Simge olarak resim ekleniyor
        ExtentReportUtils.extentTestSkip("<span style='color:orange; font-weight:bold'> Hata nedeniyle Test atlandı! \n"+result.getName()+" testi tekrar calistirilacak</span>" + skipIsareti);

        // rapora ekran görüntüsü ekleme
        try {
            ExtentReportUtils.addScreenShotToReport();
        } catch (Exception e) {
            ExtentReportUtils.extentTestInfo("Rapora ekran görüntüsü eklenirken hata meydana geldi");
        } finally {
            Driver.closeDriver();
        }
    }


    /**
     * onfinish==> Tum testlerden sonra tek bir kez cagrilir
     * Böylece tüm testler bittiğinde raporlama kapatılır.
     *
     * @param context TestNG context nesnesi
     */
    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtils.flush();
    }


    // Her test için deneme (retry) sayısını takip eden bir Map. Test metodu ismiyle sayıyı eşleştiriyoruz.
    private static Map<String, Integer> retryCounts = new HashMap<>();

    // Test yeniden çalıştırma (retry) işlemi için kullanılır. Eğer test başarısız olursa, burada belirtilen sayı kadar yeniden çalıştırılır.
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        String testMethodName = result.getMethod().getMethodName();  // Test metodu ismini alır.
        // Eğer bu metod için daha önce bir deneme yapılmamışsa, 0 olarak başlatır.
        retryCounts.putIfAbsent(testMethodName, 0);
        int retryCount = retryCounts.get(testMethodName);  // Şu anki deneme sayısını alır.
        // Eğer deneme sayısı maksimumdan küçükse, yeniden çalıştırır.
        if (retryCount < maxRetryCount) {
            retryCount++;  // Deneme sayısını artırır.
            retryCounts.put(testMethodName, retryCount);  // Günceller.
            return true;  // Testi yeniden çalıştır.
        }
        return false;  // Test yeniden çalıştırılmayacak.
    }

    // Bu metod, TestNG'nin her test metodu için retry mekanizmasını eklemesi için kullanılır.

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Her test metoduna retry analyzer ekler. Bu sayede test başarısız olursa belirlenen sayıda yeniden çalıştırılır.
        annotation.setRetryAnalyzer(ExtentReportsListener.class);
    }
}
