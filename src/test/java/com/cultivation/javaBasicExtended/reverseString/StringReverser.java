package com.cultivation.javaBasicExtended.reverseString;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class StringReverser {
    @SuppressWarnings({"WeakerAccess", "unused"})
    public static String[] reverse(String input) {
        // TODO: please implement the method to pass all the tests.
        // <--start
        if (input == null){
            throw new IllegalArgumentException();
        }
        if (input.length() == 0 || input.trim().length() == 0){
            return new String[0];
        }
        String[] strings = input.split(" ");
//        Arrays.stream(strings).
        List<String> listStrings = Arrays.asList(strings);
        Collections.reverse(listStrings);
        return listStrings.toArray(new String[0]);
        // --end-->
    }
}
