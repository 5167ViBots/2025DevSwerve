// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import frc.robot.subsystems.CageSubsystem;
// import edu.wpi.first.wpilibj2.command.Command;

// // This is where the CageUp command is clarified

// /** An example command that uses an example subsystem. */
// public class CageUp extends Command {
//   @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//   private final CageSubsystem cageSubsystem;

//   /**
//    * Creates a new CageUp.
//    *
//    * @param subsystem The subsystem used by this command.
//    */
//   public CageUp(CageSubsystem subsystem) {
//     cageSubsystem = subsystem;
//     // Use addRequirements() here to declare subsystem dependencies.
//     addRequirements(subsystem);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {}

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     cageSubsystem.cageUp();
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     cageSubsystem.cageStop();
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
