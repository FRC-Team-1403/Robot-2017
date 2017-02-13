package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Align2 extends Command {

	public double h2;
	
    public Align2() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveT);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    Robot.hd2 = SmartDashboard.getNumber("horizontal distance", 321);
   	Robot.DriveT.gyro.reset();	
    h2 = Robot.hd2;
    
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.x = SmartDashboard.getNumber("difference", 1111111);
    	Robot.w = SmartDashboard.getNumber("width", 1111111);
    	System.out.println(Robot.DriveT.gyro.getAngle());
    	System.out.print(h2);
    	if (h2 < 0){
    	System.out.println(Robot.DriveT.gyro.getAngle());
    		
    		if (Robot.DriveT.gyro.getAngle() >=-87 && Robot.DriveT.gyro.getAngle() <= 87){

    		Robot.DriveT.motor0.set(0.5);
    		Robot.DriveT.motor1.set(0.5);
    		Robot.DriveT.motor2.set(0.5);
    		Robot.DriveT.motor3.set(0.5);

    		}
    		
    		else {
    			
    			Robot.DriveT.motor0.stopMotor();
        		Robot.DriveT.motor1.stopMotor();
        		Robot.DriveT.motor2.stopMotor();
        		Robot.DriveT.motor3.stopMotor();
    		}
   
    	}
    	
    		 
   	
    } 

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	 	if (Robot.x > -10 && Robot.x < 10 && Robot.w >= 26) { //if in range
	 		System.out.println("done");
	 		return true;
	 	}	
	 	
	 	else	{
	 		return false;
	 	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
