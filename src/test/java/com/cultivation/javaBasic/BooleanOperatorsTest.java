package com.cultivation.javaBasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleanOperatorsTest {

    @SuppressWarnings({"PointlessBooleanExpression", "ConstantConditions"})
    @Test
    void should_perform_logical_boolean_operations() {
        boolean[] actualResults = {
            true && true,
            true && false,
            false && false,
            true || true,
            true || false,
            false || false,
            true & true,
            true & false,
            false & false,
            true | true,
            true | false,
            false | false,
            3 == 7,
            4 != 5,
                (double) 1 == (float)1,

        };

        // TODO: please modify the following code to pass the test
        // <--start
        boolean[] expectedResult = {true, false, false, true,
                                    true,
                                    false,
                                    true,
                                    false,
                                    false,
                                    true,
                                    true,
                                    false,
                                    false,
                                    true,true};
        // --end-->
        assertEquals(1.0,1);
        assertArrayEquals(expectedResult, actualResults);
    }

    @Test
    void should_do_bitwise_and_boolean_operation() {
        final int value = 0x1234_abcd;
        final int mask = 0x000f_ff00;

        // TODO: please write down the result directly to pass the test.
        // <--start
        final int expected = 0x0004_ab00;
        // --end-->

        assertEquals(expected, value & mask);
    }

    @Test
    void should_do_bitwise_or_boolean_operation() {
        final int value = 0x1234_0000;
        final int mask = 0x0000_abcd;

        // TODO: please write down the result directly to pass the test.
        // <--start
        final int expected = 0x1234_abcd;
        // --end-->

        assertEquals(expected, value | mask);
    }

    @Test
    void should_do_bitwise_not_operation() {
        final int value = 0x0000_ffff;

        // TODO: please write down the result directly to pass the test.
        // <--start
        final int expected = 0xffff_0000;
        // --end-->

        assertEquals(expected, ~value);
    }

    @Test
    void should_not_prior_and() {
        int value = ~ 0x0000_1234 & 0xffff_0000;
        int not_prior_and_result = 0xffff_0000;
        int and_prior_not_result = 0xffff_ffff;
        assertEquals(not_prior_and_result,value);
        assertNotEquals(and_prior_not_result,value);

    }

    @Test
    void should_not_prior_or() {
        int value =  ~0x0000_1111 | 0x1234_1111;
        int not_prior_or = 0xffff_ffff;
        int or_prior_not_result = 0xedcb_eeee;
        assertEquals(not_prior_or,value);
        assertNotEquals(or_prior_not_result,value);

    }

    @Test
    void should_and_prior_or() {
        int value =  0x0000_1111 | 0x1234_1111 & 0xfff0_2222;
        int and_prior_or_result = 0x1230_1111;
        int or_prior_and_result = 0x1230_0000;

        assertEquals(and_prior_or_result,value);
        assertNotEquals(or_prior_and_result,value);
    }

    @Test
    void should_test_boolean() {
        boolean test;
      //  assertFalse(test);
    }
    @Test
    void should_test_int() {
        int test;
        //  assertEquals(0,test);
    }
    @Test
    void should_test_int_array() {
        int[] ints = new int[6];
        assertEquals(0,ints[0]);

    }
}
