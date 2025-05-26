package com.mycompany.projetoa3_selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimularCompraTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Test
    @Order(1)
    public void testLoginInvalido() {
        driver.get("https://www.saucedemo.com/");
        pause(2000);

        driver.findElement(By.name("user-name")).sendKeys("usuario_invalido");
        pause(2000);

        driver.findElement(By.name("password")).sendKeys("senha_errada");
        pause(2000);

        driver.findElement(By.className("submit-button")).click();
        pause(2000);

        WebElement erro = driver.findElement(By.cssSelector("[data-test='error']"));
        assertTrue(erro.isDisplayed(), "Mensagem de erro deveria ser exibida com login inválido");
    }

    @Test
    @Order(2)
    public void testLoginValidoECompra() {
        driver.get("https://www.saucedemo.com/");
        pause(2000);

        driver.findElement(By.name("user-name")).clear();
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        pause(1000);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        pause(1000);

        driver.findElement(By.className("submit-button")).click();
        pause(2000);

        assertTrue(driver.getCurrentUrl().contains("inventory"), "Deveria estar na tela de inventário");
        pause(1000);

        WebElement filtroSelect = driver.findElement(By.className("product_sort_container"));
        new Select(filtroSelect).selectByValue("hilo");
        pause(1000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        pause(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        pause(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        pause(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        pause(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        pause(1000);

        driver.findElement(By.className("shopping_cart_link")).click();
        pause(2000);


        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        pause(2000);
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        pause(2000);


        String pageSource = driver.getPageSource();
        assertFalse(pageSource.contains("Sauce Labs Backpack"), "Backpack deveria ter sido removido");
        assertFalse(pageSource.contains("Sauce Labs Onesie"), "Onesie deveria ter sido removido");

        driver.findElement(By.id("checkout")).click();
        pause(1000);

        driver.findElement(By.id("first-name")).sendKeys("José");
        pause(1500);
        driver.findElement(By.id("last-name")).sendKeys("Mirim");
        pause(1500);
        driver.findElement(By.id("postal-code")).sendKeys("Anhembi Morumbi");
        pause(1000);

        driver.findElement(By.id("continue")).click();
        pause(1000);
        driver.findElement(By.id("finish")).click();
        pause(2000);

        WebElement mensagemFinal = driver.findElement(By.className("complete-header"));
        assertEquals("Thank you for your order!", mensagemFinal.getText());
    }
}