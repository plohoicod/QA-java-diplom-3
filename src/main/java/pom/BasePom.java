package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePom {

    public void wait(WebDriver driver, By by) {
        new WebDriverWait(driver, 3)
                .until(
                        ExpectedConditions.visibilityOfElementLocated(
                                by
                        ));
    }

    public void click(WebDriver driver, By by) {
        driver.findElement(by).click();
    }

    public void waitAndClick(WebDriver driver, By by) {
        wait(driver, by);
        click(driver, by);
    }

    public void setInput(WebDriver driver, By by, String input) {
        driver.findElement(by).sendKeys(input);
    }

    public boolean find(WebDriver driver, By by) {
        return driver.findElement(by).isDisplayed();
    }
}
