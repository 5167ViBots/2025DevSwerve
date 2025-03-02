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
  private TalonFX coralIntake, topAlgaeIntake, topIntakeAngle, bottomAlgeaIntake, bottomAlgeaIntakeSetter, topCoralAngle;
 
  public IntakeSubsystem() {
    coralIntake = new TalonFX(IntakeSubsystemConstants.coralIntake);
    topAlgaeIntake = new TalonFX(IntakeSubsystemConstants.topAlgaeIntake);
    bottomAlgeaIntake = new TalonFX (IntakeSubsystemConstants.bottomAlgeaIntake);
    bottomAlgeaIntakeSetter = new TalonFX(IntakeSubsystemConstants.bottomAlgeaIntakeSetter);
    //topCoralAngle = new TalonFX(IntakeSubsystemConstants.coralAngle, IntakeSubsystemConstants.coralAngleCan);
    topIntakeAngle = new TalonFX(IntakeSubsystemConstants.coralAngle, IntakeSubsystemConstants.coralAngleCan);
  }

  public void coralStop(){
    coralIntake.setControl(new DutyCycleOut(0));
  }

  public void coralIn(){
    coralIntake.setControl(new DutyCycleOut(.1));//TBD
  }

  public void coralOut(){
    coralIntake.setControl(new DutyCycleOut(-.2));//TBD
  }

  public void topAlgaeStop(){
    double TopAlgaeTick = topAlgaeIntake.getPosition().getValueAsDouble();
    topAlgaeIntake.setControl(new PositionDutyCycle(TopAlgaeTick));

    double CoralIntakeTick = coralIntake.getPosition().getValueAsDouble();
    coralIntake.setControl(new PositionDutyCycle(CoralIntakeTick));
    bottomAlgeaIntake.setControl(new DutyCycleOut(0));
    //coralIntake.setControl(new DutyCycleOut(0));
  }

  public void topAlgaeIn(){
    topAlgaeIntake.setControl(new DutyCycleOut(-.2));//TBD
    bottomAlgeaIntake.setControl(new DutyCycleOut(-.5));
    coralIntake.setControl(new DutyCycleOut(-.3));
  }

  boolean UpOrDownBottomAlgaeIntake = false;

  public void SwitchAlgaeIntakePosition()
  {
    if (UpOrDownBottomAlgaeIntake)
        bottomAlgeaIntakeSetter.setControl(new PositionDutyCycle(1.8));
        else
        bottomAlgeaIntakeSetter.setControl(new PositionDutyCycle(3.2));
    UpOrDownBottomAlgaeIntake = !UpOrDownBottomAlgaeIntake;
  }

  public void topAlgaeOut(){
    topAlgaeIntake.setControl(new DutyCycleOut(.7));
    coralIntake.setControl(new DutyCycleOut(.7)); 
    bottomAlgeaIntake.setControl(new DutyCycleOut(.2));
  }

  public void topIntakeAngleFeed(){
    topIntakeAngle.setControl(new PositionDutyCycle(74));
  }

  public void topIntakeAngleShoot(){
    topIntakeAngle.setControl(new PositionDutyCycle(15.5));//TBD
  }
  
  public void topIntakeAngleUp(){
    topIntakeAngle.setControl(new DutyCycleOut(-.2));
  }

  public void topIntakeAngleDown(){
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
    bottomAlgeaIntakeSetter.setControl(new PositionDutyCycle(4.5));//TBD
  }

  public void bottomAlgaeIntakeIn(){
     bottomAlgeaIntakeSetter.setControl(new PositionDutyCycle(2));//TBD
  }

  public void SetTopAlgaeAngle(double tickposition)
  {
    topCoralAngle.setControl(new PositionDutyCycle(tickposition));
  }

  public void AdjustTopAlgageAngle(double tickpositiontoadd)
  {
    double newposition = topCoralAngle.getPosition().getValueAsDouble() + tickpositiontoadd;
    topCoralAngle.setControl(new PositionDutyCycle(newposition));
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

