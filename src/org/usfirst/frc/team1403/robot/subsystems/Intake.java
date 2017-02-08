package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public CANTalon roller;
	
	public Intake() {
		roller = new CANTalon(RobotMap.intakeRoller);
	}
	
	public void rollersIn() {
		roller.set(1);
	}
	
	public void rollersOut() {
		roller.set(-1);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

