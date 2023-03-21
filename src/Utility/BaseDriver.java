package Utility;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;





public class BaseDriver {


    public static WebDriver driver; //BURADA WEBDRİVER CİNSİNDEN DRİVER TANIMLADIK PUBLİC STATİC OLARAK.VE BÖYLECE HER YERDE EXTEND YAPARAK KULLANABİLCEZ
    // VE DRİVER.GUİT VE DRİVER NEW CHROMEDRİVER KULLANABİLCEZ


    static {//
        KalanOncekileriKapat(); // ARKADA(HAFIZADA) KULLANILMAYAN PROGRAMLARI KAPATMAK İÇİN BİR KOMUT HAZIRLADIK,BÖYLECE BİLGİSAYARIN HAFIZASINI YORMAMIŞ OLURUZ

        Logger logger = Logger.getLogger("");//SİSTEMİN LOGLARINI KALDIRDIK // SİSTEME  YANİ OUTPUTA AİT,YANİ RUN YAPINCA ALTTA GÖRÜNEN KISMA  AİT BÜTÜN LOGLARI ÜRETEN OBJEYE /SERVİSE ULAŞTIM
        logger.setLevel(Level.SEVERE); // HERTÜRLÜ BİLGİYİ KONSOLDA GÖSTERMESİNİ ENGELLEDİK ,SADECE ERRORLARI GÖSTER
        // SLF4J MODÜLÜ SELENİUM UN KENDİ BİLGİLERİNİ SAKLAMA İLE İLGİLİ LOGLAMA YAPTIĞI BİR NOT TUTMA UYGULAMASIDIR,SELENİUM UN KENDİSİNDE OLMADIĞI İÇİN BİZ EKLEMELİYİZ
        // GEREKMEYEN LOGLARI KALDIRCAZ, SYSTEM.SETPROPERTY İLE  (LOG : WEBDİVER I RUN YAPTIĞIMIZ ZAMAN EN ALTTA GÖRÜNEN KIRMIZI KOD KALABALIKLARIDIR)
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // CHROMEDRIVER SESSİZ ÇALIŞMA ÖZELLİĞİ TRUE OLSUN//ÖNCE AYARLARI YAPI SONRA
        //CHROME ÇALIŞTIRIRIZ

        driver = new ChromeDriver(); // DRİVER NEW CHROME U ÜSTTEKİ SESSİZ ÇALIŞMA ÖZELLİĞİNİN  ALTINA YQZARIZ, TERSİ OLURSA ÜSTTEKİ FONKSİYON DEVREYE GİRMEZ,   ÇALIŞMAZ
        driver.manage().window().maximize();// TAM EKRAN MODUNA ALIR, EKRANI MAX YAPIYOR
        driver.manage().deleteAllCookies();//ÇEREZLERİ SİL
        Duration dr = Duration.ofSeconds(30); // SAYFAYI 30 SN BEKLER 30 SN DEN KISA YÜKLERSE 30 SN  DOLMASINI BEKLEMEZ
        driver.manage().timeouts().pageLoadTimeout(dr);
        // SADECE TÜM SAYFANIN KODLARININ BİLGİSAYARINIZA İNMESİ SÜRESİYLE İLGİLİ
        //BU EKLENMEZSE SELENİUM SAYFA YÜKLENENE KADAR (SONSUZA KADAR) BEKLER
        //30 SN SÜRESİNCE SAYFANIN YÜKLENMESİNİ BEKLE YÜKLENMEZSE HATA VER
        // EĞER 2 SN  DE YÜKLERSE 30 SN.BEKLEMEZ

        driver.manage().timeouts().implicitlyWait(dr);// BÜTÜN WEB ELEMENTLERİN  ELEMENT BAZINDA ,ELEMENTE ÖZEL  İŞLEM YAPILMADAN ÖNCE
        // HAZIR HALE GELMESİ İÇİN  VERİLEN MÜHLET YANİ SÜRE
        //  EĞER 2 SN DE YÜKLERSE  30 SN BEKLEMEZ
        // VERDİĞİMİZ "FİND ELEMENTİ " BULMASI İÇİN VERDİĞİMİZ MÜHLETTİR

    }


    public static void BekleKapat() {  //SİTEYİ İSTEDİĞİMİZ SÜRE DE ÇALIŞIP KAPANMASI İÇİN BEKLE KAPAT FONKSİYONU HAZIRLADIK
     //   MyFunc.Bekle(3);// bu fonksiyon direk verilen süre kadar programı yani intellijiyi  durduruyor,web sayfası ile ilgisi yok
        driver.quit();  //BÜTÜN AÇILMIŞ TARAYICILARI KAPATIR ,
        // DRİVER.CLOSE // İSE SADECE AKTİF OLANI KAPATIR (YANİ ÖNCEDEN AÇTIĞIMIZ EKRANIN ÜSTÜNDE BEKLEYEN PENCERELERDEN O ANDA KULLANILANI KAPATIR)
        //TEK BİR SAYFADA ÇALIŞINCA QUİT İLE CLOSE UN FARKI OLMAYACAKTIR
    }

    public static void KalanOncekileriKapat() {// HAFIZADA KULLANILMAYAN ARKA PLANDAKİ PROGRAMLARI KAPATMAK İÇİN FONKSİYON HAZIRLADIK

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

    public static void Wait() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}





