package frc.robot.commands;

import com.ctre.phoenix6.swerve.SwerveRequest;
import com.ctre.phoenix6.swerve.SwerveRequest.RobotCentric;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.LimelightSubsystem;

public class AlignBack extends Command{
public class AlignBack extends Command{
    CommandSwerveDrivetrain drive;
    LimelightSubsystem lime;
    public AlignBack(CommandSwerveDrivetrain driveSubsystem, LimelightSubsystem limelightSubsystem){
    CommandPS5Controller joystick;
    public AlignBack(CommandSwerveDrivetrain driveSubsystem, LimelightSubsystem limelightSubsystem){
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

    double backXErrorRate = NetworkTableInstance.getDefault().getTable("limelight-righty").getEntry("tx").getDouble(0);
    double backYErrorRate = NetworkTableInstance.getDefault().getTable("limelight-righty").getEntry("ty").getDouble(0);
    //If the robot has a target on the right limelight, alight
    if(lime.backHasTarget()){
    //drive.RobotDrive(-kPy*rightYErrorRate, kPx*rightXErrorRate, 0.0);
    drive.RobotDrive(-joystick.getLeftY(), kPx*backXErrorRate, 0.0);
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
