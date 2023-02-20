package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testutil.Utility;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public Properties prop;

    public TestBase(){
        //FileReader fr= null;
        prop=new Properties();
        try{
            FileReader fr=new FileReader(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");
            prop.load(fr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void initialization(){
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("WebDriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/browsers/chromedriver_win32 (1)/chromedriver.exe");
            //driver=new ChromeDriver();
        }else if (browserName.equals("edge")){
            System.setProperty("WebDriver.edge.driver",System.getProperty("user.dir")+"/src/main/resources/browsers/edgedriver_win64 (1)/msedgedriver.exe");
            //driver=new EdgeDriver();
        }else {
            System.out.println("please select correct browser name");
        }
        getDriver().navigate().to(prop.getProperty("url"));
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD_TIMEOUT));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICITE_WAIT));

    }

}
