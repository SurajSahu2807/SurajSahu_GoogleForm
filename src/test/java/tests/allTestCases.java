package tests;

import Pages.AllContents;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class allTestCases {
    static WebDriver driver;

    @BeforeTest
    public void InitializeBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\Folder\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @AfterTest(enabled = false)
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
    }

    @FindBy(xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement NameEle;

    @FindBy(xpath = "//*[@id='mG61Hd']/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/textarea")
    WebElement QuestionForAutomation;

    @FindBy(xpath = "//div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']")
    List<WebElement> options;

    @FindBy(xpath = "(//div[@class='AB7Lab Id5V1'])[3]")
    WebElement RadioBtn;

    @FindBy(xpath = "//div[@class='eBFwI']//span[@class='aDTYNe snByac n5vBHf OIC90c']")
    List<WebElement> CoursesEle;

    @FindBy(xpath = " //div[@class='uHMk6b fsHoPb']")
    List<WebElement> CoursesEleBtn;

    @FindBy(xpath = "//span[@class='vRMGwf oJeWuf' and text()='Choose']")
    WebElement addressEle;

    @FindBy(xpath = "(//span[text()='Ms'])[2]")
    WebElement addressOpt;

    @FindBy(xpath = "//div[@class='aXBtI Wic03c' and 'Xb9hP']//input[@type='date']")
    WebElement CalenderEle;

    @FindBy(xpath = "(//div[@class='aXBtI Wic03c']//input[@type='text'])[2]")
    WebElement t1;

    @FindBy(xpath = "(//div[@class='aXBtI Wic03c']//input[@type='text'])[3]")
    WebElement t2;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement SubmitBtn;

    @Test
    public void TestCase() throws InterruptedException {
        AllContents ac = new AllContents(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ac.NavigateToUrl();
        ac.NameField(NameEle,"Suraj Sahu");
        long epoach = ac.EpoachConvertor();
        ac.NameField(QuestionForAutomation,"I want to be the best QA Engineer! " + epoach);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,300);");
        for(WebElement e : options){
            if(e.getText().equals("6 - 10")){
                RadioBtn.click();
            }
        }
        for(int i=0;i<CoursesEle.size();i++){
            if(CoursesEle.get(i).getText().equals("Selenium")){
                CoursesEleBtn.get(i).click();
            }
        }
        addressEle.click();
        Thread.sleep(2000);
        addressOpt.click();
        js.executeScript("window.scrollBy(0,300);");
        CalenderEle.sendKeys("23032024");
        js.executeScript("window.scrollBy(0,300);");
        t1.sendKeys("13");
        t2.sendKeys("35");
        SubmitBtn.click();
    }
}