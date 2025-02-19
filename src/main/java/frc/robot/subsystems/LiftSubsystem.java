package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.PositionDutyCycle;
//import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.Constants.LiftSubsystemConstants;

// This is where all the commands related to the Lift are created

public class LiftSubsystem extends SubsystemBase{
     private TalonFX lift1, lift2;
     //private double oneTop, oneBottom;
 public LiftSubsystem() {
    lift1 = new TalonFX(LiftSubsystemConstants.liftMotorID1,"*");
    lift2 = new TalonFX(LiftSubsystemConstants.liftMotorID2,"*");
    // oneTop = 0;
    // oneBottom = 0;
    lift2.setControl(new Follower (LiftSubsystemConstants.liftMotorID1, true));
    }

    

 public void liftStop(){
   lift1.setControl(new DutyCycleOut(0)); 

   //lift2.setControl(new DutyCycleOut(.05));
  }

  public void liftUp(){
    //lift1.setControl(new PositionDutyCycle(oneTop)); 
    lift1.setControl(new DutyCycleOut(.4)); 
   //lift2.setControl(new PositionDutyCycle(twoTop));
  }
  
  public void liftDown(){
    //lift1.setControl(new PositionDutyCycle(oneBottom));
    lift1.setControl(new DutyCycleOut(-.4));
    //lift2.setControl(new PositionDutyCycle(twoBottom)); 
  }

  public void L1(){
    lift1.setControl(new PositionDutyCycle(0));
  }

  public void L2(){
    lift1.setControl(new PositionDutyCycle(0)); 
  }

  public void L3(){
    lift1.setControl(new PositionDutyCycle(0));
  }

  public void L4(){
    lift1.setControl(new PositionDutyCycle(0));
  }

  public void HumanPlayerStation(){
    lift1.setControl(new PositionDutyCycle(0));
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
    SmartDashboard.putNumber("Lift 1", lift1.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Lift 2", lift2.getPosition().getValueAsDouble());


  }

  public boolean IsUpSafe()
  {
    return lift1.getPosition().getValueAsDouble() < 90;
  }
  public boolean IsDownSafe()
  {
    return lift1.getPosition().getValueAsDouble() > 1;
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
