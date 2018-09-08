package com.cultivation.javaBasic.showYourIntelligence;

import com.cultivation.javaBasic.util.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("unused")
public class PersonForEquals implements Comparable<PersonForEquals> {
    private final String name;
    private final short yearOfBirth;

    public PersonForEquals(String name, short yearOfBirth) {
        if (name == null) {
            throw new IllegalArgumentException("name is mandatory.");
        }

        if (yearOfBirth <= 1900 || yearOfBirth >= 2019) {
            throw new IllegalArgumentException("year of birth is out of range.");
        }

        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }


    public String getName() {
        return name;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    @SuppressWarnings("Contract")
    @Override
    public boolean equals(Object obj) {
        // TODO: please modify the following code to pass the test
        // <--start

       if (obj == null) {
           return false;
       }
       if (obj == this) {
           return true;
       }
       if (obj.getClass() != this.getClass()) {
           return false;
       }
        String objName = ((PersonForEquals) obj).getName();
        short objYearOfBirth = ((PersonForEquals) obj).getYearOfBirth();
        return this.getName() == objName
                && this.getYearOfBirth() == objYearOfBirth;
       // throw new NotImplementedException();
        // --end-->
    }

    @Override
    public int hashCode() {
        // TODO: please modify the following code to pass the test
        // <--start
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.yearOfBirth;
        return result;
//        throw new NotImplementedException();
        // --end-->
    }

    @Override
    public int compareTo(PersonForEquals person) {
        if (person == null){
            throw new NullPointerException();
        }
        int nameCompare = this.name.compareTo(person.getName());
        if (nameCompare != 0){
            return nameCompare;
        }else {
            if (this.yearOfBirth == person.getYearOfBirth()){
                return 0;
            }else {
                return this.yearOfBirth - person.yearOfBirth > 0 ? 1 : -1;
            }
        }

    }
}
