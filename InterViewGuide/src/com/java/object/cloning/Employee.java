package com.java.object.cloning;

public class Employee
    implements Cloneable
{
    int empId;

    public Person p;

    public Employee ( Person p, int empId )
    {
        super();
        this.p = p;
        this.empId = empId;

    }
    
    /**
     * Deep cloning method
     */
    @Override
    public Object clone () throws CloneNotSupportedException
    {
        Person person = new Person(p.pid);
        Employee emp = new Employee(person, empId);
        return emp;
    }
    
}
