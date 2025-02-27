// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.Constants.IntakeSubsystemConstants;

// This is where all the commands related to the intakes are created

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private TalonFX coralIntake, topAlgaeIntake, topIntakeAngle, bottomAlgeaIntake, bottomAlgeaIntakeSetter;
 
  public IntakeSubsystem() {
    coralIntake = new TalonFX(IntakeSubsystemConstants.coralIntake);
    topAlgaeIntake = new TalonFX(IntakeSubsystemConstants.topAlgaeIntake);
    bottomAlgeaIntake = new TalonFX (IntakeSubsystemConstants.bottomAlgeaIntake);
    bottomAlgeaIntakeSetter = new TalonFX(IntakeSubsystemConstants.bottomAlgeaIntakeSetter);
  }

  public void coralStop(){
    coralIntake.setControl(new DutyCycleOut(0));
  }

  public void coralIn(){
    coralIntake.setControl(new DutyCycleOut(.1));//TBD
  }

  public void coralOut(){
    coralIntake.setControl(new DutyCycleOut(-.1));//TBD
  }

  public void topAlgaeStop(){
    topAlgaeIntake.setControl(new DutyCycleOut(0));
    bottomAlgeaIntake.setControl(new DutyCycleOut(0));
    coralIntake.setControl(new DutyCycleOut(0));
  }

  public void topAlgaeIn(){
    topAlgaeIntake.setControl(new DutyCycleOut(.6));//TBD
    bottomAlgeaIntake.setControl(new DutyCycleOut(.6));
    coralIntake.setControl(new DutyCycleOut(-.3));
  }

  public void topAlgaeOut(){
    topAlgaeIntake.setControl(new DutyCycleOut(-.6));//TBD
    coralIntake.setControl(new DutyCycleOut(.3));
    bottomAlgeaIntake.setControl(new DutyCycleOut(-.6));
  }

  public void topIntakeAngleFeed(){
    topIntakeAngle.setControl(new DutyCycleOut(-.2));
  }

  public void topIntakeAngleShoot(){
    topIntakeAngle.setControl(new DutyCycleOut(.2));//TBD
  }

  public void topIntakeAngleNeutral(){
    topIntakeAngle.setControl(new DutyCycleOut(0));//TBD
  }

  public void bottomAlgaeStop(){
    bottomAlgeaIntake.setControl(new DutyCycleOut(0));
  }

  public void bottomAlgaeIn(){
    bottomAlgeaIntake.setControl(new DutyCycleOut(.2));//TBD
  }

  public void bottomAlgaeOut(){
    bottomAlgeaIntake.setControl(new DutyCycleOut(-.2));//TBD
  }

  public void bottomAlgaeIntakeSlightOut(){
    bottomAlgeaIntakeSetter.setControl(new PositionDutyCycle(0));
  }

  public void bottomAlgaeIntakeOut(){
    bottomAlgeaIntakeSetter.setControl(new PositionDutyCycle(.2));//TBD
  }

  public void bottomAlgaeIntakeIn(){
     bottomAlgeaIntakeSetter.setControl(new PositionDutyCycle(-.2));//TBD
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

