package demo.selenium.test;

import demo.selenium.driver.Driver;
import demo.selenium.pages.DashboardPage;
import demo.selenium.pages.GuestPage;
import demo.selenium.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class SeleniumTest extends Driver {


    GuestPage guestPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void test(){

        init();
        guestPage.pazarlamaSayfaKontrol();
        guestPage.clickLoginButton();
        loginPage.loginPageControl();
    }

    public void init(){

        guestPage = new GuestPage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }
}
