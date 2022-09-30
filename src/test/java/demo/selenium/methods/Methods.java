package demo.selenium.methods;

import demo.selenium.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class Methods {

    private static final Logger logger = LogManager.getLogger(Methods.class);
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
        logger.info(by.toString() + " elementine " + text + " texti yazıldı");
    }

    public void click(By by){

        findElementWait(by).click();
        logger.info(by.toString() + " elementine tıklandı");
    }

    public String getText(By by){

        return findElementWait(by).getText();
    }

    public void clear(By by){

        findElementWait(by).clear();
        logger.info(by.toString() + " elementinin input alanı temizlendi");
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

    public void urlToBe(String url, long timeout){

        setFluentWait(timeout).until(ExpectedConditions.urlToBe(url));
    }

    public void navigateTo(String url){

        webDriver.navigate().to(url);
    }

    public void navigateRefresh(){

        webDriver.navigate().refresh();
    }

    public boolean isElementVisible(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementClickable(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
