package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shoot extends Command {
	
	double value = 0.65;
	double targetrate =-14100;
	boolean init = true;
	boolean keepingit= false;
	double stablerate;


    public Shoot() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.fw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.fw.e.setReverseDirection(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 {
    		 //stable sate is the current rate
    		 stablerate = Robot.fw.e.getRate();
    		 System.out.println(stablerate);
    
    		 //Robot.fw.v.set(value);
    		 SmartDashboard.putNumber("value", value);
    	    	if(init){
    	    		SmartDashboard.putBoolean("init", true);
    	    		
    	    		
    	    		if(!(Math.abs(stablerate-targetrate)<200)){
    	    			if((stablerate-targetrate)>1000){
    	    				value +=0.02;
    	    				Robot.fw.v.set(-value);
    	    			}
    	    			else if((stablerate-targetrate)<1000){
    	    				value -=0.02;
    	    				Robot.fw.v.set(-value);
    	    			}
    	    			else if((stablerate-targetrate)>500){
    	    				value +=0.01;
    	    				Robot.fw.v.set(-value);
    	    			}
    	    			else if((stablerate-targetrate)<500){
    	    				value -=0.01;
    	    				Robot.fw.v.set(-value);
    	    			}
    	    			
    	    			
    	    			else{}
    	    				
    	    		}
    	    		else{
    	    		init = false;
    	    		SmartDashboard.putBoolean("init", false);
    	    		keepingit = true;
    	    		}
    	    	
    	    	}
    	    	else if(keepingit){
    	    		SmartDashboard.putBoolean("init", false);
    	    		SmartDashboard.putBoolean("keepingit", true);
    	    		SmartDashboard.putNumber("final ticks per second", Robot.fw.e.getRate());
    	    		SmartDashboard.putNumber("valllue",value);
    	    		
    	    		Robot.fw.v.set(-value);
    	    	}
    	    	
    	    	
    	    
		
		
    	
    }
    	 SmartDashboard.putNumber("Velocity", Robot.fw.e.getRate());
     	SmartDashboard.putNumber("Position", Robot.fw.e.get());
     	SmartDashboard.putNumber("flywheel set value", Robot.fw.v.get());
     	SmartDashboard.putNumber("rpm velocity", (Robot.fw.v.get()/256));
     	
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

