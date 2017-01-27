package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public Victor v0 = new Victor(0);
	public Victor v1 = new Victor(1);
	public Victor v2 = new Victor(2);
	public Victor v3 = new Victor(3);
	public RobotDrive rd = new RobotDrive(v0,v1,v2,v3);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
    }
    public void tankDrive(double leftPower, double rightPower){
    	v0.set(rightPower);
    	v1.set(rightPower);
    	v2.set(-leftPower);
    	v3.set(-leftPower);
    }
}

