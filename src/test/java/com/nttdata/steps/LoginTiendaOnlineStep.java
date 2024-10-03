package com.nttdata.steps;

import com.nttdata.page.LoginTiendapage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTiendaOnlineStep {
    WebDriver driver;

    public LoginTiendaOnlineStep(WebDriver driver){

        this.driver = driver;
    }

    public void ingresarUsuario(String usuario) {
        WebElement usuarioInput1 = driver.findElement(LoginTiendapage.userInput);
        usuarioInput1.sendKeys(usuario);
    }

    public void clickIniciosesion() {
        WebElement boton = driver.findElement(LoginTiendapage.iniciarSesion);
        boton.click();
    }
    public void typePassword(String clave) {
        WebElement usuarioInput1 = driver.findElement(LoginTiendapage.passInput);
        usuarioInput1.sendKeys(clave);
    }

    public void buttonIniciar() {
        WebElement boton = driver.findElement(LoginTiendapage.loginButton);
        boton.click();
    }

    public void escogerCategoria(String categoria) {
        WebElement categoriaInput = driver.findElement(LoginTiendapage.categoriaButton);
        categoriaInput.sendKeys(categoria);
        categoriaInput.click();
    }

    public void escogerSubcategoria(String subcategoria) {
        WebElement subcategoriaInput = driver.findElement(LoginTiendapage.subcategoriaButton);
        subcategoriaInput.sendKeys(subcategoria);
        subcategoriaInput.click();

    }
}
