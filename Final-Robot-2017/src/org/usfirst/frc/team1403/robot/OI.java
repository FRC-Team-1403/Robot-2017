package org.usfirst.frc.team1403.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc.team1403.robot.commands.ArcadeDrive;
import org.usfirst.frc.team1403.robot.commands.ExampleCommand;


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
	
	//djoy is the driver's configuration at competition
	public Joystick djoy = new Joystick(0);
	public JoystickButton djoyA = new JoystickButton(djoy, 1);
	public JoystickButton djoyB = new JoystickButton(djoy, 2);
	public JoystickButton djoyX = new JoystickButton(djoy, 3);
	public JoystickButton djoyY = new JoystickButton(djoy, 4);
	public JoystickButton djoyL = new JoystickButton(djoy, 5);
	public JoystickButton djoyR = new JoystickButton(djoy, 6);
	public JoystickButton djoyBack = new JoystickButton(djoy, 7);
	public JoystickButton djoyStart = new JoystickButton(djoy, 8);
	
	//ojoy is the operator's configuration at competition
	//only bind necessary functionality to ojoy, like command groups
	//do not bind basic functionality that wouldn't be used in a match, do that in tjoy
	public Joystick ojoy = new Joystick(1);
	public JoystickButton ojoyA = new JoystickButton(ojoy, 1);
	public JoystickButton ojoyB = new JoystickButton(ojoy, 2);
	public JoystickButton ojoyX = new JoystickButton(ojoy, 3);
	public JoystickButton ojoyY = new JoystickButton(ojoy, 4);
	public JoystickButton ojoyL = new JoystickButton(ojoy, 5);
	public JoystickButton ojoyR = new JoystickButton(ojoy, 6);
	public JoystickButton ojoyBack = new JoystickButton(ojoy, 7);
	public JoystickButton ojoyStart = new JoystickButton(ojoy, 8);
	
	//tjoy is for testing purposes
	//bind all the basic functionality of all the subsystems except the drive train to here
	//if something breaks or needs to be tested, plug a joystick into port 2 in order to access test commands
	//tjoy should not be used during matches
	public Joystick tjoy = new Joystick(2);
	public JoystickButton tjoyA = new JoystickButton(tjoy, 1);
	public JoystickButton tjoyB = new JoystickButton(tjoy, 2);
	public JoystickButton tjoyX = new JoystickButton(tjoy, 3);
	public JoystickButton tjoyY = new JoystickButton(tjoy, 4);
	public JoystickButton tjoyL = new JoystickButton(tjoy, 5);
	public JoystickButton tjoyR = new JoystickButton(tjoy, 6);
	public JoystickButton tjoyBack = new JoystickButton(tjoy, 7);
	public JoystickButton tjoyStart = new JoystickButton(tjoy, 8);
	
	public OI(){
		//bind buttons to commands
		
	}
}
