package org.usfirst.frc.team1403.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1403.robot.commands.Drive;
//import org.usfirst.frc.team1403.robot.commands.ArcadeDrive;
import org.usfirst.frc.team1403.robot.commands.ExampleCommand;
import org.usfirst.frc.team1403.robot.commands.FixedRPM;
import org.usfirst.frc.team1403.robot.commands.HalfSpeed;
import org.usfirst.frc.team1403.robot.commands.Intaking;
import org.usfirst.frc.team1403.robot.commands.OtherWay;
import org.usfirst.frc.team1403.robot.commands.Shoot;
import org.usfirst.frc.team1403.robot.commands.Shoot2;
import org.usfirst.frc.team1403.robot.commands.StopIntake;
import org.usfirst.frc.team1403.robot.commands.StopShooting;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	public Joystick stick = new Joystick(0);
	public Joystick stick2 = new Joystick(1);
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	JoystickButton ojoybuttona,ojoybuttonlt,ojoybuttonrt,djoybuttonrt;
	public OI(){
		ojoybuttonrt = new JoystickButton(stick2, 6);
		ojoybuttonrt.whileHeld((new Intaking()));
		ojoybuttonrt.whenReleased(new StopIntake());
		ojoybuttona = new JoystickButton(stick2, 1);
		ojoybuttona.whileHeld(new Shoot2());
		ojoybuttona.whenReleased(new StopShooting());
		ojoybuttonlt = new JoystickButton(stick2, 5);
		ojoybuttonlt.whileHeld(new OtherWay());
		ojoybuttonlt.whenReleased(new StopIntake());
		djoybuttonrt = new JoystickButton(stick, 6);
		djoybuttonrt.whileHeld((new HalfSpeed()));
		//djoybuttonrt.whenReleased(new Drive());
	}
}
