package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StackFrameHelper {
    public static String getCurrentMethodName() {
        // TODO: please modify the following code to pass the test
        //https://www.baeldung.com/java-name-of-executing-method
        // <--start

        StringBuilder className = new StringBuilder(Thread.currentThread().getStackTrace()[2].getClassName());
        return className.append(".").append(Thread.currentThread().getStackTrace()[2].getMethodName()).toString();
        // --end-->
    }
}
