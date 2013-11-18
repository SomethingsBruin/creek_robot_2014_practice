/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.inputs.driver;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author TestingMachine
 */
public class Driver
{
    private static Driver INSTANCE = null;
    private final Joystick joy;
    
    private Driver()
    {
        this.joy = new Joystick( 1 );
    }

    public static Driver getInstance()
    {
        if ( INSTANCE == null )
        {
            INSTANCE = new Driver();
        }

        return INSTANCE;
    }
    
    public void getRawAxis()
    {
        for ( int i = 1; i <= 3; i++ )
        {
            print( "" + i + "", joy.getRawAxis( i ) );
        }
        System.out.println();
    }
    
    public void getRawButton()
    {
        for ( int i = 1; i <= 12; i++ )
        {
            print( "" + i + "",  joy.getRawButton( i ) );
        }
        System.out.println();
    }


    private void print( String str, double val )
    {
        System.out.print( " " + str + ":" + val );
    }
    
    private void print( String str, boolean val )
    {
        System.out.print( " " + str + ":" + val );
    }
}
