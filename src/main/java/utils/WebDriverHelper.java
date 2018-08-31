package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class WebDriverHelper {
    static WebElement findElement(By by){
        return findElement(DriverManager.Driver, by);
    }

    private static WebElement findElement(SearchContext el, By by) {
        WebDriverWait waiter = new WebDriverWait(DriverManager.Driver, 5);
        waiter.until( ExpectedConditions.presenceOfElementLocated(by) );
        WebElement element = el.findElement(by);
        try{element.sendKeys("");}catch(Exception ignored){} // try to make focus
        return element;
    }
}
