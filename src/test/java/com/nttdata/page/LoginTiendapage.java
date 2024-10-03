package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginTiendapage {
    public static By iniciarSesion = By.xpath("//div[@class='user-info']//span");
    public static By userInput = By.xpath("//input[@type='email']");
    public static By passInput = By.xpath("//input[@type='password']");
    public static By loginButton = By.xpath("//button[@type='submit']");
    public static By categoriaButton = By.xpath("//a[@class='dropdown-item' and @data-depth='0' and contains(., 'Clothes')]\n");
    public static By subcategoriaButton = By.xpath("//ul[@class='category-sub-menu']//a[contains(text(), 'Men')]\n");
}
