package org.usfirst.frc.team1403.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//motion mapping constants
	public static double feetPerTick = 0;
	public static double wheelBaseWidthInFeet = 0;
	public static double maxVelocity = 0;
	public static double maxAcceleration = 0;
	
	//drive train ports
	public static int leftEncoder1 = 0;
	public static int leftEncoder2 = 0;
	public static int rightEncoder1 = 0;
	public static int rightEncoder2 = 0;
	public static int gyro = 0;
	
	//shooter ports
	public static int leftFlyWheel = 0;
	public static int rightFlyWheel = 0;
	public static int leftShooterEncoder1 = 0;
	public static int leftShooterEncoder2 = 0;
	public static int rightShooterEncoder1 = 0;
	public static int rightShooterEncoder2 = 0;
	
	public static double shooterRPM = 0;
	public static double rotationsPerTick = 0;
	
	//feeder ports
	public static int leftFeeder = 0;
	public static int rightFeeder = 0;
	public static double inchesPerTick = 0;
	
	//intake ports
	public static int intakeRoller = 0;
	
	//gear pusher ports
	public static int gearPusher = 0;
	
	
}
