package tests;
import junit_testing.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CalculatorTest {
    private static Calculator calc;

    @BeforeAll
    public static void initiateCalcObject(){
        if(calc == null){
            System.out.println("Calculator object initiated.");
            calc = new Calculator();
        }
    }

    @AfterAll
    public static void destroyCalculatorObject(){
        if(calc!=null){
            calc = null;
            System.gc();
            System.out.println("Calculator object removed from Garbage Collector.");
        }
    }

    @Test
    public void testAdd(){
        Assertions.assertEquals(5, calc.add(2, 3));

        System.out.println("Tested addition feature of calculator.");
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3",
            "6, 2",
            "8, 5",
            "9, 4",
            "10, 6"
    })
    public void testSubtract(int a, int b){
        Assertions.assertEquals(a-b, calc.subtract(a, b));
        System.out.println("Tested subtraction feature of calculator.");
    }

//    @Test
//    public void givenTestSourceCode(){
//        // Assert equals
//        Assertions.assertEquals(5, 2 + 3);
//        // Assert true
//        Assertions.assertTrue(5 > 3);
//        // Assert false
//        Assertions.assertTrue(5 < 3);
//        // Assert null
//        Assertions.assertNull(null);
//        // Assert not null
//        Assertions.assertNotNull(new Object());
//    }
}
