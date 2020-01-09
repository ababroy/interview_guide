package com.java.object.string;

/*
 * Why SCP concept is in String?
 */
/**
 * String is Most commonly used class in java
 */
/*
 * Why String is immutable?
 */
/**
 * Because of SCP. all reference with same content refer to same object , if one ref is going to change its value all will be impacted.
 * 
 * To prevent that, immutability concept introduced in String class
 */

/*
 * equals()
 */
/**
 * r1 == r2 is true then r1.equals(r2) is always true
 * 
 * r1 == r2 is false then r1.equals(r2) may or may not be true
 * 
 * r1.equals(r2) true then r1 == r2 may or may not true
 * 
 * If r1.equals(r2) is false then r1==r2 is always false
 * 
 * 
 * 
 * In String buffer .equals() method is not overridden for content comparison SB sb1 = new SB("abhi");
 * 
 * SB sb2 = new SB("abhi");
 * 
 * sb1.equals(sb2); // return false since StringBuffer .equals() method is not overridden for content comparison
 * 
 * 
 */
/*
 * Contrast between HashCode & equals()
 */
/**
 * Two equivalent object should have same hashCode
 * 
 * if r1.equals(r2) is true then r1.hashCode() == r2.hashCode() is always true
 * 
 * Whatever the parameter you used in .equals() method same parameter recommended to be used in hashCode() overriden method
 * 
 */
