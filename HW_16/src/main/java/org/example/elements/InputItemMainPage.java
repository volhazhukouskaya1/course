package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputItemMainPage {

    private static final String ITEM_NAME = "\"//*[contains(@Class,'inventory_item_name')][contains(text(),%s)]";

    WebDriver driver;
    String label;
    String addToCartItemButton;

    public InputItemMainPage(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public InputItemMainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickItem(String label){
        driver.findElement(new By.ByXPath(String.format(ITEM_NAME, label))).click();
    }

    public void clickItemAddToCart(String addToCartItemButton){
        driver.findElement(By.id(addToCartItemButton)).click();
    }

}
