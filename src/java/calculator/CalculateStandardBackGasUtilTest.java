package calculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class CalculateStandardBackGasUtilTest {
    private Integer inputDepth;
    private String expectedResult;

    //constructor van deze testklasse, called voor elke test
    //volgorde parameters is de volgorde in de array
    //public void StandardBackGasTest(int depth, String expectedResult) {
        public CalculateStandardBackGasUtilTest(Integer inputDepth, String expectedResult) {
        this.inputDepth=inputDepth;
        this.expectedResult=expectedResult;
    }

    @Before
    //object maken van class under test, gebeurd voor elke test
    public void initialize() {
        CalculateStandardBackGasUtil calculateStandardBackGasUtil = new CalculateStandardBackGasUtil();
    }


    //de testdata, dit runt als allereerste in deze class

    @Parameterized.Parameters //annotation marks this method as parameters provider
    public static Collection input() {

        return Arrays.asList(new Object[][] {
                {0, "nitrox EAN32 (of trimix 30/30)"},
                {29, "nitrox EAN32 (of trimix 30/30)"},
                {30, "nitrox EAN32 (of trimix 30/30)"},
                {31, "trimix 21/35"},
                {44, "trimix 21/35"},
                {45, "trimix 21/35 of 18/45 (met 5 min kortere bodemtijd)"},
                {46, "trimix 18/45"},
                {51, "trimix 18/45"},
                {52, "dit is geen T1 duik"},
                {60, "dit is geen T1 duik"}
        });
    }

    //this test will run once for every line of parameters defined
    @Test
    public void testStandardBackGas() {
        String result = CalculateStandardBackGasUtil.getStandardBackGas(inputDepth);
        System.out.println(" Parameterized Number is: " + inputDepth + ", expected is " + expectedResult + ", result is " + result);
        //assertEquals("std gas check", expectedResult, result);
    }
}