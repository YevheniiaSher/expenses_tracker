package ExpenseTracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static java.lang.Math.max;  //allow using method as just method,without writing package.Class.method

//import static com.datacamp.util.testing.CustomJUnitTestLauncher.launchTestsAndPrint; // custom datacamp tool

//import static org.junit.jupiter.api.Assertions.*;



class ExpenseTest {
    private Expense expense;
    @BeforeEach
    void setUp(){
        expense = new Expense(1, LocalDate.now(), Category.FOOD, "test", 200);
    }

    @Test
    void getDate() {
    }

    @Test
    void getAmount() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void getCategory() {
    }


    @Test
    void setAmount_shouldStoreValue_test() {
        expense.setAmount(250);
        assertEquals(250, expense.getAmount());
    }

    @Test
    void setDescription() {
        expense.setDescription("description");
        assertEquals("description", expense.getDescription());
    }

    @Test
    void setCategory() {
    }

    @Test
    void setDate() {
    }
}

    //test example 1
//    @Test
//    void testLastDigit() {
//        int number = -2025;
//        int expected = 5;
//
//        // Call the method under test
//        int actual = LastDigit.lastDigit(number);
//
//        // Use the correct JUnit assertion for the scenario
//        assertEquals(expected, actual);
//    }
//    test example 2
//    class CurrencyConverterTest {
//
//        @Test
//        void convert_returnsConvertedCurrency_whenValidInputs() {
//            double currency = 100;
//            double exchangeRate = 1.2;
//
//            // Call the convert method with the currency and exchange rate
//            double convertedCurrency = CurrencyConverter.convert(currency, exchangeRate);
//
//            // Use the correct JUnit assertion, the expected value, and the converted currency amount
//            assertEquals(120, convertedCurrency);
//        }
//    @Test
//    void processMessage_throwsException_whenMessageIsNull() {
//        String message = null;
//        Exception expectedException = null;
//
//        try {
//            MessageProcessor.processMessage(message);
//        } catch (Exception e) {
//            expectedException = e;
//        }
//        // Assert the correct type of exception
//        assertInstanceOf(RuntimeException.class, expectedException);
//        // Assert the correct exception message
//        assertEquals("Message cannot be null.", expectedException.getMessage());
//    }
