package com.jhoseph.steps;

import com.jhoseph.contextos.Contexto;
import com.jhoseph.paginas.PaginaLogin;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import com.jhoseph.paginas.PaginaCuenta;
import com.jhoseph.configuraciones.Configuracion;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStep {

    private final Contexto contexto;
    private PaginaLogin paginaLogin;

    public LoginStep(Contexto contexto) {
        this.contexto = contexto;
    }

    private PaginaLogin pagina() {
        if (paginaLogin == null) {
            paginaLogin = new PaginaLogin(contexto.getDriver());
        }
        return paginaLogin;
    }

    @Dado("que el usuario abre la página de login")
    public void abrirPaginaDeLogin() {
        pagina().abrirLogin();
    }

    @Cuando("inicia sesión con usuario {string} y contraseña {string}")
    public void iniciarSesion(String usuario, String contrasena) {
        pagina().iniciarSesion(usuario, contrasena);
    }

    @Entonces("se muestra el mensaje de error {string}")
    public void verificarMensajeDeError(String textoEsperado) {
        String mensaje = pagina().obtenerMensajeDeError();
        assertTrue(mensaje.contains(textoEsperado),
                "Se esperaba que el mensaje contuviera: " + textoEsperado
                        + " pero era: " + mensaje);

    }

    @Entonces("se muestra la página de mi cuenta")
    public void verificarPaginaDeCuenta() {
        PaginaCuenta cuenta = new PaginaCuenta(contexto.getDriver());
        assertTrue(cuenta.estaEnMiCuenta(),
                "No se llegó a la página de Mi Cuenta");
    }

    @Cuando("inicia sesión con las credenciales válidas")
    public void iniciarSesionConCredencialesValidas() {
        pagina().iniciarSesion(
                Configuracion.obtener("usuario.valido"),
                Configuracion.obtener("contrasena.valida"));
    }

    @Cuando("inicia sesión con el usuario válido y contraseña {string}")
    public void iniciarSesionConUsuarioValido(String contrasena) {
        pagina().iniciarSesion(Configuracion.obtener("usuario.valido"), contrasena);
    }

}