package ikiNhaber_CaseStudy.utilities;

import org.testng.annotations.DataProvider;
public class DataProviderUtils {
    /*

Boundary Value Analysis (BVA), yazılım testlerinde kullanılan bir kara kutu test tekniğidir.
Bu yöntem, bir sistemin ya da bileşenin girdileri üzerinde en düşük ve en yüksek sınır
noktalarını test etmeye odaklanır. Amacı, sınır değerlerinde veya sınırların hemen ötesinde
ortaya çıkabilecek hataları yakalamaktır.
 Bu sınır noktaları, hataların en sık görüldüğü yerler olduğu için önemlidir
     */


    @DataProvider(name = "positiveTestData")
    public static Object[][] provideBoundaryValueTestData() {
        return new Object[][] {
                { "18" },    // Alt sınır
                { "30" },  // Geçerli yaş
                { "100" },   // Üst sınır
        };
    }

    @DataProvider(name = "negativeTestData")
    public static Object[][] provideNegativeTestData() {
        return new Object[][] {
                { "17" },   // Alt sınırın altı
                { "101" }   // Üst sınırın üstü
        };
    }

    @DataProvider(name = "invalidTestData")
    public static Object[][] provideinvalidTestData() {
        return new Object[][] {
                { "ali" },   // invalidTestData
                { "?" },
                { "-5" }
        };
    }
}