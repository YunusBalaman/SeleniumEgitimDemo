package demo.selenium.pages;

import demo.selenium.methods.Methods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class GuestPage {

    Methods methods;

    public GuestPage(){

        methods = new Methods();
    }

    public void pazarlamaSayfasinaGit(){

        methods.navigateRefresh();
    }

    public void pazarlamaSayfaKontrol(){

        methods.urlToBe("https://pazarlama.migrosnext.com/#/home",30);
        Assertions.assertTrue(methods.isElementVisible(By
                .cssSelector("header.menu-header button[data-cy=\"login-button\"]"),30));
        // header.menu-header button[data-cy="login-button"]
    }

    public void clickLoginButton(){

        By loginButtonBy = By.cssSelector("header.menu-header button[data-cy=\"login-button\"]");
        Assertions.assertTrue(methods.isElementClickable(loginButtonBy,30));
        methods.click(loginButtonBy);
    }


    //div[contains(@class,"pano-item") and not(@class="pano-item-div") and .//p[normalize-space(text())="Ürün Yönetimi"]]//a[text()="Yeni Ürün Işlemleri"]
}
