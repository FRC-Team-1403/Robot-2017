package org.usfirst.frc.team1403.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1403.robot.commands.ExampleCommand;
import org.usfirst.frc.team1403.robot.commands.IntakeBrush;

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
	public Joystick djoy = new Joystick(0);
	public Joystick ojoy = new Joystick(1);
	Button Xojoy = new JoystickButton(ojoy, 3);
	

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:
	public OI(){
	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	Xojoy.whileHeld(new IntakeBrush());
	
	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// Xojoy.whileHeld(new IntakeBrush());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
}
