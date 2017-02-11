package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
	
	//TODO make sure rollers move in the correct direction
	public CANTalon leftFeeder;
	public CANTalon rightFeeder;
	
	public Feeder() {
		leftFeeder = new CANTalon(RobotMap.leftFeeder);
		rightFeeder = new CANTalon(RobotMap.rightFeeder);
	}
	
	public void startLeft() {
		leftFeeder.set(1);
	}
	
	public void startRight() {
		rightFeeder.set(1);
	}
	
	public void startBoth() {
		leftFeeder.set(1);
		rightFeeder.set(1);
	}
	
	public void stopLeft() {
		leftFeeder.set(0);
	}
	
	public void stopRight() {
		rightFeeder.set(0);
	}
	
	public void stopBoth() {
		leftFeeder.set(0);
		rightFeeder.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

