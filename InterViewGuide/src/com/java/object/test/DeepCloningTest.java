package com.java.object.test;

import com.java.object.cloning.Employee;
import com.java.object.cloning.Person;

public class DeepCloningTest implements Cloneable
{
    public static void main ( String[] args ) throws CloneNotSupportedException
    {
        int pid = 100;
        Person p = new Person( pid );
        int empId = 1;

        Employee e = new Employee( p, empId );
        
        System.out.println( "Before Person object: "+e.p.pid );
        Employee clone = (Employee) e.clone();
        clone.p.pid = 999;
        
        System.out.println( "After Person object: "+e.p.pid );
        
    }
}
