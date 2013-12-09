/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.inputs.driver;
import com.cc.utility.Utility;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author TestingMachine
 */
public class Driver
{
    private Joystick joy;
    private static Driver instance = null;
    
    private final double XMIN = -0.71875;
    private final double XMAX = 0.8031496062992126;
    private final double YMAX = -0.59375;
    private final double YMIN = 0.69291;
    private final double ROTMAX = 0.84252;
    private final double ROTMIN = -0.67188;
    private final double XCENTER = 0.0;
    private final double YCENTER = 0.00787;
    private final double ROTCENTER = 0.03937;
    
    private Driver()
    {
        joy = new Joystick( 1 );
        //creates new joystick
    }
    
    public static Driver getInstance()
    {
        if( instance == null )
        {
            instance = new Driver();
        }
        return instance;
    }
  
    public void printAxes()
    {
        for( int i = 1; i < 7; i++ )
        {
            System.out.print(i + ": " +  joy.getRawAxis( i ) + " " );
        }
        
        System.out.println();
    }
     
    public double getX () // Gets the X
    {
        double xValue = normalize( joy.getRawAxis( 1 ) , XMIN , XMAX, XCENTER);
        return xValue;
    }
    
    public double getY () // Gets the Y
    {
         double yValue = normalize( joy.getRawAxis( 2 ) , YMIN , YMAX, YCENTER);
        return yValue;
    }
    
     public double getRot () // Gets the Rotational Input
    {
         double rotValue = normalize( joy.getRawAxis( 5 ) , ROTMIN , ROTMAX, ROTCENTER);
        return rotValue;
    }
    
    public void printButtons()
    {
        for( int i = 1; i < 13; i++ )
        {
            System.out.print( joy.getRawButton( i ) + " " );
        }
        System.out.println();
    }
    
    public double normalize( double inValue, double minValue, double maxValue, double cValue )
    {
        double output = 0;
        inValue -= cValue;
        if( inValue < 0.0 )
        {
            output = inValue / -minValue;
        }
        else
        {
            output = inValue / maxValue;
        }
        output = Utility.limitRange( output );
        return output;
    }
    
}
