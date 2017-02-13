package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class moveBackward extends Command {

    public moveBackward() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveT);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 
    	Robot.DriveT.motor0.set(-0.2);
    	Robot.DriveT.motor1.set(-0.2);
    	Robot.DriveT.motor2.set(0.2);
    	Robot.DriveT.motor3.set(0.2);
    
    
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
