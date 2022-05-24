package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q03_CssLocator_MethodCreation {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted

    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        createButtons(driver,100);
        deleteButtonsAndValidate(driver,60);

    }

    private static void createButtons(WebDriver driver, int eklenecekSayi) {
        WebElement addButton = driver.findElement(By.xpath("//*[@onclick ='addElement()']"));
        for (int j = 0; j < eklenecekSayi; j++) {
            addButton.click();
        }
    }


    private static void deleteButtonsAndValidate(WebDriver driver, int number) {
        List<WebElement> elements = driver.findElements(By.cssSelector("[onclick= 'deleteElement()']"));
        int sizebeforeDelete = elements.size();

        List<WebElement> buttonsDelete = driver.findElements(By.cssSelector("[onclick= 'deleteElement()']"));
        int sayac= 0;

        for (WebElement w :buttonsDelete){ //siecegim webelemente click yapiyorum
            sayac ++;
            if(sayac>number){
                break;
            }
            w.click();
        }

        List<WebElement> elementsAfter = driver.findElements(By.cssSelector("[onclick= 'deleteElement()']"));
        int sizeafterDelete = elementsAfter.size();//sildikten sonra kalanlar

        if((sizebeforeDelete-number)==sizeafterDelete){
            System.out.println("sizeafterDelete = " + sizeafterDelete);
            System.out.println("SUCCESS");
        }else
            System.out.println("FAIL!");


    }





}
