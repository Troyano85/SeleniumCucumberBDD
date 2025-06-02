package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ShoppingPage;
import utilities.CommonFlows;


public class ShoppingStepDefinition {
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final CommonFlows commonFlows = new CommonFlows();

    @Given("Navego a la pagina de compras")
    // ir a la pagina prinsipal
    public void navegoPaginaShopping() {
        commonFlows.goToShoppingPage();
    }
    @Then("Verifico la ui de la pagina de compras")
    public void verificoUIShopping() {
        shoppingPage.verifyPage();
    }
    @When("hago click en el botón Añadir  para todos los artículos")
    public void adicionoItemsToCart() {
       shoppingPage.addAllItems();
    }

    @Then("Verifico que el checkout salga el numero {int}")
    public void verificoNumeroCheckout(int expectedCount) {
          shoppingPage.verifyCountCheckout(6);
    }

    @When("Cuando selecciono Z A del desplegable de ordenamiento")
    public void SeleccionoDesplegableDeOrdenamiento() {
         shoppingPage.orderItemsDescendantName();
    }

    @Then("Verifico que el primer nombre sea {string} y el último sea {string}")
    public void verificoPrimerNombreYElUltimo(String firstName, String lastName) {
        shoppingPage.verifyFirstLastName(firstName,lastName);
    }
    @When("Cuando selecciono Precio bajo a alto del desplegable de ordenamiento")
    public void SeleccionoItemsPrecioBajoAAlto() {
        shoppingPage.orderItemPriceHiLow();
    }

    @Then("verifico que el primer articulo tenga el precio de{string} y el ultimo articulo sea {string}")
    public void verificoQueElPrimerArticuloTengaElPrecioDeYElUltimoArticuloSea(String firstPrice, String  lastPrice) {
        shoppingPage.verifyFirstLastPrice(firstPrice, lastPrice);
    }



}
