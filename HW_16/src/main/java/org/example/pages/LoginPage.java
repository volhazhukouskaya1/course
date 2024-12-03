package org.example.pages;

import org.example.elements.InputLogin;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

public void login(String username, String password, String loginbuttonId) {
        new InputLogin(driver, username, password, loginbuttonId ).login(username, password, loginbuttonId);

}

}
