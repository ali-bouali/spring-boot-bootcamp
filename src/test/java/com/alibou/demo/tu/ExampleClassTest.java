package com.alibou.demo.tu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleClassTest {

    ExampleClass exp = new ExampleClass();

    @Test
    public void should_calculate_the_sum_of_two_ints() {
        int res = exp.add(1, 1); // res == 2

        Assertions.assertEquals(2, res);

    }

    @Test // if a or b are null ==> res should be 0
    public void should_calculate_the_sum_of_two_null_ints() {
        int res = exp.add(null, (Integer) null); // res == 0

        Assertions.assertEquals(0, res);

    }

    @Test // if a or b are null ==> res should be 0
    public void should_calculate_the_sum_of_first_null_int() {
        int res = exp.add(1, null); // res == 0

        Assertions.assertEquals(0, res);

    }

    @Test // if a or b are null ==> res should be 0
    public void should_calculate_the_sum_of_second_null_int() {
        int res = exp.add(null, 1); // res == 0

        Assertions.assertEquals(0, res);

    }


    @Test
    public void should_calculate_the_sum_of_two_strings() {
        int res = exp.add("2", "3"); // res == 0
        Assertions.assertEquals(5, res);

    }

    // should not accept characters

    // should not accept doubles as String "1.3"

    @Test
    public void should_calculate_the_div_of_two_ints() {
        int res = exp.div(4, 2); // res == 2

        Assertions.assertEquals(2, res);

    }

    @Test
    public void should_calculate_the_div_of_two_ints_if_den_is_zero() {
        var exception = Assertions.assertThrows(ArithmeticException.class, () -> exp.div(4, 0));
        Assertions.assertEquals("b Should not be zero!", exception.getMessage());
    }


    // DoD ==> Definition Of Done
}
