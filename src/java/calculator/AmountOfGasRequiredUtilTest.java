package calculator;
import org.junit.Test;

import static org.junit.Assert.*;
import java.math.BigDecimal;

public class AmountOfGasRequiredUtilTest {

    @Test
    public void single12ShouldReturn12() {

        int result = AmountOfGasRequiredUtil.getTotaalNodigGasInLiter(40,4.3,10);
        assertEquals("amount of gas incorrect", 1720, result );
    }

    //parameter=0 returns 0. In the architecture the class Input checks the input values, so no need to check here
}
