package com.java.oops.association.aggregation;

public class Teacher
{
    private int teacherId;

    private String teacherName;

    public int getTeacherId ()
    {
        return teacherId;
    }

    public void setTeacherId ( int teacherId )
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName ()
    {
        return teacherName;
    }

    public void setTeacherName ( String teacherName )
    {
        this.teacherName = teacherName;
    }

    @Override
    public String toString ()
    {
        return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + "]";
    }
}
