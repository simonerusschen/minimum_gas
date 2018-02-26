package testsMinimumgasBepalen;
import calculator.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {

	// je kan de tests vanaf hier starten
	// je kan ook de class selecteren, rightclas, run as junit test
	//TODO check if  all classes are added

	public static void main(String []   args) {
		Result testResult = JUnitCore.runClasses(
                AmountOfGasRequiredUtilTest.class,
                AverageDepthUtilTest.class,
                CalculateStandardBackGasUtilTest.class,
                GasSwitchDepthUtilTest.class,
                ConsumptionUtilTest.class,
                ConvertInputToMetricUtilTest.class,
                CylinderContentUtilTest.class,
                GasSwitchDepthUtilTest.class,
                MinimumGasUtilTest.class,
                PressureAtDepthUtilTest.class,
                TimeToNextStopUtilTest.class
        );
		for (Failure failure : testResult.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println("test was successful="+testResult.wasSuccessful());
	}	
}