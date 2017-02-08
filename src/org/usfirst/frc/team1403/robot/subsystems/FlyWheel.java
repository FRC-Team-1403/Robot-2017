package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.commands.JustTesting;
import org.usfirst.frc.team1403.robot.commands.Shoot;
import org.usfirst.frc.team1403.robot.commands.Shoot2;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlyWheel extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon wheel;
	public Encoder encoder;
	public FlyWheel(int wheelPort, int encoderPort1, int encoderPort2)
	{
		wheel = new CANTalon(wheelPort);
		encoder = new Encoder(encoderPort1, encoderPort2);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Shoot2());
    }
}

