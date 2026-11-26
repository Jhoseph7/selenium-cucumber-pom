package com.jhoseph.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaCuenta extends PaginaBase {

    private final By titulo = By.cssSelector("span.maintext");

    public PaginaCuenta(WebDriver driver) {
        super(driver);
    }

    public boolean estaEnMiCuenta() {
        return estaVisible(titulo)
                && obtenerTexto(titulo).toUpperCase().contains("MY ACCOUNT");
    }
}