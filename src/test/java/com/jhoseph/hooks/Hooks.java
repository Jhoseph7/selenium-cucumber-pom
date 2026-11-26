package com.jhoseph.hooks;

import com.jhoseph.configuraciones.DriverFactory;
import com.jhoseph.contextos.Contexto;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class Hooks {

    private final Contexto contexto;

    public Hooks(Contexto contexto) {
        this.contexto = contexto;
    }

    @Before
    public void abrirNavegador() {
        contexto.setDriver(DriverFactory.crearDriver());
    }

    @After
    public void alTerminar(Scenario escenario) {
        WebDriver driver = contexto.getDriver();
        if (driver == null) {
            return;
        }
        try {
            if (escenario.isFailed()) {
                byte[] captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Captura al fallar", "image/png",
                        new ByteArrayInputStream(captura), "png");
                Allure.addAttachment("URL al fallar", "text/plain", driver.getCurrentUrl());
            }
        } finally {
            driver.quit();
        }
    }
}