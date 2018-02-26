package testsMinimumgasBepalen;

import minimumgasBepalen.Enumerations.Decogas;
import minimumgasBepalen.Enumerations.TypeOfSet;
import minimumgasBepalen.Enumerations.UnitOfDepth;
import minimumgasBepalen.Enumerations.UnitOfPressure;
import minimumgasBepalen.Enumerations.UnitOfVolume;
import minimumgasBepalen.Input;
import minimumgasBepalen.ValidationException;



public class InputTest {
	
	//dat setters private en niet public zijn komt uit code review
/*
	Input input;

	//kan niet @Before, omdat je dan geen foute waardes kan meegeven
	public final void Setup()  {
		try {
			input = new Input(41,12, UnitOfDepth.METER, UnitOfPressure.BAR, 
					UnitOfVolume.LITER, TypeOfSet.DOUBLE, Decogas.EAN50);
		} catch (ValidationException e) {
			System.out.println("e="+e);
			e.printStackTrace();
			Assert.fail("correct data (happy flow) should not give exception");
		}
	}

	//HAPPY FLOW
	@Test
	public void testCorrectDataShouldCreateInput() { //also does not throw exception TODO
		Setup();
		AssertJUnit.assertNotNull(input);
	}
	@Test
	public final void testValuesMappedCorrectly() {
		Setup();
		AssertJUnit.assertEquals(41,input.getDepth());
		AssertJUnit.assertEquals(12,input.getVolume());
		AssertJUnit.assertEquals(UnitOfDepth.METER,input.getUnitOfDepth());
		AssertJUnit.assertEquals(UnitOfPressure.BAR,input.getUnitOfPressure());
		AssertJUnit.assertEquals(UnitOfVolume.LITER,input.getUnitOfVolume());
		AssertJUnit.assertEquals(TypeOfSet.DOUBLE,input.getTypeOfSet());
		AssertJUnit.assertEquals(Decogas.EAN50,input.getDecogas());
	}
/*	
	//UNHAPPY FLOW
	 * op ieder veld moet een validation exception komen
	@Test
	public final void testDepth52ShouldReturnNullAndGiveException() { //also does throw exception TODO
		
		//TODO QUESTION: EACH INPUT? maar het moet voldoen aan constructor, dus is eigenlijk de validate die je test 
		try {
			input = new Input(52,12, UnitOfDepth.METER, UnitOfPressure.BAR, 
					UnitOfVolume.LITER, TypeOfSet.DOUBLE, Decogas.EAN50);
			
			//TODO dit moet weg
		} catch (ValidationException e) {
			System.out.println("verwacht ook een exception="+e);//TODO
		}		
		assertNull(input);
		
	}
	
//input data met diepte 0;1;51;52 en volume 0;1;30;31
	
	
	//METHOD SetDepth()
	@Test
	public final void testSetDepthWithCorrectDataShouldChangeDepth() {
		try { //TODO OK so?
			input.setDepth(45);
		} catch (ValidationException e) {
			fail("setting correct value should not generate exception");
			//e.printStackTrace();
		}
		assertEquals(45,input.getDepth());
	}
	
	public final void testSetDepthWith52ShouldThrowException() {
		try { //TODO OK so?
			input.setDepth(52);
		} catch (ValidationException e) {
			fail("generate exception");
			
		}
		//assertNotEquals(52,input.getDepth()); //TODO
		
	}
	
	//input.setDepth(0); exception
	//input.setDepth(1); not exception
	//input.setDepth(51); not exception
	//input.setDepth(52); exception
	
*/
}
