package trajectoryLib.trajectory;

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
  Trajectory trajectory;
  TrajectoryFollower followerLeft = new TrajectoryFollower();
  TrajectoryFollower followerRight = new TrajectoryFollower();
  double direction;
  double heading;
  double kTurn = -3.0/80.0;
  boolean enabled = false;

  public boolean onTarget() {
    return followerLeft.isFinishedTrajectory(); 
  }

  private void init() {
    followerLeft.configure(1.5, 0, 0, 1.0/15.0, 1.0/34.0);
    followerRight.configure(1.5, 0, 0, 1.0/15.0, 1.0/34.0);
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
    Robot.dt.leftEncoder.reset();
    Robot.dt.rightEncoder.reset();
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
      Robot.dt.setLeftRightPower(0.0, 0.0);
    } else  {
      double distanceL = direction * Robot.dt.leftEncoder.get();
      double distanceR = direction * Robot.dt.rightEncoder.get();

      double speedLeft = direction * followerLeft.calculate(distanceL);
      double speedRight = direction * followerRight.calculate(distanceR);
      
      double goalHeading = followerLeft.getHeading();
      double observedHeading = Robot.dt.getAngleInRadians();

      double angleDiffRads = ChezyMath.getDifferenceInAngleRadians(observedHeading, goalHeading);
      double angleDiff = Math.toDegrees(angleDiffRads);

      double turn = kTurn * angleDiff;
      //Robot.dt.setLeftRightPower(speedLeft + turn, speedRight - turn);
      Robot.dt.setLeftRightPower(speedLeft, speedRight);
      SmartDashboard.putNumber("speedLeft", speedLeft);
      SmartDashboard.putNumber("speedRight", speedRight);
      SmartDashboard.putNumber("speedLeft + turn", speedLeft + turn);
      SmartDashboard.putNumber("speedRight - turn", speedRight - turn);
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