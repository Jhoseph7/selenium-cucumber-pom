package com.jhoseph.configuraciones;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver crearDriver() {
        ChromeOptions opciones = new ChromeOptions();
        opciones.addArguments("--start-maximized");

        return new ChromeDriver(opciones);
    }
}