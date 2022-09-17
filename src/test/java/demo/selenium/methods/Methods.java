package demo.selenium.methods;

import demo.selenium.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Methods {

    WebDriver webDriver;
    FluentWait<WebDriver> fluentWait;
    JavascriptExecutor jsDriver;

    public Methods(){

        this.webDriver = Driver.webDriver;
        fluentWait = setFluentWait(20);
        jsDriver = (JavascriptExecutor) webDriver;
    }

    public FluentWait<WebDriver> setFluentWait(long timeout){

      return new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By by){

        return webDriver.findElement(by);
    }

    public WebElement findElementWait(By by){

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void sendKeys(By by, String text){

        findElementWait(by).sendKeys(text);
    }

    public void click(By by){

        findElementWait(by).click();
    }

    public String getText(By by){

        return findElementWait(by).getText();
    }

    public void clear(By by){

        findElementWait(by).clear();
    }

    public String getAttribute(By by, String attribute){

        return findElementWait(by).getAttribute(attribute);
    }

    public void hoverElement(By by) {

        WebElement webElement = findElementWait(by);
        Actions hoverAction = new Actions(webDriver);
        hoverAction.moveToElement(webElement).build().perform();
    }

    public void scrollElement(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void scrollElementCenter(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);
    }

}
