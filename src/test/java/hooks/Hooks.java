package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Logs;
import utilities.WebDriverProvider;

public class Hooks {

    private static WebDriver driver;
    @Before
    public static void before() {
        Logs.debug("Inicializando el driver");
        driver = new ChromeDriver();

        Logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        Logs.debug("Eliminando las cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Guardando el webDriver inicializado");
        new WebDriverProvider().set(driver);
    }
    @After
    public static void after(){
        Logs.debug("Matando el driver");
        driver.quit();
    }
}
