package com.java.oops.association.aggregation;

public class School
{
    private String schoolName;

    private Teacher teacher;

    public String getSchoolName ()
    {
        return schoolName;
    }

    public void setSchoolName ( String schoolName )
    {
        this.schoolName = schoolName;
    }

    public Teacher getTeacher ()
    {
        return teacher;
    }

    public void setTeacher ( Teacher teacher )
    {
        this.teacher = teacher;
    }

    @Override
    public String toString ()
    {
        return "School [schoolName=" + schoolName + ", teacher=" + teacher + "]";
    }
}
