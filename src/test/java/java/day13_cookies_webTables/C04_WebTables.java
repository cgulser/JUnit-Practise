package java.day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    /* Bir Class olusturun D19_WebtablesHomework
  1. “https://demoqa.com/webtables” sayfasina gidin
  2. Headers da bulunan department isimlerini yazdirin
  3. 3.sutunun basligini yazdirin
  4. Tablodaki tum datalari yazdirin
  5. Tabloda kac cell (data) oldugunu yazdirin
  6. Tablodaki satir sayisini yazdirin
  7. Tablodaki sutun sayisini yazdirin
  8. Tablodaki 3.kolonu yazdirin
  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
  10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    */
   static List<WebElement> tumSatirlarWebelementList;
   static List<WebElement> basliklarWebelementiListesi;
     @Test
    public void test(){
         driver.get("https://demoqa.com/webtables");

         WebElement baslikSatiriElementi = driver.findElement(By.xpath("//div[@class='rt-tr']"));
         System.out.println( "Headersdeki  department isimleri :" +baslikSatiriElementi.getText());

         List<WebElement> basliklarWebelementiListesi= driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
         System.out.println("3.sutunun basligi : " + basliklarWebelementiListesi.get(2).getText());

         WebElement bodyTekWebelement = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
         System.out.println("Tablodaki tum datalar :" +bodyTekWebelement.getText());


         List<WebElement> tumDataWebelementList = driver.findElements(By.xpath("//div[@class='rt-td']"));
         System.out.println("Tabloda kac cell (data) var :" + tumDataWebelementList.size());

         List<WebElement> tumSatirlarWebelementList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
         System.out.println("Tablodaki satir sayisi :" + tumSatirlarWebelementList.size());

         //   sutun sayisi =  hucre sayisi / satir sayisi
         System.out.println("Tablodaki sutun sayisi :" + tumDataWebelementList.size()/tumSatirlarWebelementList.size());

         //3.kolon
         System.out.print("3.sutun : ");
         sutunYazdir(2);


         System.out.println("firstname Kierra-salary : ");
         ismeGoreMaasYazdir("Kierra");

         //3. satir 2.sutun yazdiralim..
         System.out.print("3.satir - 2.sutun : ");
         hucreYazdir(3,2);
     }


    public void sutunYazdir(int sutun) {

        int satirSayisi=tumSatirlarWebelementList.size();
        String dinamikXpath;
        WebElement geciciElement;
        System.out.println(basliklarWebelementiListesi.get(sutun-1).getText());

        for (int i=1 ; i<=satirSayisi ;i++){

            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+sutun+"]";  //i. satirin istenilen sutundaki degeri..
            geciciElement=driver.findElement(By.xpath(dinamikXpath));
            System.out.println(geciciElement.getText());
        }
    }

    public void ismeGoreMaasYazdir(String isim) {
        int satirSayisi=tumSatirlarWebelementList.size();
        String dinamikXpath;
        String satirdakiIsim;
        String salary;

        for (int i=1 ; i<satirSayisi ; i++){
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+1+"]";
            satirdakiIsim=driver.findElement(By.xpath(dinamikXpath)).getText();
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+5+"]";
            salary=driver.findElement(By.xpath(dinamikXpath)).getText();

            if (satirdakiIsim.equals(isim)){
                System.out.println(salary);
            }
        }

    }

    public void hucreYazdir(int satir, int sutun) {
        WebElement istenenHucre = driver.findElement(By.xpath("(//div[@class='rt-tr-group'][" + satir + "]//div[@class='rt-td'])[" + sutun + "]"));
        System.out.println(istenenHucre.getText());

    }
    
}
