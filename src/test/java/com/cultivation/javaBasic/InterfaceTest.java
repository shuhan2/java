package com.cultivation.javaBasic;

import com.cultivation.javaBasic.showYourIntelligence.NameImpl;
import com.cultivation.javaBasic.showYourIntelligence.PersonForEquals;
import com.cultivation.javaBasic.util.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InterfaceTest {

    @Test
    void should_support_default_method() {
        InterfaceWithDefaultMethodImpl instance = new InterfaceWithDefaultMethodImpl();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "The truth of the universe is 42";
        // --end-->

        assertEquals(expected, instance.tellMeTheTruthOfTheUniverse());
    }

    @Test
    void should_choose_override_method() {
        InterfaceWithOverrideDefaultImpl instance = new InterfaceWithOverrideDefaultImpl();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "The truth of the universe is Anime";
        // --end-->

        assertEquals(expected, instance.tellMeTheTruthOfTheUniverse());
    }

    @Test
    void should_choose_override_method_continued() {
        InterfaceExtendsInterfaceWithDefaultMethod instance = new InterfaceExtendsInterfaceWithDefaultMethodImpl();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "The truth of the universe is Game";
        // --end-->

        assertEquals(expected, instance.tellMeTheTruthOfTheUniverse());
    }

    @Test
    void should_resolve_ambiguity_by_yourself() {
        NameImpl instance = new NameImpl();

        String name = instance.getName();

        assertEquals("Person", name);
    }

    @Test
    void should_test_clone_object_without_default_constructor() throws CloneNotSupportedException {
        String testString = "testString";
        TestClone testClone = new TestClone("testString");
        TestClone myClone = (TestClone) testClone.clone();
        assertEquals(myClone,myClone);
        assertEquals(true,myClone.getName()==testClone.getName());
        assertEquals(false,testString == myClone.getName());
    }

    @Test
    void should_sort_array() {
        PersonForEquals james1990 = new PersonForEquals("James",(short)1990);
        PersonForEquals james1992 = new PersonForEquals("James",(short)1992);
        PersonForEquals alice1990 = new PersonForEquals("Alice",(short)1990);
        PersonForEquals[] expectArray = {alice1990,james1990,james1992};
        PersonForEquals[] array = {alice1990,james1992,james1990};
        Arrays.sort(array);
        assertArrayEquals(expectArray,array);
    }
}

/*
 * - Can you clone an object without a default constructor?
 *
 */
