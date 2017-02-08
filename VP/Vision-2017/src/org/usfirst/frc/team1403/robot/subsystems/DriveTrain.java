package org.usfirst.frc.team1403.robot.subsystems;

import org.usfirst.frc.team1403.robot.commands.Drive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public Victor motor0 = new Victor(0);
	public Victor motor1= new Victor(1);
	public Victor motor2 = new Victor(2);
	public Victor motor3 = new Victor(3);
	public Encoder coder1 = new Encoder(2, 3, true);
	public AnalogGyro gyro = new AnalogGyro(0);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
}

