package org.example.pages;

import org.example.elements.InputItemMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

   public void clickItem(String label){
        new InputItemMainPage(driver, label).clickItem(label);
   }

   public void clickAddToCartItem(String addToCartItemButton){
        new InputItemMainPage(driver, addToCartItemButton).clickItemAddToCart(addToCartItemButton);
   }

   public void clickCart(){
        new InputItemMainPage(driver);
       driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
   }


}
