package utils;

public class Crypto {
    private static final double difficulty = 711697198173.7566;
    private static final double blockRewards = 12.5;
    private double _profitPerMonth;

    public Crypto(double hashingPow, double powConsumption, double costPerKwh, double conversationRate){
        double hoursPerMonth = 30 * 24;
        double powerCostPerMonth = (hoursPerMonth * powConsumption * costPerKwh) / 1000;
        double minedPerMonth = hoursPerMonth / (difficulty * Math.pow(2, 32) / (hashingPow * Math.pow(10, 6)) / 60 / 60) * blockRewards;
        _profitPerMonth = Generator.roundDouble(minedPerMonth, 6) * conversationRate - powerCostPerMonth;
    }

    public double getProfitPerMonth(){
        return Generator.roundDouble(_profitPerMonth, 2);
    }
}
