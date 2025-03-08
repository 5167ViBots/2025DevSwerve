package frc.robot.commands;

import java.util.function.Supplier;

import com.ctre.phoenix6.swerve.SwerveRequest;
import com.ctre.phoenix6.swerve.SwerveRequest.RobotCentric;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.LimelightSubsystem;

public class AlignRight extends Command{
    CommandSwerveDrivetrain drive;
    LimelightSubsystem lime;

    Supplier<Double> _ControllerInput; 
    public AlignRight(CommandSwerveDrivetrain driveSubsystem, LimelightSubsystem limelightSubsystem, Supplier<Double> ControllerInput){
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

    double[] zero = {0,0,0,0,0,0};

    
  
    double yaw = NetworkTableInstance.getDefault().getTable("limelight-righty").getEntry("targetpose_robotspace").getDoubleArray(zero)[4];
    
    double rightXErrorRate = NetworkTableInstance.getDefault().getTable("limelight-righty").getEntry("tx").getDouble(0);
    double rightYErrorRate = NetworkTableInstance.getDefault().getTable("limelight-righty").getEntry("ty").getDouble(0);
    //If the robot has a target on the right limelight, alight
    if(lime.rightHasTarget()){
        double SetDriveValue = _ControllerInput.get();
        if (Math.abs(SetDriveValue) < .1)
            SetDriveValue = 0;
    //drive.RobotDrive(-kPy*rightYErrorRate, kPx*rightXErrorRate, 0.0);
    drive.RobotDrive(SetDriveValue, -LRController.calculate(rightXErrorRate), -yawController.calculate(yaw));
    }
    else
    {
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
