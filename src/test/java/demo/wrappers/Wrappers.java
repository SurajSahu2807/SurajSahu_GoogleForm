package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static Boolean Wrap_SendKeys(WebElement ele,String keys){
        try{
            ele.sendKeys(keys);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void Click(WebElement ss){
        ss.click();
    }

}
