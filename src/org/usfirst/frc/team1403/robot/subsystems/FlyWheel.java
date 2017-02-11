package org.usfirst.frc.team1403.robot.subsystems;


import org.usfirst.frc.team1403.robot.RobotMap;
import org.usfirst.frc.team1403.robot.commands.Shoot;
import org.usfirst.frc.team1403.robot.commands.Shoot2;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlyWheel extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon leftShooter;
	public CANTalon rightShooter;
	
	public FlyWheel() {
		leftShooter = new CANTalon(RobotMap.leftWheel);
		rightShooter = new CANTalon(RobotMap.rightWheel);
	}
	
	public void stop() {
		leftShooter.set(0);
		rightShooter.set(0);
	}
	
	//TODO make sure getAnalogInVelocity works
	public double getLeftRPM() {
		return leftShooter.getAnalogInVelocity();
	}
	
	public double getRightRPM() {
		return rightShooter.getAnalogInVelocity();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand();
    }
    
    
}

