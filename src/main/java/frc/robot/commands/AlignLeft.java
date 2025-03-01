package frc.robot.commands;

import java.util.function.Supplier;

import com.ctre.phoenix6.swerve.SwerveRequest;
import com.ctre.phoenix6.swerve.SwerveRequest.RobotCentric;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.LimelightSubsystem;

public class AlignLeft extends Command{
    CommandSwerveDrivetrain drive;
    LimelightSubsystem lime;
    Supplier<Double> _ControllerInput;

    public AlignLeft(CommandSwerveDrivetrain driveSubsystem, LimelightSubsystem limelightSubsystem, Supplier<Double> ControllerInput ){
        drive = driveSubsystem;
        lime = limelightSubsystem;
        _ControllerInput = ControllerInput;
        addRequirements(drive);
    }



    @Override
    public void initialize()
    {

    }
    PIDController yawController = new PIDController(.006, 0.001, 0);
    PIDController LRController = new PIDController(.03, 0.001, 0);
    @Override
    public void execute() {
    
    double kPx = .03;
    double kRotate = .006;
    double kPy = .018;
  double leftXErrorRate = NetworkTableInstance.getDefault().getTable("limelight-lefty").getEntry("tx").getDouble(0);
  double leftYErrorRate = NetworkTableInstance.getDefault().getTable("limelight-lefty").getEntry("ty").getDouble(0);
  double[] zero = {0,0,0,0,0,0};
  
  double yaw = NetworkTableInstance.getDefault().getTable("limelight-lefty").getEntry("targetpose_robotspace").getDoubleArray(zero)[4];
  //If the robot has a target on the left limelight, align
  SmartDashboard.putNumber("Yaw", yaw);
if(lime.leftHasTarget()){ 
  double SetDriveValue = _ControllerInput.get();
  if (Math.abs(SetDriveValue) < .1)
      SetDriveValue = 0;
//drive.RobotDrive(-kPy*leftYErrorRate, kPx*leftXErrorRate, 0.0);   
  drive.RobotDrive(SetDriveValue, -LRController.calculate(leftYErrorRate), yawController.calculate(yaw));

}
else {
  drive.RobotDrive(0, 0, 0);
}

    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drive.RobotDrive(0, 0, 0);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
