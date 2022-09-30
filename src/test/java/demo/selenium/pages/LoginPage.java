package demo.selenium.pages;

import demo.selenium.methods.Methods;

public class LoginPage {

    Methods methods;

    public LoginPage(){

        methods = new Methods();
    }

    public void loginPageControl(){

        methods.urlToBe("https://secure.migrosnext.com/login",30);
    }
}
