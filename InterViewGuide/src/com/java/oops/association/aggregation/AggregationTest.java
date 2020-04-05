package com.java.oops.association.aggregation;

public class AggregationTest
{
    @SuppressWarnings ( { "unused" } )
    public static void main ( String[] args )
    {
        Teacher teacher = new Teacher();
        teacher.setTeacherId( 1000 );
        teacher.setTeacherName( "Sadananda Hajra" );

        School school = new School();
        school.setSchoolName( "Arambagh High School" );
        school.setTeacher( teacher );

        System.out.println( school );
        System.out.println( school.getTeacher() );

        school = null;

        System.out.println( school );
        System.out.println( teacher );
    }
}
