// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.IntakeSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;

// This is where the AlgaeIn command is clarified 

/** An example command that uses an example subsystem. */
public class DefaultDriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final CommandSwerveDrivetrain drive;

  /**
   * Creates a new AlgaeIn.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DefaultDriveCommand(CommandSwerveDrivetrain subsystem, Supplier<Double> UpDown, Supplier<Double> LeftRight, Supplier<Double> Rot) {
    drive = subsystem;
    _UpDown = UpDown;
    _LeftRight = LeftRight;
    _Rot = Rot;
    // Use addRequirements() here to declare subsystem dependencies.
    System.out.println("CTOR Human Drive");

    addRequirements(subsystem);
  }
  Supplier<Double> _UpDown, _LeftRight, _Rot;
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {    
    System.out.println("Running Human Drive");

    drive.HumanDrive(_UpDown.get(), _LeftRight.get(), _Rot.get());

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
