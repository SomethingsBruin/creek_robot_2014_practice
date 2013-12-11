/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.systems;

import com.cc.output.motors.CCTalon;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author TestingMachine
 */
public class Chassis
{
    
    private static Chassis instance = null;
    
    private CCTalon leftForward;
    private CCTalon rightForward;
    private CCTalon leftRear;
    private CCTalon rightRear;
    private Gyro gyro;
            
    private Chassis()
    {
        leftForward = new CCTalon ( 1, false );
        rightForward = new CCTalon ( 3, true );
        leftRear = new CCTalon ( 2, false );
        rightRear = new CCTalon ( 4, true );
        gyro = new Gyro ( 1 );
    }
    
    public static Chassis getInstance()
    {
        if ( instance == null)
        {
            instance = new Chassis();
        }
        return instance;
    }
     
    public void holoDrive( double fwd , double sld , double rot)
    {
        double lf = fwd + sld + rot;
        double rf = fwd - sld - rot;
        double lr = fwd - sld + rot;
        double rr = fwd + sld - rot;
        
        double maxVal = Math.abs(lf);
        if ( Math.abs(rf) > maxVal)
        {
            maxVal = Math.abs(rf);
        }
        
        if ( Math.abs(lr) > maxVal)
        {
            maxVal = Math.abs(lr);
        }
        
         if ( Math.abs(rr) > maxVal)
        {
            maxVal = Math.abs(rr);
        }
         
         if (maxVal > 1.0)
         {
             lf /= maxVal;
             rf /= maxVal;
             lr /= maxVal;
             rr /= maxVal;
         }
         
         //System.out.println( "rf: " + rf + " lf: " + lf + " lr: " + lr + " rr: " + rr );
         
         rightForward.set( rf );
         leftForward.set( lf );
         leftRear.set( lr );
         rightRear.set( rr );
    }
    
    public void printGyro()
    {
        
        System.out.println( gyro.getAngle() );
        
    }
}