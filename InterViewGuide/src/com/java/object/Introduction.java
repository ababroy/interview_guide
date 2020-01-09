package com.java.object;

/**
 * Introduction for Object
 * 
 * @author AROY
 *
 *
 *         final Vs Immutability
 * 
 *         HashCode & equals()
 * 
 *         why scp introduced in String
 * 
 *         shallow & deep clone
 * 
 *         Run time & compile time Polymorphism
 * 
 *         Association (Composition & Aggregation)
 * 
 *         Volatile
 * 
 *         Transient
 * 
 *         Abstraction
 * 
 *         Difference between Interface & abstract (before & after JDK 7)
 * 
 *         Can replace interface to abstract
 * 
 *         Call by value / call by reference in java
 * 
 *         Immutable Object creation
 * 
 *         Customized Exception
 * 
 */

/**
 * String
 * 
 */
/*
 * final vs Immutability
 */
/**
 * you can't reassign to the reference variable but it des not mean that you can't perfom any changes into that object
 * 
 * final SB sb = new SB("Hello"); sb.append("World");
 * 
 * sb = new SB("MyWorld"); //compile error bcz it's final
 * 
 * 
 * Conclusion::
 * 
 * - final variable (Y)
 * 
 * - final object (N)
 * 
 * - Immutable variable (N)
 * 
 * - Immutable object (Y)
 * 
 */

