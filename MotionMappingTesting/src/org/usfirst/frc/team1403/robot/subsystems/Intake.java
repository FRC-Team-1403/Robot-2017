package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.commands.LiftBar;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public DoubleSolenoid bar = new DoubleSolenoid(5,1);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new LiftBar());
    }
}

