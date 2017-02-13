package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.RobotMap;

import org.usfirst.frc.team1403.robot.commands.DriveWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANTalon motor0;
    private CANTalon motor1; 
    private CANTalon motor2; 
    private CANTalon motor3;
    
    public Encoder leftEncoder, rightEncoder;
    
    public AnalogGyro gyro;
    
    //used to change setLeftRightPower
    private boolean isReversed;
    
    public DriveTrain()
    {
    	motor0 = new CANTalon(0);
    	motor1 = new CANTalon(1);
    	motor2 = new CANTalon(2);
    	motor3 = new CANTalon(3);
    	isReversed = false;
    	
    	//the encoders and gyro use the ports in robotmap
    	leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
    	rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
    	gyro = new AnalogGyro(RobotMap.gyro);
    	
    	//Set the distance per pulse as the feet per tick ratio in order to use feet for all motion mapping calculations
    	leftEncoder.setDistancePerPulse(RobotMap.feetPerTick);
    	rightEncoder.setDistancePerPulse(RobotMap.feetPerTick);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
        
    }
    
    //edits the setLeftRightPower method to treat the side of the robot with the gear holder as the front
    public void makeGearHolderFront() {
    	isReversed = false;
    }
    
    //edits the setLeftRightPower method to treat the side of the robot with the intake as the front
    public void makeIntakeFront() {
    	isReversed = true;
    }
    
  //don't set the motors directly; always use this method because it sets the motors differently based off of which side of the robot is considered the front
    public void setLeftRightPower(double leftPower, double rightPower)
    {
	   if(!isReversed){
		   motor0.set(-leftPower);
		   motor1.set(-leftPower);
		   motor2.set(rightPower);
		   motor3.set(rightPower);
	   }
	   else {
		   motor2.set(-leftPower);
		   motor3.set(-leftPower);
		   motor0.set(rightPower);
		   motor1.set(rightPower);
	   }
	   
    }
    
    //third parameter adjusts the power by a multiplier
    //useful for half speed button, mutliplier from SmartDashboard, etc.
    //don't make a multiplier negative, use the makeGearHolderFront() and makeIntakeFront() methods
    public void setLeftRightPower(double leftPower, double rightPower, double multiplier)
    {
	   if(!isReversed){
		   motor0.set(-leftPower*multiplier);
		   motor1.set(-leftPower*multiplier);
		   motor2.set(rightPower*multiplier);
		   motor3.set(rightPower*multiplier);
	   }
	   else {
		   motor2.set(-leftPower*multiplier);
		   motor3.set(-leftPower*multiplier);
		   motor0.set(rightPower*multiplier);
		   motor1.set(rightPower*multiplier);
	   }
	   
    }
    
    //encoder values all in feet for motion mapping
    
    public double getLeftPosition() {
    	return leftEncoder.getDistance();
    }
    
    public double getRightPosition() {
    	return rightEncoder.getDistance();
    }
    
    public double getLeftVelocity() {
    	return leftEncoder.getRate();
    }
    
    public double getRightVelocity() {
    	return rightEncoder.getRate();
    }
    
    public double getAngleInRadians() {
    	return gyro.getAngle() * Math.PI/180;
    }
    
}

