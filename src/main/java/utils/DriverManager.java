package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {
    public static WebDriver Driver;

    public static void initDriver(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        Driver = new FirefoxDriver(capabilities);
        Driver.manage().window().maximize();
        Driver.get("https://www.cryptocompare.com/mining/calculator/btc");
        waitPageSource();
    }

    private static void waitPageSource(){
        try{
            for(int i = 0; i < 20; i++) {
                String currentSource = Driver.getPageSource();
                Thread.sleep(500);
                String newSource = Driver.getPageSource();
                if (currentSource.equals(newSource))
                    break;
                else
                    Thread.sleep(500);
            }
        }
        catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
