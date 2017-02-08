package org.usfirst.frc.team1403.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1403.robot.commands.Align;
import org.usfirst.frc.team1403.robot.commands.Align2;
import org.usfirst.frc.team1403.robot.commands.ExampleCommand;
import org.usfirst.frc.team1403.robot.commands.moveBackward;
import org.usfirst.frc.team1403.robot.commands.moveForward;

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
	 public Button button5 = new JoystickButton(stick, 5);
	 public Button button1 = new JoystickButton(stick, 1);
	 public Button button2 = new JoystickButton(stick, 2);
	 public Button button6 = new JoystickButton(stick, 6);

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
	
	 public OI() {
	 button5.whileHeld(new Align());
	 button1.whileHeld(new moveForward());
	 button2.whileHeld(new moveBackward());
	 button6.whileHeld(new Align2());
	 }
	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
