import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SaucedemoTest {

    public static final String URL = "https://www.saucedemo.com/";
    String userLogin = "standard_user";
    String userLockedLogin = "locked_out_user";
    String userPassword = "secret_sauce";
    String loginButtonId = "login-button";
    String menuButtonId = "react-burger-menu-btn";

    String item = "Sauce Labs Backpack";
    String item1 = "Sauce Labs Onesie";
    String addToCartItemButton = "add-to-cart-sauce-labs-backpack";
    String addToCartItem1Button = "add-to-cart-sauce-labs-onesie";
    String removeFromCartItemButton = "remove-sauce-labs-backpack";
    String removeFromCartItem1Button = "remove-sauce-labs-onesie";

    //Проверка входа с верными логином и паролем
    @Test
    public void loginSuccess() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get(URL);
        Thread.sleep(Long.parseLong("4000"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userLogin, userPassword, loginButtonId);

        // Проверка успешного входа по наличию меню
        assertTrue(driver.findElement(By.id(menuButtonId)).isDisplayed());

        driver.close();
    }

    //Проверка входа заблокированного пользователя
    @Test
    public void loginLockedUser() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get(URL);
        Thread.sleep(Long.parseLong("4000"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userLockedLogin, userPassword, loginButtonId);

        // Проверка наличия ошибки у заблокированного пользователя
        String errorMessage = driver.findElement(By.cssSelector(".error-message-container")).getText();
        assertTrue(errorMessage.contains("Epic sadface: Sorry, this user has been locked out."));
        driver.close();
    }

    //Проверка добавления товара в корзину из каталога
    @Test
    public void addToCartFromMainPage() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get(URL);
        Thread.sleep(Long.parseLong("4000"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userLogin, userPassword, loginButtonId);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickAddToCartItem(addToCartItemButton);

        // Проверка отображения товара в корзине
        mainPage.clickCart();
        assertTrue( driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + item + "']")).isDisplayed());

        driver.findElement(By.id(removeFromCartItemButton)).click();
        driver.close();
    }

    // Проверка соответствия цены в каталоге и в корзине
    @Test
    public void comparePrice() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get(URL);
        Thread.sleep(Long.parseLong("4000"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userLogin, userPassword, loginButtonId);

        MainPage mainPage = new MainPage(driver);

       String priceItem =  driver.findElement(By.xpath("//*[contains(@class, 'inventory_item_name')] [contains(text(), '"+ item +"')]/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']")).getText();
       String priceItem1 =  driver.findElement(By.xpath("//*[contains(@class, 'inventory_item_name')] [contains(text(), '"+ item1 +"')]/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']")).getText();

       System.out.println("Цена в каталоге: " + item + " - " + priceItem + ", " + item1 + " - " + priceItem1);

        mainPage.clickAddToCartItem(addToCartItemButton);
        mainPage.clickAddToCartItem(addToCartItem1Button);
        mainPage.clickCart();

        String priceItemInCart =  driver.findElement(By.xpath("//*[contains(@class, 'inventory_item_name')] [contains(text(), '"+ item +"')]/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']")).getText();
        String priceItem1InCart =  driver.findElement(By.xpath("//*[contains(@class, 'inventory_item_name')] [contains(text(), '"+ item1 +"')]/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']")).getText();

        System.out.println("Цена в корзине: " + item + " - " + priceItem + ", " + item1 + " - " + priceItem1);

        assertEquals(priceItem, priceItemInCart);
        assertEquals(priceItem1, priceItem1InCart);

        driver.findElement(By.id(removeFromCartItemButton)).click();
        driver.findElement(By.id(removeFromCartItem1Button)).click();
        driver.close();
    }
}
