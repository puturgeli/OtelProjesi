package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ReusableMetods {

  public static void hover(WebElement webElement) {
    Actions actions = new Actions(Driver.getDriver());
    actions.moveToElement(webElement).perform();
  }

  public static void waitfor(int second) {
    try {
      Thread.sleep(second * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static String tumSayfaScreenShot(String sayfaAdi) {

    TakesScreenshot tss = (TakesScreenshot) Driver.getDriver();
    File sayfaninResmi = new File("target/screenShot/" + sayfaAdi + ".jpg");
    File geciciSs = tss.getScreenshotAs(OutputType.FILE);
      String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + sayfaAdi+ ".png";
      File finalDestination = new File(target);
    try {
      FileUtils.copyFile(geciciSs, sayfaninResmi);
    } catch (IOException e) {
      e.printStackTrace();
    }
      return target;
  }

  public static void webElementScreenShot(WebElement webElement, String isim) {
    File webElementResim = new File("target/screenShot/" + isim + ".jpg");
    File geciciResim = webElement.getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(geciciResim, webElementResim);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void switchToWindow(String Title) {
    String actualHandle = Driver.getDriver().getWindowHandle();
    for (String handle : Driver.getDriver().getWindowHandles()) {
      Driver.getDriver().switchTo().window(handle);
      if (Driver.getDriver().getTitle().equals(Title)) {
        return;
      }
      Driver.getDriver().switchTo().window(actualHandle);
    }
  }

  public static List<String> getElementList(By locator) {
    List<WebElement> elemans = Driver.getDriver().findElements(locator);
    List<String> elemanString = new ArrayList<>();

    for (WebElement each : elemans) {
      if (!each.getText().isEmpty()) {
        elemanString.add(each.getText());
      }
    }
    return elemanString;
  }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeout) {
        //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver()).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(3))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(1));//Check for the element every 1 second
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }



}
