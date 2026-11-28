package com.jhoseph.paginas;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin extends PaginaBase {

    private static final String URL_LOGIN =
            "https://automationteststore.com/index.php?rt=account/login";
    private static final int INTENTOS_DE_CARGA = 3;

    private final By campoUsuario = By.id("loginFrm_loginname");
    private final By campoContrasena = By.id("loginFrm_password");
    private final By botonLogin = By.cssSelector("button[title='Login']");
    private final By mensajeError = By.cssSelector("div.alert-error");

    public PaginaLogin(WebDriver driver) {
        super(driver);
    }

    public void abrirLogin() {
        for (int intento = 1; intento <= INTENTOS_DE_CARGA; intento++) {
            Allure.step("Abrir la página de login (intento " + intento + " de " + INTENTOS_DE_CARGA + ")");
            abrir(URL_LOGIN);
            if (estaVisible(campoUsuario)) {
                return;
            }
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