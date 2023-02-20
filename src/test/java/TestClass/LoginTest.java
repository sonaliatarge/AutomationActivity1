package TestClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    LoginTest(){

        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        homePage=new HomePage(getDriver());
        loginPage=new LoginPage(getDriver());
    }
    @Test
    public void verifyLogin(){
        SoftAssert softAssert=new SoftAssert();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        softAssert.assertEquals(homePage.homePageTitle(),"Newly Launched Products" , "Newly Launched Products string should match");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }
}

