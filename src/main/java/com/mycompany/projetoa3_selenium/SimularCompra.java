package com.mycompany.projetoa3_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class SimularCompra {

    public static void janjaComprando() throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement usuarioInvalido = driver.findElement(By.name("user-name"));
        Thread.sleep(2000);
        usuarioInvalido.clear();  // limpa o campo antes de digitar
        usuarioInvalido.sendKeys("Janja Lula da Silva");
        Thread.sleep(3000);

        WebElement senhaErrada = driver.findElement(By.name("password"));
        senhaErrada.clear();  // limpa o campo antes de digitar
        senhaErrada.sendKeys("Roubando o INSS");
        Thread.sleep(3000);

        WebElement botaoError = driver.findElement(By.className("submit-button"));
        botaoError.click();
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.name("user-name"));
        Thread.sleep(2000);
        search.clear(); 
        search.sendKeys("standard_user");
        Thread.sleep(3000);

        WebElement senha = driver.findElement(By.name("password"));
        senha.clear(); 
        senha.sendKeys("secret_sauce");
        Thread.sleep(3000);

        WebElement botao = driver.findElement(By.className("submit-button"));
        botao.click();
        Thread.sleep(2000);

        WebElement botaoMenu = driver.findElement(By.id("react-burger-menu-btn"));
        botaoMenu.click();
        Thread.sleep(2000);

        WebElement botaoFecharMenu = driver.findElement(By.id("react-burger-cross-btn"));
        botaoFecharMenu.click();
        Thread.sleep(2000);

        WebElement menuFiltro = driver.findElement(By.className("product_sort_container"));
        menuFiltro.click();
        Thread.sleep(2000);

        Select filtro = new Select(menuFiltro);
        filtro.selectByValue("hilo");
        Thread.sleep(2000);

        WebElement compraBotao1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        compraBotao1.click();
        Thread.sleep(2000);

        WebElement compraBotao2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        compraBotao2.click();
        Thread.sleep(2000);

        WebElement compraBotao3 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        compraBotao3.click();
        Thread.sleep(2000);

        WebElement compraBotao4 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        compraBotao4.click();
        Thread.sleep(2000);

        WebElement compraBotao5 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        compraBotao5.click();
        Thread.sleep(2000);

        WebElement compraBotao6 = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
        compraBotao6.click();
        Thread.sleep(2000);

        WebElement carrinhoCompras = driver.findElement(By.className("shopping_cart_link"));
        carrinhoCompras.click();
        Thread.sleep(2000);

        WebElement removendoCompra1 = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removendoCompra1.click();
        Thread.sleep(2000);

        WebElement removendoCompra2 = driver.findElement(By.id("remove-sauce-labs-onesie"));
        removendoCompra2.click();
        Thread.sleep(2000);

        WebElement checkoutCompra = driver.findElement(By.id("checkout"));
        checkoutCompra.click();
        Thread.sleep(2000);

        WebElement primeiroNome = driver.findElement(By.id("first-name"));
        Thread.sleep(1000);
        primeiroNome.sendKeys("Janja");
        Thread.sleep(2000);

        WebElement ultimoNome = driver.findElement(By.id("last-name"));
        Thread.sleep(1000);
        ultimoNome.sendKeys("Gastando");
        Thread.sleep(2000);

        WebElement codigoPostal = driver.findElement(By.id("postal-code"));
        Thread.sleep(1000);
        codigoPostal.sendKeys("Palácio da Alvorada kk");
        Thread.sleep(2000);

        WebElement continueFinalizacao = driver.findElement(By.id("continue"));
        continueFinalizacao.click();
        Thread.sleep(2000);

        WebElement finalizacao = driver.findElement(By.id("finish"));
        finalizacao.click();
        Thread.sleep(2000);

        WebElement backHome = driver.findElement(By.id("back-to-products"));
        backHome.click();
        Thread.sleep(5000);

        driver.quit();
    }
}
