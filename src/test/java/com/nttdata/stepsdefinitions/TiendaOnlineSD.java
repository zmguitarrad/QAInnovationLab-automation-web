package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginTiendaOnlineStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

import static org.junit.Assert.assertEquals;

public class TiendaOnlineSD {
    private WebDriver driver;

    private LoginTiendaOnlineStep inventorySteps(WebDriver driver){
        return new LoginTiendaOnlineStep(driver);
    }

    @Given("estoy en la pagina de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) throws InterruptedException {
        LoginTiendaOnlineStep tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.clickIniciosesion();
        tiendastep.ingresarUsuario(usuario);
        tiendastep.typePassword(clave);
        tiendastep.buttonIniciar();
        Thread.sleep(1000);
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        LoginTiendaOnlineStep tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.escogerCategoria(categoria);
        tiendastep.escogerSubcategoria(subcategoria);
        tiendastep.elegirElemento();
        screenShot();


    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int elemento) throws InterruptedException {
        LoginTiendaOnlineStep tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.anadirelemento(elemento);
        tiendastep.comprarElem();
        Thread.sleep(1000);
    }

    @Then("valido en el popup la confirmacion del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        LoginTiendaOnlineStep tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.validarEnvio();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() throws InterruptedException {
        LoginTiendaOnlineStep tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.confirmarValor();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        LoginTiendaOnlineStep tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.finalizarCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
;
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }
}
