package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wrappermet {

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
