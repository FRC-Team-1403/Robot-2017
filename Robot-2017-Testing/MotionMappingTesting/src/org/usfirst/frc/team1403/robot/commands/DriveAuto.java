package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import trajectoryLib.trajectory.TrajectoryDriveController;

/**
 *
 */
public class DriveAuto extends Command {
	
	TrajectoryDriveController driveController = new TrajectoryDriveController();
	

    public DriveAuto() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dt.leftEncoder.reset();
    	Robot.dt.rightEncoder.reset();
    	Robot.dt.gyro.reset();
    	driveController.loadProfile(Robot.lowBarPath.getLeftWheelTrajectory(), Robot.lowBarPath.getRightWheelTrajectory(), 1.0, Robot.dt.gyro.getAngle());
    	//okay this might screw you later lol
    	driveController.kTurn = SmartDashboard.getNumber("kTurn", 0);
    	driveController.enable();
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//we dk if we need this lmao
    	//driveController.loadProfileNoReset(Robot.lowBarPath.getLeftWheelTrajectory(), Robot.lowBarPath.getRightWheelTrajectory());
    	driveController.update();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return driveController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveController.disable();
    	Robot.dt.setLeftRightPower(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
