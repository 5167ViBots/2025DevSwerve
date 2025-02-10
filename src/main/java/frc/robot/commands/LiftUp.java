// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.LiftSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

// This is where the LiftUp command is clarified

/** An example command that uses an example subsystem. */
public class LiftUp extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LiftSubsystem liftsubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LiftUp(LiftSubsystem subsystem) {
    liftsubsystem = subsystem;
    System.out.println("LiftUpCommandSubsystem");

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (liftsubsystem.IsUpSafe())
    {
    liftsubsystem.liftUp();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    liftsubsystem.liftStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !liftsubsystem.IsUpSafe();
  }
}
