package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BtcPage {
    public static WebElement hashingPower(){
        WebElement res = WebDriverHelper.findElement(By.xpath("//input[@ng-model='currentData.HashingPower']"));
        res.clear();
        return res;
    }

    public static WebElement powerConsumption(){
        WebElement res = WebDriverHelper.findElement(By.xpath("//input[@ng-model='currentData.PowerConsumption']"));
        res.clear();
        return res;
    }

    public static WebElement costPerKwh(){
        WebElement res =  WebDriverHelper.findElement(By.xpath("//input[@ng-model='currentData.CostPerkWh']"));
        res.clear();
        return res;
    }

    public static Select hashingUnit(){
        return new Select(WebDriverHelper.findElement(By.xpath("//select[@ng-model='currentData.HashingUnit']")));
    }

    public static double getConversationRate(){
        WebElement btcRateField = WebDriverHelper.findElement(By.xpath("//div[@class='calculated-for']/div"));
        String rateText = btcRateField.getText();
        return Double.parseDouble(rateText.substring(rateText.indexOf("$") + 1).trim());
    }

    public static double getActualProfit(){
        WebElement monthProfitField = WebDriverHelper.findElement(By.xpath("//div[text()='Profit per month']/../div[contains(@class, 'ng-binding')]"));
        String profitText = monthProfitField.getText();
        return Double.parseDouble(profitText.substring(profitText.indexOf("$") + 1).trim());
    }
}
