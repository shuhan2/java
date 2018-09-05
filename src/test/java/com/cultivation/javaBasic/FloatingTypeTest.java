package com.cultivation.javaBasic;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FloatingTypeTest {
    @Test
    void should_not_get_rounded_result_if_convert_floating_number_to_integer() {
        final float floatingPointNumber = 2.75f;
        final int integer = (int) floatingPointNumber;

        // TODO: Please change the result to pass the test.
        // <!--start
        final int expected = 2;
        // --end-->

        assertEquals(expected, integer);
    }

    @SuppressWarnings({"divzero", "NumericOverflow"})
    @Test
    void should_judge_special_double_cases() {
        assertTrue(isInfinity(1d / 0d));
        assertTrue(isInfinity(-1d / 0d));
        assertFalse(isInfinity(2d));
        assertFalse(isInfinity(Double.NaN));

        assertTrue(isNan(0d / 0d));
        assertFalse(isNan(Double.NEGATIVE_INFINITY));
        assertFalse(isNan(Double.POSITIVE_INFINITY));
    }

    @Test
    void should_not_round_number_when_convert_to_integer() {
        final float floatingPointNumber = 2.75f;
        final int integer = (int) floatingPointNumber;

        // TODO: Please change the result to pass the test.
        // <!--start
        final int expected = 2;
        // --end-->

        assertEquals(expected, integer);

    }

    @Test
    void should_test_convert_type() {
        byte tempByte = 1;
        short tempShort = 1;
        int tempInteger = 1000000;
        long tempLong = 1L;
        float tempFloat = 1.2f;
        double tempDouble = 1.2d;

        short shortNumber1 =tempByte;
        int integer1 = tempByte;
        long longNumber = tempByte;
        float floatNumber = tempByte;
        double  doubleNumber = tempByte;

        byte byteNumber2 = (byte)tempShort;
        int integer2 = tempShort;
        long longNumber2 = tempShort;
        float floatNumber2 = tempShort;
        double doubleNumber2 = tempShort;

        byte byteNumber3 = (byte)tempInteger;
        short shortNumber3 = (short)tempInteger;
        long longNumber3 = tempInteger;
        float floatNumber3 = tempInteger;
        double doubleNumber3 = tempInteger;

        byte byteNumber4 = (byte)tempLong;
        short shortNumber4 = (short)tempLong;
        int integer4 = (int)tempLong;
        float floatNumber4 = tempLong;
        double doubleNumber4 = tempLong;

        byte byteNumber5 = (byte)tempFloat;
        short shortNumber5 = (short)tempFloat;
        int integer5 = (int)tempFloat;
        long longNumber5 = (long)tempFloat;
        double doubleNumber5 = tempFloat;

        byte byteNumber6 = (byte)tempDouble;
        short shortNumber6 = (short)tempDouble;
        int integer6 = (int)tempDouble;
        long longNumber6 = (long)tempDouble;
        float floatNumber6 = (float)tempDouble;

    }

    @SuppressWarnings("unused")
    @Test
    void should_round_number() {
        final double floatingPointNumber = 2.75;

        // TODO: Please call some method to round the floating point number.
        // <!--start
        final long rounded = Math.round(floatingPointNumber);
        // --end-->

        assertEquals(3L, rounded);
    }

    @SuppressWarnings("unused")
    private boolean isNan(double realNumber) {
        // TODO: please implement the method to pass the test.
        return Double.isNaN(realNumber);
    }

    @Test
    void should_return_false_when_compare_two_Nan() {
        assertFalse(Double.NaN == Double.NaN);
    }

    @SuppressWarnings("unused")
    private boolean isInfinity(double realNumber) {
        // TODO: please implement the method to pass the test.//
//        if (Double.isNaN(realNumber)) {
//            return false;
//        }
        return Double.isInfinite(realNumber);
        /*
         * The coach should ask the following questions for the correspond test method:
         *
         * - Can we compare NaN using == directly?
         * - Can we compare XXX_INFINITY using == directly?
         */
    }
}
