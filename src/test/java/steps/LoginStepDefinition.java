package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ShoppingPage;
import utilities.CommonFlows;


public class LoginStepDefinition {
    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final CommonFlows commonFlows = new CommonFlows();

    @Given("Navego a la pagina login")
    public void navegarPaginaLogin() {
        commonFlows.goToLoginPage();
    }
    @When("El usuario ingresa el nombre de usuario {string} y la contraseña {string}")
    public void rellenarFormularioLogin(String username, String password) {
        loginPage.fillForm(username,password);
    }

    @Then("El usuario debería ser redirigido a la página de shopping")
    public void elUsuarioDeberiaSerRedirigidoALaPaginaDeProductos() {
        shoppingPage.verifyPage();
    }

    @Then("El usuario debería ver un mensaje de error con el texto {string}")
    public void verificarMensajeErroneo(String text) {
        loginPage.verifyErrorMessage(text);
    }

    @Then("El usuario debería ver los elementos de la interfaz de usuario de la página de inicio de sesión")
    public void verificarPaginaLogin() {
        loginPage.verifyPage();
    }



}
