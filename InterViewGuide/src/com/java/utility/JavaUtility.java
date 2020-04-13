package com.java.utility;

public final class JavaUtility
{
    private JavaUtility() {}
    private static long startTime;
    public static void startTimer ()
    {
        startTime = System.currentTimeMillis();
    }

    public static long stopTimer ()
    {
        long time = System.currentTimeMillis() - startTime;
        startTime = 0L;
        return time;

    }
}
