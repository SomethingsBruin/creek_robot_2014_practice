/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import com.cc.inputs.driver.Driver;
import com.cc.systems.Chassis;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot 
{
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
*/
    
    private Driver driver;
    private Chassis chassis;
    
    
    public void robotInit()
    {
        driver = Driver.getInstance();
        chassis = Chassis.getInstance();
        
        System.out.println("robotInit");
    }  
    
    public void autonomousInit()
    {
        
        System.out.println("autonomousInit");
    }
    
    public void disabledPeriodic() 
    {
        
        System.out.println("diabledPeriodic");
    }
    
    public void disabledInit() 
    {
       System.out.println("diabledInit"); 
        
    }
    
    public void testInit() 
    {
        System.out.println("testInit");
        
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        System.out.println("autonomousPeriodic");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        System.out.println("teleopPeriodic");
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        //Normal x and y
//        double fwd = driver.getY();
//        double sld = driver.getX();
        //Directionalized x and y
       double sld = driver.getX() * Math.cos( chassis.getGyro() ) - driver.getY() * Math.sin( chassis.getGyro() );
       double fwd = driver.getY() * Math.cos( chassis.getGyro() ) + driver.getX() * Math.sin( chassis.getGyro() );
        
//        driver.printAxes();
        // System.out.println("Y: " + driver.getY() + " X: " + driver.getX() + " ROT: " + driver.getRot());
       chassis.holoDrive( fwd, sld, driver.getRot() );
       // chassis.printGyro();
//        chassis.turnAngle( 90 );
       
    }
    
}