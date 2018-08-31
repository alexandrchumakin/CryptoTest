import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.BtcPage;
import utils.Crypto;
import utils.DriverManager;
import utils.Generator;

import java.util.Map;

public class CryptoTest {
    @Before
    public void setUp(){
        DriverManager.initDriver();
    }

    @After
    public void tearDown(){
        DriverManager.Driver.close();
    }

    @Test
    public void testPage(){
        Map.Entry<String, Double> hashingPowerWithUnit = Generator.hashingPowerWithUnit(2.0, 9.9);
        int powerConsumption = Generator.powerConsumption(10, 20);
        double costPerKwh = Generator.costPerKwh(0.5, 2.0);
        BtcPage.hashingPower().sendKeys(String.valueOf(hashingPowerWithUnit.getValue()));
        BtcPage.hashingUnit().selectByVisibleText(hashingPowerWithUnit.getKey());
        BtcPage.powerConsumption().sendKeys(String.valueOf(powerConsumption));
        BtcPage.costPerKwh().sendKeys(String.valueOf(costPerKwh));
        double conversationRate = BtcPage.getConversationRate();
        double actualProfit = BtcPage.getActualProfit();
        double expectedProfit = new Crypto(Generator.hashingPowerInMhs(), powerConsumption, costPerKwh, conversationRate).getProfitPerMonth();
        Assert.assertEquals(
                String.format("Expected profit per month '%1$,.2f' is not equal to actual '%2$,.2f'.", expectedProfit, actualProfit),
                expectedProfit, actualProfit, 0.01
        );
    }
}
