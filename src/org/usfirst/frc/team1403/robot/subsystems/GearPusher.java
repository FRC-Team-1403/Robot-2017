package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPusher extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//TODO make sure the boolean for the solenoid is correct
	Solenoid pusher;
	
	public GearPusher() {
		pusher = new Solenoid(RobotMap.gearPusher);
	}
	
	public void push() {
		pusher.set(true);
	}
	
	public void retract() {
		pusher.set(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

