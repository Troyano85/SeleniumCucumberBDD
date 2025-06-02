Feature: Autenticación de Usuarios

  Background: Acceso a la página de inicio de sesión
    Given Navego a la pagina login

  @regression
  Scenario: Inicio de sesión exitoso
    When El usuario ingresa el nombre de usuario "standard_user" y la contraseña "secret_sauce"
    Then El usuario debería ser redirigido a la página de shopping
  @regression
  Scenario: Inicio de sesión con credenciales incorrectas
    When El usuario ingresa el nombre de usuario "locked_out_user" y la contraseña "secret_sauce"
    Then El usuario debería ver un mensaje de error con el texto "Epic sadface: Sorry, this user has been locked out."
  @regression
  Scenario: Verificación de la interfaz de usuario de la página de inicio de sesión
    Then El usuario debería ver los elementos de la interfaz de usuario de la página de inicio de sesión