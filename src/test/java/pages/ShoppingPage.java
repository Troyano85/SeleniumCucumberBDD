package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.BasePage;
import utilities.Logs;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingPage extends BasePage {
    private final By mainTitle = By.className("app_logo");
    private final By productsTitle = By.cssSelector("span[data-test='title']");
    private final By selectProducts = By.cssSelector("select[data-test='product-sort-container']");
    private final By inventoryList = By.cssSelector("div[data-test='inventory-list']");
    private final By countCheckout = By.cssSelector("span[data-test='shopping-cart-badge']");

    private final By addToCartButtons = By.xpath("//button[text()='Add to cart']");
    private final By itemImages = By.cssSelector("img[class='inventory_item_img']");
    private final By itemNames = By.cssSelector("div[data-test='inventory-item-name']");
    private final By itemPrices = By.cssSelector("div[data-test='inventory-item-price']");

    @Override
    public void verifyPage() {
        Logs.info("Verificando la ui de la pagina de  shoppping");
        assertAll(
                () -> assertTrue(find(mainTitle).isDisplayed(),"el titulo principal no se muestra"),
                () -> assertTrue(find(productsTitle).isDisplayed(),"el titulo Productos no se muestra"),
                () -> assertTrue(find(selectProducts).isDisplayed(),"El selector de productos no se muestra"),
                () -> assertTrue(find(inventoryList).isDisplayed(),"La lista de inventario no se muestra")
        );
    }
    public void addAllItems(){
        Logs.info("Agregando items al carrito");
        final var list = findAll(addToCartButtons);

        for (var webElemt:list) {
         webElemt.click();
         sleep(1500);
        }
    }
    public void verifyCountCheckout(int expectedCount) {
        final var itemsCart = find(countCheckout).getText();
        int actualItemCount = Integer.parseInt(itemsCart);

        assertEquals(expectedCount,actualItemCount,
                "El número de items en el carrito no coincide.");
    }

    public void orderItemsDescendantName(){
        Logs.info("Ordeno los items de manera desendente por su nombre");
        final var selectElement = find(selectProducts);
        final var select = new Select(selectElement);

        select.selectByValue("za");
        Logs.info("esperando que se reordene la pagina");
        sleep(1500);

    }
    public void verifyFirstLastName(String firstName,String lastName){
        Logs.info("identificando el primer y ultimo elemento");
        final var list = findAll(itemNames);
        final var firstTitle = list.get(0).getText();
        final var lastTitle = list.get(list.size()-1).getText();

        assertAll(
                () ->assertEquals(firstTitle,firstName,"primer item incorrecto"),
                () ->assertEquals(lastTitle,lastName,"Ultimo item incorrecto")
        );
    }
    public void orderItemPriceHiLow(){
        Logs.info("Ordeno los items de manera acendente por su precio");
        final var selectElement = find(selectProducts);
        final var select = new Select(selectElement);

        select.selectByValue("lohi");
        Logs.info("esperando que se reordene la pagina");
        sleep(1500);
    }
    public void verifyFirstLastPrice(String firstPrice, String lastPrice){
        Logs.info("Verificando el primer y el ultimo precio");
        final var list = findAll(itemPrices);
        final var primerPrecio = list.get(0).getText();
        final var ultimoPrecio = list.get(list.size()-1).getText();

        assertAll(
                () -> assertEquals(primerPrecio,firstPrice,"Primer item incorrecto"),
                () -> assertEquals(ultimoPrecio,lastPrice,"Ultimo item incorrecto")
        );

    }



}
