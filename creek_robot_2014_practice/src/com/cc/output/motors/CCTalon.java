/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.output.motors;

import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author TestingMachine
 */
public class CCTalon extends Talon
{
    private boolean _isReversed;
    
    public CCTalon( int port, boolean isReversed )
    {
        super( port );
        _isReversed = isReversed;
    }
    
    public void set( double speed )
    {
        if( _isReversed )
        {
           speed = -speed;
        }
        super.set( speed );
    }
    
}
