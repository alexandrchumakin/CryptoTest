package utils;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    static Map.Entry<String, Double> _hashingPowerWithUnit;
    static double roundDouble(double value, int precision){
        DecimalFormat f = new DecimalFormat(String.format("##.%1$s", StringUtils.leftPad("", precision, '0')));
        return Double.parseDouble(f.format(value));
    }

    private static final Map<String, Double> units = new HashMap<String, Double>(){{
        put("H/s", Math.pow(10, 12));
        put("KH/s", Math.pow(10, 9));
        put("MH/s", Math.pow(10, 6));
        put("GH/s", Math.pow(10, 3));
        put("TH/s", 1.0);
    }};

    public static Map.Entry<String, Double> hashingPowerWithUnit(double rangeMin, double rangeMax){
        Random r = new Random();
        String unit = units.keySet().toArray()[r.nextInt(units.keySet().size())].toString();
        double thValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        double hashingPower = thValue * units.get(unit);
        _hashingPowerWithUnit = ImmutableMap.<String, Double>builder().put(unit, roundDouble(hashingPower, 2)).build().entrySet().asList().get(0);
        return _hashingPowerWithUnit;
    }

    public static double hashingPowerInMhs(){
        double res;
        switch (_hashingPowerWithUnit.getKey()){
            case "H/s":
                res = _hashingPowerWithUnit.getValue() / Math.pow(10, 6);
                break;
            case "KH/s":
                res = _hashingPowerWithUnit.getValue() / Math.pow(10, 3);
                break;
            case "MH/s":
                res = _hashingPowerWithUnit.getValue();
                break;
            case "GH/s":
                res = _hashingPowerWithUnit.getValue() * Math.pow(10, 3);
                break;
            case "TH/s":
                res = _hashingPowerWithUnit.getValue() * Math.pow(10, 6);
                break;
            default:
                System.out.format("'%s' is not supported unit.", _hashingPowerWithUnit.getKey());
                res = 0.0;
                break;
        }
        return res;
    }

    public static int powerConsumption(int rangeMin, int rangeMax){
        return ThreadLocalRandom.current().nextInt(rangeMin, rangeMax + 1);
    }

    public static double costPerKwh(double rangeMin, double rangeMax){
        return rangeMin + (rangeMax - rangeMin) * new Random().nextDouble();
    }
}
