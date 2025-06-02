package pages;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginTitle = By.className("login_logo");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Override
    public void verifyPage() {
        Logs.info("Verificando la pagina de login");
        assertAll(
                () ->assertTrue(find(usernameInput).isDisplayed(),"El campo de usuario no se muestra."),
                () ->assertTrue(find(passwordInput).isDisplayed(),"El campo de contraseña no se muestra."),
                () ->assertTrue(find(loginButton).isDisplayed(),"El botón de login no se muestra."),
                () ->assertTrue(find(loginTitle).isDisplayed(),"el titulo no se muestra")
        );
    }
    public void fillForm(String username ,String password){
        Logs.info("Escribo el username");
        find(usernameInput).sendKeys(username);

        Logs.info("Escribo el password");
        find(passwordInput).sendKeys(password);

        Logs.info("Hago click en el boton de login");
        find(loginButton).click();
    }

    public void verifyErrorMessage(String text){
        Logs.info("Verifico mensaje de error");

        final var messageErrorElement = find(errorMessage);
        assertAll(
                () ->assertTrue(messageErrorElement.isDisplayed(),"mensaje de error no se muestra "),
                () ->assertEquals(messageErrorElement.getText(),text,"verificando mensaje de error")
        );
    }


}
