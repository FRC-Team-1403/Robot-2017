package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Align extends Command {

    public Align() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveT);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.x = SmartDashboard.getNumber("difference", 1111111);
    	Robot.w = SmartDashboard.getNumber("width", 1111111);
   
    /* if (Robot.x > -5 && Robot.x < 5) { //if in range
    		    		
   	    		Robot.DriveT.motor0.stopMotor();
   	    		Robot.DriveT.motor1.stopMotor();
   	    		Robot.DriveT.motor2.stopMotor();
   	    		Robot.DriveT.motor3.stopMotor();
   	    		return;    		    	
        	}
    		    	
       	if (Robot.x <= -5){
    		    		

        	System.out.println("Move right");
        	Robot.DriveT.motor2.set(0.3);
        	Robot.DriveT.motor3.set(0.3);
        	Robot.DriveT.motor1.set(0.3);
        	Robot.DriveT.motor0.set(0.3);
        	
       	}
    		    	
       	if (Robot.x >= 5){	
    		    		
       		System.out.println("Move left");
      		Robot.DriveT.motor0.set(-0.3);
       		Robot.DriveT.motor1.set(-0.3);
       		Robot.DriveT.motor2.set(-0.3);
       		Robot.DriveT.motor3.set(-0.3);
    		 
       	} */
    
 
  //  Robot.DriveT.motor0.set(speed);	
    
    if (Robot.x > -10 && Robot.x < 10 && Robot.w >= 26) { //if in range
    		
	    		
	   	Robot.DriveT.motor0.stopMotor();
 		Robot.DriveT.motor1.stopMotor();
	  	Robot.DriveT.motor2.stopMotor();
   		Robot.DriveT.motor3.stopMotor();
	   		return;    		    	
    	}
   
   if (Robot.x > -10 && Robot.x < 10 && Robot.w  < 26) { //if in range
		
		
		Robot.DriveT.motor0.set(0.2);
		Robot.DriveT.motor1.set(0.2);
		Robot.DriveT.motor2.set(-0.2);
		Robot.DriveT.motor3.set(-0.2);
}
		    	
   	if (Robot.x >= -10 && Robot.w  < 26){
		    		

    //	System.out.println("Move right");
    	Robot.DriveT.motor2.set(-0.35);
    	Robot.DriveT.motor3.set(-0.35);
    	Robot.DriveT.motor1.set(0.06);
    	Robot.DriveT.motor0.set(0.06);
    	
   	}
		    	
   	if (Robot.x <= 10 && Robot.w  < 26){	
		    		
   	//	System.out.println("Move left");
  		Robot.DriveT.motor0.set(0.35);
   		Robot.DriveT.motor1.set(0.35);
   		Robot.DriveT.motor2.set(-0.06);
   		Robot.DriveT.motor3.set(-0.06);
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
