package com.cultivation.javaBasic;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class StringTest {
    @SuppressWarnings({"StringEquality", "ConstantConditions"})
    @Test
    void should_be_immutable() {
        String originalString = "The original string";
        String modifiedString = originalString.replace("original", "new");
        originalString = "asd";
        // TODO: Please modify the following line to pass the test.
        //
        // It is really easy to pass the test. But you have to tell why.
        // <--start
        final Optional<Boolean> areSame =Optional.of(false);
        // --end-->

        assertEquals("The new string", modifiedString);
        assertEquals(areSame.get(), originalString == modifiedString);
    }

    @SuppressWarnings({"StringEquality", "ConstantConditions"})
    @Test
    void all_modification_method_will_create_new_string() {
        String originalString = "The string with tailing space.      ";
        String modifiedString = originalString.trim();

        // TODO: Please modify the following line to pass the test.
        //
        // It is really easy to pass the test. But you have to tell why.
        // <--start
        final Optional<Boolean> areSame = Optional.of(false);
        // --end-->

        assertEquals("The string with tailing space.", modifiedString);
        assertEquals(areSame.get(), originalString == modifiedString);
//        assertEquals(areSame.get(), "12" == "12");
////
////        String originString = "12";
////        String modifiedString1 = "12";
////        assertEquals(areSame.get(), originalString == modifiedString1);
    }

    @SuppressWarnings({"StringEquality", "ConstantConditions"})
    @Test
    void will_create_new_string_when_concat() {
        String originalString = "Part one. ";
        String copyOfOriginalString = originalString;
        originalString += "Part two.";

        // TODO: Please modify the following line to pass the test.
        //
        // It is really easy to pass the test. But you have to tell why.
        // <--start
        final Optional<Boolean> areSame = Optional.of(false);
        // --end-->

        assertEquals("Part one. Part two.", originalString);
        assertEquals(areSame.get(), originalString == copyOfOriginalString);
    }

    @Test
    void should_test_boolean_primitive() {
        boolean[] test = new boolean[2];
        assertEquals(test[0],false);
    }

    @SuppressWarnings("unused")
    @Test
    void should_taken_string_apart() {
        final String originalString = "Java is great";

        // TODO: Take part of the original string according to expectation.
        // <--start
        //substring return a new string
        final String partOfString = originalString.substring(5);
        // --end-->

        final String expectedString = "is great";

        assertEquals(expectedString, partOfString);
        //
    }

    @SuppressWarnings("unused")
    @Test
    void should_taken_string_apart_continued() {
        final String originalString = "Java is great.";

        // TODO: Take part of the original string according to expectation.
        // <--start
        final String partOfString = originalString.substring(5,7);
        // --end-->

        final String expectedString = "is";

        assertEquals(expectedString, partOfString);
    }

    @Test
    void should_test_substring_method() {
        String originalString = "Java is great.";
//        assertEquals(originalString,originalString.substring(0,20));
      //  assertEquals("is",originalString.substring(7,5));
        String nullString = null;
    //    assertEquals(null,nullString.substring(0));
    }
    /*
     * Questions on take string apart.
     *
     * - What if the input arguments is out of range of the string?  StringIndexOutOfBoundsException
     * - What will happen if the the starting index is greater than the ending index? StringIndexOutOfBoundsException
     * - What will happen if the input string is of null reference?  NullPointerException
     */

    @SuppressWarnings({"unused", "ConstantConditions"})
    @Test
    void should_break_string_into_words() {
        final String sentence = "This is Mike";

        // TODO: Extract words in the sentence.
        // <--Start
        String[] words = sentence.split(" ");
        // --End-->

        assertArrayEquals(new String[] {"This", "is", "Mike"}, words);
    }
    String[] strings = new String[1];
    @SuppressWarnings({"unused", "ConstantConditions"})
    @Test
    void should_break_string_into_words_customized() {
        final String sentence = "This/is/Mike";

        // TODO: Extract words in the sentence.
        // <--Start
        String[] words = sentence.split("/");
        // --End-->

        assertArrayEquals(new String[] {"This", "is", "Mike"}, words);
    }

    @Test
    void should_test_Object_primitive() {
        Object testObject;
        //We can not use object if object are not be inlizatied
        //
        //        testObject.toString();
    }

    @SuppressWarnings({"unused", "StringBufferReplaceableByString", "MismatchedQueryAndUpdateOfStringBuilder"})
    @Test
    void should_create_ascii_art() {
        final int width = 5;
        final int height = 3;

        // TODO: Create string using StringBuilder
        //stringbuilder stringbuffer(synchronization)
        // <--Start
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < height; row++) {
            builder.append("|");
            for (int column = 1; column < width - 1; column++) {
                if (row == 1) {
                    builder.append(" ");
                } else {
                    builder.append("-");
                }
            }
            builder.append("|\n");
        }
        // --End-->
        final String expected =
            "|---|\n" +
            "|   |\n" +
            "|---|\n";

        assertEquals(expected, builder.toString());
    }

    @SuppressWarnings("unused")
    @Test
    void should_calculate_checksum_of_a_string() {
        final String text = "A quick brown fox jumps over a lazy dog.";

        int sum = 0;
        // TODO: Write some code to calculate the checksum of the string. The checksum is the sum of each string char.
        // <--Start
//        String[] words = text.split("/");
//        for (String word : words){
//            for (int i = 0;i < word.length() ; i++){
//                sum += (int)(word.charAt(i));
//            }
//        }

        for (int i = 0; i < text.length(); i++){
            sum += (int)(text.charAt(i));
        }
        //sum = text.chars().sum();
        // --End-->

        assertEquals(3655, sum);
    }

    @Test
    void should_convert_unicode_escape() {
        final String expected = "なにこれ";

        // TODO: Write actual string using unicode escape. The unicode is as follows:
        // な - U+306a
        // に - U+306b
        // こ - U+3053
        // れ - U+308c
        // <--Start

        final String actual = "\u306A\u306B\u3053\u308C";
        // --End-->

        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    @Test
    void should_reverse_a_string() {
        final String original = "123456";

        // TODO: Modify the following code to create new string from original String
        // <--Start
        final String reversed =new StringBuilder(original).reverse().toString() ;
        // --End-->

        assertEquals("654321", reversed);
    }
    public final char originalString[] = {'1','2','3','4','5','6'};
    @Test
    void should_test_reverse_charArray() {

        assertEquals('6',originalString[0]);
        assertEquals('5',originalString[1]);
        assertEquals('4',originalString[2]);
        assertEquals('3',originalString[3]);
        assertEquals('2',originalString[4]);
        assertEquals('1',originalString[5]);
    }


    @SuppressWarnings("ConstantConditions")
    @Test
    void should_compare_string_with_different_cases() {
        final String upperCased = "HELLO";
        final String lowerCased = "hello";

        Optional<Boolean> equalResult = Optional.of(upperCased.equals(lowerCased));
        Optional<Boolean> equalIgnoreCaseResult = Optional.of(upperCased.equalsIgnoreCase(lowerCased));

        // TODO: Please change the value of the following 2 lines to pass the test.
        // <--start
        Optional<Boolean> actualResultOfEqual = Optional.of(false);
        Optional<Boolean> actualResultOfEqualIgnoreCase = Optional.of(true);
        // --end-->

        assertEquals(equalResult, actualResultOfEqual);
        assertEquals(equalIgnoreCaseResult, actualResultOfEqualIgnoreCase);
    }

    @Test
    void should_get_code_point_count() {
        //chi 口七
        final String withSurrogatePairs =
            new String(Character.toChars(0x20B9F)) + " is a character that you may not know";

        // TODO: please modify the following code to pass the test
        // <--start
        // TODO: please write down the result directly.
        final int expectedCharLength = 39;
        // TODO: please call some method to calculate the result.
        final int actualCodePointLength = withSurrogatePairs.codePointCount(0,withSurrogatePairs.length());
        // --end-->

        assertEquals(expectedCharLength, withSurrogatePairs.length());
        assertEquals(38, actualCodePointLength);
    }

    @Test
    void should_copy_all_code_point_to_array() {
        final String withSurrogatePairs =
            new String(Character.toChars(0x20B9F)) + " is funny";

        final int[] codePoints = getCodePointsFromString(withSurrogatePairs);

        assertArrayEquals(
            new int[] {0x20B9F, (int)' ', (int)'i', (int)'s', (int)' ', (int)'f', (int)'u', (int)'n', (int)'n', (int)'y'},
            codePoints);
    }

    @Test
    void should_format_string() {
        final String name = "Harry";
        final int age = 23;

        String text = String.format("Hello, %s. Next year, you will be %d.", name, age);

        // TODO: please modify the following code to pass the test
        // <--start
        final String expectedText = new String("Hello, Harry. Next year, you will be 23.");
        // --end-->

        assertEquals(expectedText, text);
    }

    private int[] getCodePointsFromString(String withSurrogatePairs) {
        int length = withSurrogatePairs.codePointCount(0,withSurrogatePairs.length());
        int[] result =  new int[length];
        int codePointIndex = 0;
        for (int charIndex = 0; charIndex < withSurrogatePairs.length();
             charIndex += Character.charCount(withSurrogatePairs.codePointAt(charIndex))) {
            result[codePointIndex++] = withSurrogatePairs.codePointAt(charIndex);
        }
        return result;
    }
    /*
     * - List other string format conversion chars.
     *   * d - decimal integer           1
     *   * x - hexadecimal integer       0xa
     *   * o - octal integer            012
     *   * f - fixed-point floating point    //定点浮点数
     *   * e - exponential floating point    //指数
     *   * g - general floating point (the shorter of e and f)
     *   * a - hexadecimal floating point
     *   * s - string  "asd"
     *   * c - character  'q'
     *   * b - boolean  true
     *   * h - hash code   equal
     *   * n - platform dependent line separator     n, System.getProperty("line.separator").

     *   https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
     */
}
