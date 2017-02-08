
package org.usfirst.frc.team1403.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import trajectoryLib.*;
import trajectoryLib.trajectory.Path;
import trajectoryLib.trajectory.PathGenerator;
import trajectoryLib.trajectory.TrajectoryGenerator;
import trajectoryLib.trajectory.WaypointSequence;
import trajectoryLib.trajectory.WaypointSequence.Waypoint;
import org.usfirst.frc.team1403.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team1403.robot.commands.DriveAuto;
///import org.usfirst.frc.team1403.robot.commands.ExampleCommand;
import org.usfirst.frc.team1403.robot.subsystems.DriveTrain;
//import org.usfirst.frc.team1403.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain dt;
	public static OI oi;
	public static Path lowBarPath;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//SmartDashboard.putNumber("kTurn", 0);
		dt = new DriveTrain();
		oi = new OI();
		TrajectoryGenerator.Config config = new TrajectoryGenerator.Config();
		double kWheelbaseWidth = 23.5/12;
		config.dt = 0.02;
		config.max_acc = 30.0;
		config.max_jerk = 40.0;
		config.max_vel = 9.0;
		String path_name = "LowBarPath";
		WaypointSequence waypointsequence = new WaypointSequence(10);
		waypointsequence.addWaypoint(new Waypoint(0, 0, 0));
		waypointsequence.addWaypoint(new Waypoint(0.5, 0.5, 0));
		//waypointsequence.addWaypoint(new Waypoint(1, 1, Math.PI/4));
		lowBarPath = PathGenerator.makePath(waypointsequence, config, kWheelbaseWidth, path_name);
		//chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		//autonomousCommand = new ExampleCommand();
		
		 String autoSelected = SmartDashboard.getString("Auto Selector",
		 "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 = new DriveAuto(); break; case "Default Auto": default:
		 autonomousCommand = new DriveAuto(); break; }
		
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null);
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder Value", Robot.dt.leftEncoder.get());
		SmartDashboard.putNumber("Right Encoder Value", Robot.dt.rightEncoder.get());
		SmartDashboard.putNumber("Gyro Value", Robot.dt.getAngleInRadians());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
