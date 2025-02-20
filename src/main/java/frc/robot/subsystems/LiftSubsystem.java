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
     public int l1Position = 20;
     public int l2Position = 40;
     public int l3Position = 60;
     public int l4Position = 80;
     public int humanPlayerStationPosition = 100;
     public String lastButtonPressed = "N/A";
     //private double oneTop, oneBottom;
 public LiftSubsystem() {
    lift1 = new TalonFX(LiftSubsystemConstants.liftMotorID1);
    //lift2 = new TalonFX(LiftSubsystemConstants.liftMotorID2,"*");
    // oneTop = 0;
    // oneBottom = 0;
    //lift2.setControl(new Follower (LiftSubsystemConstants.liftMotorID1, true));
    // lift2 fallows lift 1, not vice versa
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
    lift1.setControl(new PositionDutyCycle(l1Position));
    lastButtonPressed = "L1";
    System.out.println(lastButtonPressed);
    System.out.println(l1Position);
  }

  public void L2(){
    lift1.setControl(new PositionDutyCycle(l2Position)); 
    lastButtonPressed = "L2";
    System.out.println(lastButtonPressed);
    System.out.println(l2Position);
  }

  public void L3(){
    lift1.setControl(new PositionDutyCycle(l3Position));
    lastButtonPressed = "L3";
    System.out.println(lastButtonPressed);
    System.out.println(l3Position);
  }

  public void L4(){
    lift1.setControl(new PositionDutyCycle(l4Position));
    lastButtonPressed = "L4";
    System.out.println(lastButtonPressed);
    System.out.println(l4Position);
  }

  public void HumanPlayerStation(){
    lift1.setControl(new PositionDutyCycle(humanPlayerStationPosition));
    lastButtonPressed = "HumanPlayerStation";
    System.out.println(lastButtonPressed);
    System.out.println(humanPlayerStationPosition);
  }

  public void LastPositionUp(){
    if(lastButtonPressed == "L1"){
      l1Position = l1Position + 1;
      lift1.setControl(new PositionDutyCycle(l1Position));
    } else if (lastButtonPressed == "L2"){
      l2Position = l2Position + 1;
      lift1.setControl(new PositionDutyCycle(l2Position)); 
    }else if (lastButtonPressed == "L3"){
      l3Position = l3Position + 1;
      lift1.setControl(new PositionDutyCycle(l3Position));
    }else if (lastButtonPressed == "L4"){
      l4Position = l4Position + 1;
      lift1.setControl(new PositionDutyCycle(l4Position));
    }else if (lastButtonPressed == "HumanPlayerStation"){
      humanPlayerStationPosition = humanPlayerStationPosition + 1;
      lift1.setControl(new PositionDutyCycle(humanPlayerStationPosition));
    }
  }

  public void LastPositionDown(){
    if(lastButtonPressed == "L1"){
      l1Position = l1Position - 1;
      lift1.setControl(new PositionDutyCycle(l1Position));
    } else if (lastButtonPressed == "L2"){
      l2Position = l2Position - 1;
      lift1.setControl(new PositionDutyCycle(l2Position)); 
    }else if (lastButtonPressed == "L3"){
      l3Position = l3Position - 1;
      lift1.setControl(new PositionDutyCycle(l3Position));
    }else if (lastButtonPressed == "L4"){
      l4Position = l4Position - 1;
    }else if (lastButtonPressed == "HumanPlayerStation"){
      humanPlayerStationPosition = humanPlayerStationPosition - 1;
      lift1.setControl(new PositionDutyCycle(humanPlayerStationPosition));
    }
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
    //SmartDashboard.putNumber("Lift 2", lift2.getPosition().getValueAsDouble());

    SmartDashboard.putNumber("L1Position", l1Position);
    SmartDashboard.putNumber("L2Position", l2Position);
    SmartDashboard.putNumber("L3Position", l3Position);
    SmartDashboard.putNumber("L4Position", l4Position);
    SmartDashboard.putNumber("HPPosition", humanPlayerStationPosition);
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
