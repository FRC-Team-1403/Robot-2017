package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.Robot;
import org.usfirst.frc.team1403.robot.commands.ShootWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FlyWheel extends Subsystem {
	public CANTalon fw = new CANTalon(4);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShootWithJoystick());
    }
    
    public void ShootingWithSmartDashBoard()
    {
    	 fw.set(SmartDashboard.getNumber("Shooter Speed", 0));
    }
    public void ShootingWithJoystick(double joystickShoot){
    	this.fw.set(joystickShoot);
    }
}

