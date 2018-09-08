package com.cultivation.javaBasic;

public class TestClone implements Cloneable{
    private String name;
    public TestClone(String testString) {
        this.name = testString;
    }
    public String getName () {
        return this.name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
