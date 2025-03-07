// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import com.ctre.phoenix6.controls.DutyCycleOut;
// import com.ctre.phoenix6.hardware.TalonFX;

// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.generated.Constants.CageSubsystemConstants;

// // This is where all the commands related to the Cage are created

// public class CageSubsystem extends SubsystemBase {
//   /** Creates a new ExampleSubsystem. */

//     private TalonFX cageMotor;

//   public CageSubsystem() {
//     cageMotor = new TalonFX(CageSubsystemConstants.cageMotor);
//   }

//   public void cageUp(){
//     cageMotor.setControl(new DutyCycleOut(.2));
//   }

//   public void cagedown(){
//     cageMotor.setControl(new DutyCycleOut(-.2));
//   }

//   public void cageStop(){
//     cageMotor.setControl(new DutyCycleOut(0));
//   }

//   /**
//    * Example command factory method.
//    *
//    * @return a command
//    */
//   public Command exampleMethodCommand() {
//     // Inline construction of command goes here.
//     // Subsystem::RunOnce implicitly requires `this` subsystem.
//     return runOnce(
//         () -> {
//           /* one-time action goes here */
//         });
//   }

//   /**
//    * An example method querying a boolean state of the subsystem (for example, a digital sensor).
//    *
//    * @return value of some boolean subsystem state, such as a digital sensor.
//    */
//   public boolean exampleCondition() {
//     // Query some boolean state, such as a digital sensor.
//     return false;
//   }

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//   }

//   @Override
//   public void simulationPeriodic() {
//     // This method will be called once per scheduler run during simulation
//   }
// }
