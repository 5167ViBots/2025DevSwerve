// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.IntakeSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;

// This is where the AlgaeIn command is clarified 

/** An example command that uses an example subsystem. */
public class SwitchDriveMode extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final CommandSwerveDrivetrain drive;

  /**
   * Creates a new AlgaeIn.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SwitchDriveMode(CommandSwerveDrivetrain subsystem) {
    drive = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }
  
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  Boolean RunOnce = true;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {    
    if (RunOnce)
    drive.SwitchDriveOrientation();
    RunOnce = false;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
