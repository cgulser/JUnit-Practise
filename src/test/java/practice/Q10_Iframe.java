package practice;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Q10_Iframe extends TestBase {
    /*
  // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
  // web sitesini maximize yapin
  // ikinci emojiye tıklayın
  // tüm ikinci emoji öğelerini tıklayın
  // parent iframe e geri donun
  // formu doldurun,(Formu istediğiniz metinlerle doldurun)
  //  apply button a basin
*/
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id ='emoojis']"));
        driver.switchTo().frame(iframe);
        WebElement secondEmoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();
        List<WebElement> emojiOgeler = driver.findElements(By.xpath("//div[@id='nature']//div//img"));
        // emojiOgeler.stream().forEach(x-> x.click());
        for(WebElement each : emojiOgeler){
            each.click();
        }
        Thread.sleep(3000);
        driver.switchTo().parentFrame();
        List<WebElement> textList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> text = new ArrayList<>(Arrays.asList("Bir", "iframe" , "sorusu", "bu", "kadar", "eglenceli", "olabilir","sizce de ", "oyle degil mi ?", "",""));
        for (int i=0; i< textList.size();i++){
            textList.get(i).sendKeys(text.get(i));
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
