/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.utility;

/**
 *
 * @author TestingMachine
 */
public class Utility
{
    
    public static double limitRange( double inputValue )
    {
        if( inputValue < -1.0 )
        {
            inputValue = -1.0;
        }
        if( inputValue > 1.0 )
        {
            inputValue = 1.0;
        }
        return inputValue;
    }
    
}
