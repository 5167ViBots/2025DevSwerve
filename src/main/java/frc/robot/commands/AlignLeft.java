package frc.robot.commands;

import com.ctre.phoenix6.swerve.SwerveRequest;
import com.ctre.phoenix6.swerve.SwerveRequest.RobotCentric;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.LimelightSubsystem;

public class AlignLeft extends Command{
    CommandSwerveDrivetrain drive;
    LimelightSubsystem lime;
    public AlignLeft(CommandSwerveDrivetrain driveSubsystem, LimelightSubsystem limelightSubsystem){
        drive = driveSubsystem;
        lime = limelightSubsystem;
        addRequirements(drive);
    }



    @Override
    public void initialize()
    {

    }

    @Override
    public void execute() {
    
    double kPx = .013;

    double kPy = .018;
  double leftXErrorRate = NetworkTableInstance.getDefault().getTable("limelight-lefty").getEntry("tx").getDouble(0);
  double leftYErrorRate = NetworkTableInstance.getDefault().getTable("limelight-lefty").getEntry("ty").getDouble(0);
  //If the robot has a target on the left limelight, align
if(lime.leftHasTarget()){ 
//drive.RobotDrive(-kPy*leftYErrorRate, kPx*leftXErrorRate, 0.0);
drive.RobotDrive(-0, kPx*leftXErrorRate, 0.0);
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
