package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.commands.DriveAuto;
import org.usfirst.frc.team1403.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Victor v0 = new Victor(0);
	public Victor v1 = new Victor(1);
	public Victor v2 = new Victor(2);
	public Victor v3 = new Victor(3);
	public Encoder leftEncoder = new Encoder(0, 1);
	public Encoder rightEncoder = new Encoder(2, 3);
	public AnalogGyro gyro = new AnalogGyro(0);
	public Timer timer;
	public double pastVelocity = 0;
	public double pastTime = 0;
	public double maxAcceleration;
	
	public DriveTrain(){
		gyro.reset();
		leftEncoder.setReverseDirection(true);
		rightEncoder.setReverseDirection(true);
		leftEncoder.setDistancePerPulse((Math.PI/384));
		rightEncoder.setDistancePerPulse((Math.PI/384));
		timer = new Timer();
		timer.start();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void setLeftRightPower(double leftPower, double rightPower)
    {
    	v0.set(rightPower);
    	//v1.set(rightPower);
    	v2.set(-leftPower);
    	//v3.set(-leftPower);
    }
    
    public double getAngleInRadians() {
    	
    	double angle = gyro.getAngle();
    	angle *= Math.PI/180;
    	return angle;
    }
    
    public double getLeftEncoderInFeet() {
    	return leftEncoder.get() * Math.PI/384;
    }
    
    public double getRightEncoderInFeet() {
    	return rightEncoder.get() * Math.PI/384;
    }
    
    public double getVelocity() {
    	
    	double vLeft = leftEncoder.getRate();
    	double vRight = rightEncoder.getRate();
    	return (vLeft+vRight)/2;
    }
    public double getAcceleration() {
    	double acceleration;
    	double currentVelocity = this.getVelocity();
    	double currentTime = timer.get();
    	acceleration = (currentVelocity - pastVelocity) / (currentTime - pastTime);
    	pastVelocity = currentVelocity;
    	pastTime = currentTime;
    	System.out.println("pastTime: " + pastTime);
    	System.out.println("currentTime: " + currentTime);
    	System.out.println("acceleration: " + acceleration);
    	System.out.println("currentVelocity: " + currentVelocity);
    	System.out.println("pastVelocity: " + pastVelocity);
    	return acceleration;
    	
    	
    }
    
}
    
    


