package com.jhoseph.configuraciones;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {

    private static final Properties PROPIEDADES = new Properties();

    static {
        try (InputStream entrada = Configuracion.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (entrada != null) {
                PROPIEDADES.load(entrada);
            }
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer config.properties", e);
        }
    }

    public static String obtener(String clave) {
        String variable = System.getenv(clave.toUpperCase().replace('.', '_'));
        if (variable != null && !variable.isBlank()) {
            return variable;
        }
        String valor = PROPIEDADES.getProperty(clave);
        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException("Falta la configuración '" + clave
                    + "'. Revisa src/test/resources/config.properties");
        }
        return valor;
    }
}