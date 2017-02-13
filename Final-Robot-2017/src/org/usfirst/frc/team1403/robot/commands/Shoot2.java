package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shoot2 extends Command {
	double rpm = 3304;
	double value = 0;
	double currentRate = 0;
	double targetRate = (-rpm/0.24);
    public Shoot2() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.leftShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fw.v.set(.65);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentRate = Robot.fw.e.getRate();
    	if(!(Math.abs(currentRate-targetRate)<200)){
			if((currentRate-targetRate)>1000){
				value -=0.002;
				Robot.fw.v.set(-value);
			}
			else if((currentRate-targetRate)<1000){
				value +=0.002;
				Robot.fw.v.set(-value);
			}
			else if((currentRate-targetRate)>500){
				value -=0.001;
				Robot.fw.v.set(-value);
			}
			else if((currentRate-targetRate)<500){
				value +=0.001;
				Robot.fw.v.set(-value);
			}
			
			
			
			
    	}
    	SmartDashboard.putNumber("Current Rate", currentRate);
		//SmartDashboard.putNumber("rpm based on Current Rate", currentRate);
		SmartDashboard.putNumber("Target Rate", targetRate);
		SmartDashboard.putNumber("CANtalon set value", value);
		SmartDashboard.putNumber("rpm", currentRate*0.24);
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
