package com.cultivation.javaBasic;

import com.cultivation.javaBasic.util.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LambdaTest {
    @Test
    void should_apply_to_interface_with_single_abstract_method() {
        StringFunc lambda = () -> "Hello";

        // TODO: please modify the following code to pass the test
        // <--start
        final String expect = "Hello";
        // --end-->

        assertEquals(expect, lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_be_able_to_bind_to_instance_method() {
        // TODO: please bind lambda to instanceMethod.
        // <--start
        StringFunc lambda = this::instanceMethod;
        // --end-->

        assertEquals("instanceMethod", lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_be_able_to_bind_to_static_method() {
        // TODO: please bind lambda to staticMethod
        // <--start
        StringFunc lambda = LambdaTest::staticMethod;
        // --end-->

        assertEquals("staticMethod", lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_bind_to_constructor() {
        // TODO: please bind lambda to constructor of ArrayList<Integer>
        // <--start
        GenericFunc<ArrayList<Integer>> lambda = () -> new ArrayList<>();
        // --end-->

        ArrayList<Integer> value = lambda.getValue();

        assertEquals(0, value.size());
    }

    @Test
    void should_capture_variable_in_a_closure() {
        int captured = 5;

        StringFunc lambda = new StringFunc() {
            @Override
            public String getString() {
                return captured + " has been captured.";
            }
        };

        final String message = lambda.getString();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "5 has been captured.";
        // --end-->

        assertEquals(expected, message);
    }

    @Test
    void should_evaluate_captured_variable_when_executing() {
        ValueHolder<String> value = new ValueHolder<>();
        value.setValue("I am the King of the world!");

        StringFunc lambda = () -> "The length of captured value is: " + value.getValue().length();

        // TODO: please write down the expected string directly.
        // <--start
        final String expected = "The length of captured value is: 4";
        // --end-->

        value.setValue("Blah");
        assertEquals(expected, lambda.getString());
    }

    @Test
    void should_extend_variable_scope() {
        StringFunc stringFunc = returnLambda();
        String message = stringFunc.getString();

        // TODO: please write down the expected string directly.
        // <--start
        final String expected = "In the year 2019";
        // --end-->

        assertEquals(expected, message);
    }

    @Test
    void should_capture_this_variable() {
        ThisInClosure instance = new ThisInClosure();
        StringFunc stringFunc = instance.getLambda();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "ThisInClosure";
        // --end-->

        assertEquals(expected, stringFunc.getString());
    }

    private static StringFunc returnLambda() {
        int[] year = {2019};
        return new StringFunc() {
            @Override
            public String getString() {
                return "In the year " + year[0];
            }
        };
    }

    @Test
    void should_not_assign_lambda_to_object() {
        Object object = (StringFunc) () -> "Hello";
        StringFunc test = (StringFunc) object;
        assertEquals("Hello",test.getString());
    }
//exercise
    @Test
    void should_return_a_with_char_supplier() {
        CharSupplier lambda = () -> 'a';

        char expect = 'a';
        assertEquals(expect,lambda.getAsChar());
    }

    @Test
    void should_return_int_with_int_interface() {
        IntSupplier lambda = new IntSupplier() {
            @Override
            public int apply(int number) {
                return number;
            }
        };

        int expect = 5;
        assertEquals(expect,lambda.apply(5));
    }

    @Test
    void should_return_sum_with_int_interface() {
        IntBiFunction lambda = (number1, number2) -> number1+number2;

        int expect = 5;
        assertEquals(expect,lambda.apply(2,3));

    }

    @Test
    void should_reverse_array_index_0_and_1_no_return_with_int_interface() {
        int[] testArray1 = {0};
        int[] testArray2 = {0,1};
        int[] testArray3 = {0, 1, 2};
        IntBiConsumer lambda = array -> {
            if (array.length > 1) {
                int temp = array[0];
                array[0] = array[1];
                array[1] = temp;
            }
        };
        lambda.consumer(testArray2);
        lambda.consumer(testArray3);
        int[] expect2 = {1, 0};
        int[] expect3 = {1, 0, 2};
        assertArrayEquals(expect2, testArray2);
        assertArrayEquals(expect3, testArray3);
    }

    @Test
    void should_return_sum_with_summer_interface() {
        SumFunction summer = array ->
        { if (array == null || array.length == 0) {
            return 0;
        }
            return Arrays.stream(array).sum();
        };
        int[] testArray1 = {};
        int[] testArray2 = {1, 2, 3, 4, 5};
        assertEquals(0,summer.apply(testArray1));
        assertEquals(15,summer.apply(testArray2));

    }

    @SuppressWarnings("unused")
    private static String staticMethod() {
        return "staticMethod";
    }

    @SuppressWarnings("unused")
    private String instanceMethod() {
        return "instanceMethod";
    }
}

/*
 * - Do you think you can assign a lambda expression to an Object instance?
 */
