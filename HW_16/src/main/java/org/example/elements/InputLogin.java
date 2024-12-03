package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputLogin {

    WebDriver driver;
    String username;
    String password;
    String loginbuttonId;

    public InputLogin(WebDriver driver, String username, String password, String loginbuttonId) {
        this.driver = driver;
        this.username = username;
        this.password = password;
        this.loginbuttonId = loginbuttonId;
    }

    public void login(String username, String password, String loginbuttonId) {
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id(loginbuttonId)).click();
    }

}
