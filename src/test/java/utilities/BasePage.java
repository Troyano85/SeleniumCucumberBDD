package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {
    protected WebDriver getDriver(){
        return new WebDriverProvider().get();
    }

    protected WebElement find(By locator){
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator){
        return getDriver().findElements(locator);
    }
    protected void sleep(int ms){
        try {
           Thread.sleep(ms);
        }catch (InterruptedException interruptedException){
            Logs.error("interruptedException: %s",interruptedException.getLocalizedMessage());
        }
    }

    public abstract void verifyPage();
}
