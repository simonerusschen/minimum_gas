package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class BarryExampleBigDecimal {

    /*
     * @author bludwig
     */

    final static int CONSUMPTIONRATE = 20;
    final static int ASCENDRATE = 3;
    final static int SWITCHTIME = 1;
    final static int PROBLEMTIME = 1;

    private int calculate(int depth, int switchDepth, int tankSize) {

        BigDecimal consumption = new BigDecimal(CONSUMPTIONRATE * 2);
        BigDecimal avgPressure = getAvgATA(depth, switchDepth);
        int time = ((depth - switchDepth) / ASCENDRATE) + PROBLEMTIME + SWITCHTIME;
        BigDecimal liter = consumption.multiply(avgPressure).multiply(new BigDecimal(time));
        BigDecimal bar = new BigDecimal(liter.divide(new BigDecimal(tankSize)).setScale(-1, RoundingMode.HALF_UP).toPlainString());

        //bar.setScale(-1, RoundingMode.HALF_UP);

        System.out.println("Depth : " + depth);
        System.out.println("SwithDepth : " + switchDepth);
        System.out.println("");
        System.out.println("Consumption : " + consumption);
        System.out.println("avgATA : " + avgPressure);
        System.out.println("Time : " + time);
        System.out.println("Liter : " + liter);
        System.out.println("");
        System.out.println("Bar : " + bar);
        return bar.intValueExact();

    }


    private BigDecimal getAvgATA(int depth1, int depth2) {

        BigDecimal myAvgDepth = (new BigDecimal(depth1).add(new BigDecimal(depth2))).divide(new BigDecimal("2"));
        BigDecimal myAvgPressure = myAvgDepth.divide(new BigDecimal("10")).add(new BigDecimal("1"));
        myAvgPressure.setScale(1);
        return myAvgPressure;

    }

    public static void main( String[ ] args) {

       int result = new BarryExampleBigDecimal().calculate(45, 21, 24);
        System.out.println(result);
    }
}
