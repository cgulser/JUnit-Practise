package practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05_Title_UrlTest {

    /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim

       */
    static WebDriver driver;

    // instance ve static olarak tanimladik bu sekilde nesne uretmeye gerek kalmadan her yerden erisilebilir olduk.
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        // Google'a gidelim ve sayda basligi icin assertion yapalim
        driver.get("http://www.google.com");
        String titleGoogle = driver.getTitle();
        Assert.assertTrue(titleGoogle.contains("Google"));
    }

    @Test
    public void test02() {
        //Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim

        driver.get("http://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();

    }
}
