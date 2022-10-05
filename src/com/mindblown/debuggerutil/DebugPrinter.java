package com.mindblown.debuggerutil;

import com.mindblown.util.CalendarHelper;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This class is used to help programmers in debugging their programs.
 * @author beamj
 */

public class DebugPrinter {
    public static final int NO_TIME_FORMAT = -1;
    public static final int MILLIS = 0;
    public static final int HMS = 1;

    /**
     * Prints an array of objects.
     *
     * @param starter This is the string that precedes the debug statement
     * @param between This is the string in between each object's print
     * @param timeFormat This is the format for the time stamp of the debug
     * statement. If this is DebugPrinter.NO_TIME_FORMAT, no time stamp is
     * reported. If this is DebugPrinter.MILLIS, a time stamp in the form of
     * time in milliseconds (not relative to when program started - real time)
     * is reported. If this is DebugPrinter.HMS, a time stamp in the form of
     * Hour:Minute:Second is reported (not relative to when program started -
     * real time).
     * @param turnOnQuotes Whether to put quotes before and after each object's
     * print
     * @param objs The objects to print
     */
    public static void println(String starter, String between, int timeFormat, boolean turnOnQuotes, Object... objs) {
        String debug;
        //Adds the time stamp
        switch (timeFormat) {
            case NO_TIME_FORMAT ->
                debug = "";
            case MILLIS ->
                debug = "(" + System.currentTimeMillis() + ") ";
            case HMS ->
                debug = "(" + CalendarHelper.timeHMSFormat() + ") ";
            default ->
                debug = "";
        }

        debug += starter + " [";
        for (int i = 0; i < objs.length; i++) {
            if (turnOnQuotes) {
                debug += '\"';
            }
            debug += stringify(objs[i]);
            if (turnOnQuotes) {
                debug += '\"';
            }
            if (i != objs.length - 1) {
                debug += between;
            }
        }

        debug += "]";
        System.out.println(debug);
    }

    /**
     * Calls the println() function with a starter = "Debug:", the between = ",
     * ", the time format as HMS, and quotes-on = true
     *
     * @param objs the objects to print
     * @see #println(java.lang.String, java.lang.String, int, boolean,
     * java.lang.Object...)
     */
    public static void printlnNorm(Object... objs) {
        println("Debug:", ", ", HMS, true, objs);
    }

    /**
     * Calls the println() function with the-between = ", ", the time format as
     * HMS, and quotes-on = true.This function allows you to choose the starter
     *
     * @param starter the starter for the debug statement. See the complicated
     * println() function linked below
     * @param objs the objects to print
     * @see #println(java.lang.String, java.lang.String, int, boolean,
     * java.lang.Object...)
     */
    public static void printlnCustomNorm(String starter, Object... objs) {
        println(starter, ", ", HMS, true, objs);
    }

    /**
     * Prints an object out to the console
     *
     * @param obj the object to be printed
     */
    public static void println(Object obj) {
        System.out.println(stringify(obj));
    }
    
    /**
     * Represents an object with a string.
     * @param obj the object to be represented
     * @return a string representing the object
     */
    private static String stringify(Object obj){
        if(obj == null){
            return "null";
        } else {
            return obj.toString();
        }
    }
}
