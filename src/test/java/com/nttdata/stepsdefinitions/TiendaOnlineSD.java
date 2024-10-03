package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginTiendaOnlineStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class TiendaOnlineSD {
    private WebDriver driver;
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
        screenShot();


    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
    }

    @Then("valido en el popup la confirmacion del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }
}
