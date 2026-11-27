package com.jhoseph.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin extends PaginaBase {

    private static final String URL_LOGIN =
            "https://automationteststore.com/index.php?rt=account/login";

    private final By campoUsuario = By.id("loginFrm_loginname");
    private final By campoContrasena = By.id("loginFrm_password");
    private final By botonLogin = By.cssSelector("#loginFrm button.btn-orange");
    private final By mensajeError = By.cssSelector("div.alert-error");

    public PaginaLogin(WebDriver driver) {
        super(driver);
    }

    public void abrirLogin() {
        abrir(URL_LOGIN);
        if (!estaVisible(campoUsuario)) {
            driver.navigate().refresh();
        }
    }

    public void iniciarSesion(String usuario, String contrasena) {
        escribir(campoUsuario, usuario);
        escribir(campoContrasena, contrasena);
        hacerClic(botonLogin);
    }

    public boolean hayMensajeDeError() {
        return estaVisible(mensajeError);
    }

    public String obtenerMensajeDeError() {
        return obtenerTexto(mensajeError);
    }
}