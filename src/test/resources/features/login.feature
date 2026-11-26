# language: es
@allure.label.epic:Autenticacion
@allure.label.feature:Login
@allure.label.owner:jhoseph
Característica: Inicio de sesión
  Como cliente de la tienda
  Quiero iniciar sesión
  Para acceder a mi cuenta

  @critical @allure.label.story:LoginCorrecto @allure.label.testcase:TC-LOGIN-001
  Escenario: Login con credenciales correctas
    Dado que el usuario abre la página de login
    Cuando inicia sesión con las credenciales válidas
    Entonces se muestra la página de mi cuenta

  @normal @allure.label.story:LoginIncorrecto @allure.label.testcase:TC-LOGIN-002
  Escenario: Login con usuario válido y contraseña incorrecta
    Dado que el usuario abre la página de login
    Cuando inicia sesión con el usuario válido y contraseña "clave_incorrecta"
    Entonces se muestra el mensaje de error "Incorrect login or password"

  @normal @allure.label.story:LoginIncorrecto @allure.label.testcase:TC-LOGIN-003
  Esquema del escenario: Login con credenciales inexistentes
    Dado que el usuario abre la página de login
    Cuando inicia sesión con usuario "<usuario>" y contraseña "<contrasena>"
    Entonces se muestra el mensaje de error "Incorrect login or password"

    Ejemplos:
      | usuario             | contrasena       |
      | usuario_inexistente | clave_incorrecta |
      | otro_usuario_falso  | 123456           |