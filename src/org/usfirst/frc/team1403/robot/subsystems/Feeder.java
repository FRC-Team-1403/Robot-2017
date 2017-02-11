package org.usfirst.frc.team1403.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
	
	//TODO make sure rollers move in the correct direction
	public CANTalon roller;
	
	public Feeder(int port) {
		roller = new CANTalon(port);
	}
	
	public void start() {
		roller.set(1);
	}
	
	public void stop() {
		roller.set(0);
	}
	
	public void goReverse() {
		roller.set(-1);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

