package tests;
import junit_testing.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator calc = new Calculator();
        Assertions.assertEquals(5, calc.add(2, 3));
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
        Calculator calc = new Calculator();
        Assertions.assertEquals(a-b, calc.subtract(a, b));
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
