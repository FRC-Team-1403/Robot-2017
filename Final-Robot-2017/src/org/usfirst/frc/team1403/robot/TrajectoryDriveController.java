package org.usfirst.frc.team1403.robot;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import trajectoryLib.trajectory.Trajectory;
import trajectoryLib.trajectory.TrajectoryFollower;
import trajectoryLib.util.ChezyMath;
/**
 * TrajectoryDriveController.java
 * This controller drives the robot along a specified trajectory.
 * @author Tom Bottiglieri
 */
public class TrajectoryDriveController {

	
	
  public TrajectoryDriveController() {
    init();
  }
  
  public TrajectoryDriveController(double kV, double kA, double kP, double kTurn) {
	  followerLeft.configure(kP, 0, 0, kV, kA);
	  followerRight.configure(kP, 0, 0, kV, kA);
	  this.kTurn = kTurn;
  }
  
  Trajectory trajectory;
  TrajectoryFollower followerLeft = new TrajectoryFollower();
  TrajectoryFollower followerRight = new TrajectoryFollower();
  double direction;
  double heading;
  public double kTurn = 0;
  boolean enabled = false;

  public boolean onTarget() {
    return followerLeft.isFinishedTrajectory(); 
  }

  private void init() {
    followerLeft.configure(0, 0, 0, 1.0/1.0, 1.0/10.0);
    followerRight.configure(0, 0, 0, 1.0/1.0, 1.0/10.0);
  }

  public void loadProfile(Trajectory leftProfile, Trajectory rightProfile, double direction, double heading) {
    reset();
    followerLeft.setTrajectory(leftProfile);
    followerRight.setTrajectory(rightProfile);
    this.direction = direction;
    this.heading = heading;
  }
  
  public void loadProfileNoReset(Trajectory leftProfile, Trajectory rightProfile) {
    followerLeft.setTrajectory(leftProfile);
    followerRight.setTrajectory(rightProfile);
  }

  public void reset() {
    followerLeft.reset();
    followerRight.reset();
    Robot.driveTrain.leftEncoder.reset();
    Robot.driveTrain.rightEncoder.reset();
  }
  
  public int getNumSegments() {
	  	//originally had followerLeft.getNumSegments in 254's code but that give us error
	    return getNumSegments();
  }
  
  public int getFollowerCurrentSegment() {
    return followerLeft.getCurrentSegment();
  }
  
  public void update() {
    if (!enabled) {
      return ;
    }

    if (onTarget()) {
      Robot.driveTrain.setLeftRightPower(0.0, 0.0);
    } else  {
      double distanceL = direction * Robot.driveTrain.getLeftPosition();
      double distanceR = direction * Robot.driveTrain.getRightPosition();

      double speedLeft = direction * followerLeft.calculate(distanceL);
      double speedRight = direction * followerRight.calculate(distanceR);
      
      double goalHeading = followerLeft.getHeading();
      double observedHeading = Robot.driveTrain.getAngleInRadians();

      double angleDiffRads = ChezyMath.getDifferenceInAngleRadians(observedHeading, goalHeading);
      double angleDiff = Math.toDegrees(angleDiffRads);

      double turn = kTurn * angleDiff;
      Robot.driveTrain.setLeftRightPower(speedLeft + turn, speedRight - turn);
     // Robot.dt.setLeftRightPower(speedLeft, speedRight);
      SmartDashboard.putNumber("Left Velocity from algorithm", followerLeft.segmentVel);
      SmartDashboard.putNumber("Right Velocity from algorithm", followerRight.segmentVel);
      
      SmartDashboard.putNumber("Left Position from algorithm", followerLeft.segmentPos);
      SmartDashboard.putNumber("Right Position from algorithm", followerRight.segmentPos);
      
      SmartDashboard.putNumber("speedLeft", speedLeft);
      SmartDashboard.putNumber("speedRight", speedRight);
      
      SmartDashboard.putNumber("Left "
      		+ ""
      		+ "Error", followerLeft.last_error_);
      SmartDashboard.putNumber("Right Error", followerRight.last_error_);
      //SmartDashboard.putNumber("speedLeft + turn", speedLeft + turn);
      //SmartDashboard.putNumber("speedRight - turn", speedRight - turn);
    }
  }

  public void setTrajectory(Trajectory t) {
    this.trajectory = t;
  }

  public double getGoal() {
    return 0;
  }

  public void enable() {
	    enabled = true;
	  }
	  
	  public void disable() {
	    enabled = false;
	  }

	  public boolean enabled() {
	    return enabled;
	  }
}