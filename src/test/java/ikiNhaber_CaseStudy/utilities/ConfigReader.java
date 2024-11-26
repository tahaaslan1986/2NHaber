package ikiNhaber_CaseStudy.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Javadan gelen bir classtir--> properties dosyalarindan bilgi almak icin kullanilir

    //static yapmamizin sebebi methoda direkt ulasim saglayabilmek(obje olusturmak zorunda kalmiyoruz)
    public static String getProperty(String key){
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }





}
