package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWithJoystick extends Command {

	double maxAcceleration = 0;
	double maxVelocity = 0;
	
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.dt);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.setLeftRightPower(Robot.oi.stick.getRawAxis(1), Robot.oi.stick.getRawAxis(5));
		SmartDashboard.putNumber("gyro murray", Robot.dt.gyro.getAngle());
		SmartDashboard.putNumber("Velocity", Math.abs(Robot.dt.getVelocity()));
		SmartDashboard.putNumber("Acceleration", Math.abs(Robot.dt.getAcceleration()));
		//Pi/384 = feet per tick
		//384/PI = ticks per feet (about 122.23 ticks per feet)
		
		if(Math.abs(Robot.dt.getAcceleration()) > Robot.dt.maxAcceleration) {
			Robot.dt.maxAcceleration = Robot.dt.getAcceleration();
		}else{
			System.out.println(Math.abs(Robot.dt.getAcceleration()) + "is less than " + maxAcceleration);
		}
		SmartDashboard.putNumber("Max Acceleration", Robot.dt.maxAcceleration);
		
		if(Robot.dt.getVelocity() > maxVelocity) {
			maxVelocity = Robot.dt.getVelocity();
		}
		SmartDashboard.putNumber("Max Velocity", maxVelocity);

		
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
