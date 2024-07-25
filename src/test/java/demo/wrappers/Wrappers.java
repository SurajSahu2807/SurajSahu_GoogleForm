package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

     static ChromeDriver driver;

     public Wrappers(ChromeDriver driver){
        this.driver = driver;
     }

    public static Boolean Wrap_SendKeys(WebElement ele,String keys){
        try{
            ele.sendKeys(keys);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static String MinusNumberOfDays(){
        LocalDate date = LocalDate.now();
        LocalDate returnvalue = date.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = returnvalue.format(formatter);
        System.out.println("This date is 7 days less from the current date : " +dateString);
        return dateString;
    }

    public static String getCurrentTime(){
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeString = currentTime.format(formatter);
        System.out.println("Current time : " + timeString);
        return timeString;
    }

    

    public static Boolean NameField(WebElement NameEle , String keys){
        try{
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(NameEle));
            NameEle.sendKeys(keys);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void Click(WebElement ss){
        ss.click();
    }

    public static long EpoachConvertor(){
        long epoch = System.currentTimeMillis()/1000;
        return epoch;
    }

    public static void AnswerForAskingQuestion(WebElement NameEle,String keys){
        Wrappers.Wrap_SendKeys(NameEle,keys);
    }

    public static void NavigateToUrl(ChromeDriver driver , String url){
        if(!driver.getCurrentUrl().equals(url)){
            driver.get(url);
        }
    }

    public static void AddressedIntial(WebElement ss , By locator,String CourseName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(ss));
        List<WebElement> allElemenents = driver.findElements(locator);
        for(WebElement ele : allElemenents){
            if(ele.getText().equals(CourseName)){
                ele.click();
            }
        }
    }
   
}
