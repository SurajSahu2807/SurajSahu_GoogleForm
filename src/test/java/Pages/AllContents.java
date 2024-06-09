package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AllContents {

    WebDriver driver;
    String url = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";
    public AllContents(WebDriver driver){
        this.driver = driver;
    }

    static Boolean status = false;

    public Boolean NameField(WebElement NameEle , String keys){
        status = Wrappermet.Wrap_SendKeys(NameEle,keys);
        return status;
    }

    public void NavigateToUrl(){
        if(!driver.getCurrentUrl().equals(this.url)){
            driver.get(this.url);
        }
    }

    public long EpoachConvertor(){
        long epoch = System.currentTimeMillis()/1000;
        return epoch;
    }







}
