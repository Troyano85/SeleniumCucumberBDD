package utilities;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class CommonFlows {
    private WebDriver getDriver(){
        return new WebDriverProvider().get();
    }
    public void goToLoginPage(){
        getDriver().get("https://www.saucedemo.com/");
    }
    public void goToShoppingPage(){
        goToLoginPage();
        new LoginPage().fillForm("standard_user","secret_sauce");
    }
}
