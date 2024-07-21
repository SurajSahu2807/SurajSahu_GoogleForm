package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

    

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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

    @FindBy(xpath = "//div[@class='vHW8K' and text()='Thanks for your response, Automation Wizard!']")
    WebElement FormResponsePage;

    @Test
    public void TestCase() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        NavigateToUrl();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(NameEle));        
        NameField(NameEle,"Crio Learner");
        long epoach = EpoachConvertor();
        NameField(QuestionForAutomation,"I want to be the best QA Engineer! " + epoach);
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
        wait.until(ExpectedConditions.elementToBeClickable(addressOpt));
        addressOpt.click();
        js.executeScript("window.scrollBy(0,300);");
        wait.until(ExpectedConditions.elementToBeClickable(CalenderEle));
        CalenderEle.sendKeys("23032024");
        js.executeScript("window.scrollBy(0,300);");
        t1.sendKeys("07");
        t2.sendKeys("30");
        SubmitBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(FormResponsePage));
        String ThanksFormResponse = FormResponsePage.getText();
        System.out.println(ThanksFormResponse);
    }

    static Boolean status = false;
    String url = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";

    public Boolean NameField(WebElement NameEle , String keys){
        status = Wrappers.Wrap_SendKeys(NameEle,keys);
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

    @AfterTest(enabled = true)
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.quit();

    }
}