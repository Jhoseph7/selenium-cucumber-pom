package com.jhoseph.contextos;

import org.openqa.selenium.WebDriver;

public class Contexto {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}