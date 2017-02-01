package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveT);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    

    Robot.DriveT.motor2.set(-Robot.oi.stick.getRawAxis(1)*0.7);
   	Robot.DriveT.motor3.set(-Robot.oi.stick.getRawAxis(1)*0.7);
	Robot.DriveT.motor0.set(Robot.oi.stick.getRawAxis(5)*0.7);
	Robot.DriveT.motor1.set(Robot.oi.stick.getRawAxis(5)*0.7);
	
    }
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
