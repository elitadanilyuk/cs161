//package edu.frontrange.csc160.a6;

/** This program
 *
 * @author Elita Danilyuk, S02664865
 * @verson2021-01-31, CSC-160 Homework 2
 */


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.out;

/**
 * Person class, to meet the requirements stated in the Assignment
 Instructions for Assignment.
 * <p>
 * The following UML is given for this class: </p>
 * <p>
 * <strong><u>Person</u> <br>
 * - firstNameField: String <br>
 * - lastNameField: String <br>
 * - ageField: double <br>
 * <br>
 * +&lt;constructor&gt; Person(firstName: String, lastName: String,
 initialAge: double) <br>
 * + setFirst(firstName: String) <br>
 * + setLast(lastName: String) <br>
 * + setAge(): String <br>
 * + getFirst(): String <br>
 * + getLast(): String <br>
 * * + getAge(): String <br>
 * + displayValues() <br>
 * + toString() : String </strong></p>
 *
 */
public class Person extends PersonTest
{
    /**
     * Default value for invalid names.
     */
    private static final String DEFAULT_NAME = null;

    /**
     * Default value for invalid salary.
     */
    private static final int DEFAULT_AGE = 0;

    /**
     * String used to introduce and mark an error message.
     */
    private static final String ERROR_MARKER = "Error in setting Person object: ";

    /**
     * String used to describe a first name.
     */
    private static final String FIRST_KIND = "first";

    /**
     * String used to respond to a missing first name.
     */
    private static final String FIRST_NAME_REPLACEMENT = "<Invalid " + FIRST_KIND + " name>";

    /**
     * String used to describe a last name.
     */
    private static final String LAST_KIND = "last";

    /**
     * String used to respond to a missing last name.
     */
    private static final String LAST_NAME_REPLACEMENT =	"<Invalid " + LAST_KIND + " name>";

    /**
     * Number of months in a year.
     */
    private static final int MONTHS_IN_YEAR = 12;

    /**
     * The Person's first name (assuming Western World naming).
     */
    private String firstNameField = DEFAULT_NAME;

    /**
     * The Person's last name (assuming Western World naming).
     */
    private String lastNameField = DEFAULT_NAME;

    /*
     * The Persons' age in years
     */
    private double ageField = 0;

    /**
     * Constructor.
     *
     * @param firstName     Person's first name (assuming Western World naming)
     * @param lastName      Person's last name (assuming Western World naming)
     * @param initialAge	Person's initial age in years
     */
    public Person(String firstName, String lastName, double initialAge)
    {
        setFirst(firstName);
        setLast(lastName);
        setAge(initialAge);
    }

    /**
     * Print on the standard output the details of this Person.
     */
    public void displayValues()
    {
        out.print(getFirst() + " " + getLast() +  " " + (int)getAge() +"\n");
    }

    /**
     * Getter for the Person's first name (assuming Western World naming).
     *
     * @return	Person's first name.
     */
    public String getFirst()
    {
        return this.firstNameField;
    }

    /**
     * Setter for the Person's first name (assuming Western World naming).
     *
     * @param firstName	Person's first name (assuming Western World naming).
     */
    public void setFirst(String firstName)
    {
        // Validating the Person's first name
        if("".equals(firstName))
            firstNameField = null;
        else
            firstNameField = firstName;
    }

    /**
     * Getter for the Person's last name (assuming Western World naming).
     *
     * @return	Person's last name.
     */
    public String getLast()
    {
        return this.lastNameField;
    }

    /**
     * Setter for the Person's last name (assuming Western World naming).
     *
     * @param lastName	Person's last name (assuming Western World naming).
     */
    public void setLast(String lastName)
    {
        // Validating the Person's last name
        if("".equals(lastName)) {
            lastNameField = null;
        }
        else
            this.lastNameField = lastName;
    }

    /**
     * Setter for the Person's age.
     *
     * @param age	Person's age.
     */
    public void setAge(double age)
    {
        // Validating the input age
        if(age > 0)
            ageField = age;
        else
            ageField = DEFAULT_AGE;
    }

    /**
     * Getter for the Person's age.
     *
     * @return	Person's age.
     */
    public double getAge()
    {
        return ageField;
    }

    /**
     * String identifying and describing this Person.
     *
     * @return the string
     */
    @Override
    public String toString()
    {
        // method to print the String value for the current Person

        String str2 = null;
        try{
            Method method = this.getClass().getMethod("hashCode");
            str2 = method.invoke(this).toString();
        } catch( NoSuchMethodException | IllegalArgumentException |
                InvocationTargetException | IllegalAccessException |
                SecurityException | ClassCastException ex ) {}

         return this.getClass().getName() + "\u0040"  + Integer.toHexString(Integer.parseInt(str2)) + " " +
                this.getFirst() + " " + this.getLast();
    }
}
