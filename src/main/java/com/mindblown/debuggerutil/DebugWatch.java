/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mindblown.debuggerutil;

/**
 *
 * @author beamj
 */
public class DebugWatch {
    private long time;
    
    /**
     * Creates a new Watch object and records the time.
     */
    public DebugWatch() {
        recordTime();
    }
    
    /**
     * Returns the last time this object has recorded time
     * @return the last time this object has recorded (in milliseconds)
     * @see #recordTime() 
     */
    public long getTime() {
        return time;
    }
    
    /**
     * Records the time.This means that if you use the timePassed function, 
 it will show you how much time has passed since this current time.
     * @return the time the watch recorded
     */
    public long recordTime(){
        time = System.currentTimeMillis();
        return time;
    }
    
    /**
     * Returns how much time has passed since this object recorded time.
     * @return how much time has passed since this object recorded time (in milliseconds)
     * @see #recordTime() 
     */
    public long timePassed(){
        return System.currentTimeMillis() - time;
    }
}
