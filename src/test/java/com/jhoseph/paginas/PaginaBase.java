package com.jhoseph.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaginaBase {

    protected WebDriver driver;
    private final WebDriverWait espera;

    public PaginaBase(WebDriver driver) {
        this.driver = driver;
        this.espera = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrir(String url) {
        driver.get(url);
    }

    public String obtenerTitulo() {
        return driver.getTitle();
    }

    protected WebElement esperarVisible(By localizador) {
        return espera.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }

    protected void hacerClic(By localizador) {
        espera.until(ExpectedConditions.elementToBeClickable(localizador)).click();
    }

    protected void escribir(By localizador, String texto) {
        WebElement campo = esperarVisible(localizador);
        campo.clear();
        campo.sendKeys(texto);
    }

    protected String obtenerTexto(By localizador) {
        return esperarVisible(localizador).getText();
    }

    protected boolean estaVisible(By localizador) {
        try {
            esperarVisible(localizador);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}