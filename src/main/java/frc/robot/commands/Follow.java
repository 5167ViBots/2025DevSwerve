package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class Follow extends Command{
    CommandSwerveDrivetrain drive;
    public Follow(CommandSwerveDrivetrain driveSubsystem){
        drive = driveSubsystem;
        addRequirements(drive);
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute() {
    
    double kPx = .025;

    double kPy = .025;

double xErrorRate = NetworkTableInstance.getDefault().getTable("limelight-jodie").getEntry("tx").getDouble(0);
double yErrorRate = NetworkTableInstance.getDefault().getTable("limelight-jodie").getEntry("ty").getDouble(0);

//if there's a target, follow it by trying to alight the limelight's crosshair with the april tag's crosshair 
    drive.RobotDrive(kPy*yErrorRate, -kPx*xErrorRate, 0);


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
