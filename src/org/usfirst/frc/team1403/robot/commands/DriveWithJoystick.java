package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command {

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//negative because the pixel xy plane starts from the top - Alex... yeah just ignore this
    	if(Robot.oi.djoy.getRawButton(6)) {
    		Robot.driveTrain.setLeftRightPower(-Robot.oi.djoy.getRawAxis(1), -Robot.oi.djoy.getRawAxis(5), .5);
    	}
    	else {
    		Robot.driveTrain.setLeftRightPower(-Robot.oi.djoy.getRawAxis(1), -Robot.oi.djoy.getRawAxis(5));
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
