package netfinansUI.hesapBakiyeleri;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pagesElements.HesapBakiyeleriPageElements;
import pagesElements.LoginPageElements;
import pagesElements.MainPageElements;
import pagesElements.SideBarElements;
import utilities.BaseDriver;
import utilities.Tools;


public class C2421 extends BaseDriver {

    WebDriver driver;
    LoginPageElements loginPageElements;
    HesapBakiyeleriPageElements hesapBakiyeleriPageElements;
    MainPageElements mainPageElements;
    SideBarElements sideBarElements;

    @Parameters("browser")
    @BeforeMethod(groups = {"smokeTest", "regressionTest"})
    void setDriver(@Optional("browser") String browser){
        System.out.println("Browser name = "+browser);
        BaseDriver.threadBrowserName.set(browser);
        this.driver = getDriver();
        loginPageElements = new LoginPageElements(driver);
        hesapBakiyeleriPageElements = new HesapBakiyeleriPageElements(driver);
        mainPageElements = new MainPageElements(driver);
        sideBarElements = new SideBarElements(driver);
    }
    @AfterMethod
    void teardown() {
        BaseDriver.DriverQuit();
    }

    @Test
    void C2421_Hesap_Bakiyeleri() throws InterruptedException {
        Tools.navigateApplications(driver,"https://otomasyon.netfinans.com");
        loginPageElements.InvalidLogin();
        mainPageElements.clickFunction(mainPageElements.getBtnNetekstreModulu());
        sideBarElements.clickFunction( sideBarElements.getBtnHesapBakiyeleri());
        Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", hesapBakiyeleriPageElements.getBtnListele());
        Thread.sleep(1000);
        hesapBakiyeleriPageElements.clickFunction(hesapBakiyeleriPageElements.getDropDownPagination());
        Thread.sleep(1000);
        hesapBakiyeleriPageElements.fetchAllDataAsList(hesapBakiyeleriPageElements.getListPaginationOptions(), "10 / sayfa,25 / sayfa,50 / sayfa,100 / sayfa,");
        Thread.sleep(1000);

    }



}
