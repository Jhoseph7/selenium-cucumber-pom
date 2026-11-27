package com.jhoseph.configuraciones;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver crearDriver() {
        ChromeOptions opciones = new ChromeOptions();

        if ("true".equalsIgnoreCase(System.getenv("HEADLESS"))) {
            opciones.addArguments(
                    "--headless=new",
                    "--window-size=1920,1080",
                    "--no-sandbox",
                    "--disable-dev-shm-usage");
            opciones.setPageLoadStrategy(PageLoadStrategy.EAGER);
        } else {
            opciones.addArguments("--start-maximized");
        }

        WebDriver driver = new ChromeDriver(opciones);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        return driver;
    }
}