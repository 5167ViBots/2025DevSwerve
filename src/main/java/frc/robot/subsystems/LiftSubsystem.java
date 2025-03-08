package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.MusicTone;
import com.ctre.phoenix6.controls.PositionDutyCycle;
//import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.FrequencyUnit;
import edu.wpi.first.units.measure.Frequency;
//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.Constants.IntakeSubsystemConstants;
import frc.robot.generated.Constants.LiftSubsystemConstants;

// This is where all the commands related to the Lift are created

public class LiftSubsystem extends SubsystemBase{
// cruise 40
// accel 25 

// kP 3.25
// kl 0
// kD .35
// kS .1
// kV 0
// kA 0
// kG .4 

     private TalonFX lift1, lift2, bottomAlgeaIntake;
     public int l1Position = 5;
     public int l2Position = 15;
     public int l3Position = 25;
     public int l4Position = 62; 
     public int humanPlayerStationPosition = 50;
     public String lastButtonPressed = "N/A";
     //private double oneTop, oneBottom;
 public LiftSubsystem() {
    lift1 = new TalonFX(LiftSubsystemConstants.liftMotorID1);
    lift2 = new TalonFX(LiftSubsystemConstants.liftMotorID2);
    lift1.setNeutralMode(NeutralModeValue.Brake);
    lift2.setNeutralMode(NeutralModeValue.Brake);
    bottomAlgeaIntake = new TalonFX (IntakeSubsystemConstants.bottomAlgeaIntake);
    
    // oneTop = 0;
    // oneBottom = 0;
    lift2.setControl(new Follower (LiftSubsystemConstants.liftMotorID1, true));
    // lift2 fallows lift 1, not vice versa



    var talonFXConfigs = new TalonFXConfiguration();
    var slot0Configs = talonFXConfigs.Slot0;
    slot0Configs.kP = 3.25;
    slot0Configs.kI = 0;
    slot0Configs.kD = .35;
    slot0Configs.kS = .1;
    slot0Configs.kV = 0;
    slot0Configs.kA = 0;
    slot0Configs.kG = .4;

    var motionMagicConfigs = talonFXConfigs.MotionMagic;
    motionMagicConfigs.MotionMagicCruiseVelocity = 50;
    motionMagicConfigs.MotionMagicAcceleration = 45;
    motionMagicConfigs.MotionMagicJerk = 0; //Dane (wrong)

    lift1.getConfigurator().apply(talonFXConfigs);

    // cruise 40
// accel 25 

// kP 3.25
// kl 0
// kD .35
// kS .1
// kV 0
// kA 0
// kG .4 
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
    lift1.setControl(new MotionMagicVoltage(l1Position));
    lastButtonPressed = "L1";
    System.out.println(lastButtonPressed);
    System.out.println(l1Position);
  }

  public void L2(){
    lift1.setControl(new MotionMagicVoltage(l2Position)); 
    lastButtonPressed = "L2";
    System.out.println(lastButtonPressed);
    System.out.println(l2Position);
  }

  public void L3(){
    lift1.setControl(new MotionMagicVoltage(l3Position));
    lastButtonPressed = "L3";
    System.out.println(lastButtonPressed);
    System.out.println(l3Position);
  }

  public void L4(){
    lift1.setControl(new MotionMagicVoltage(l4Position));
    lastButtonPressed = "L4";
    System.out.println(lastButtonPressed);
    System.out.println(l4Position);
  }

  public void HumanPlayerStation(){
    lift1.setControl(new MotionMagicVoltage(humanPlayerStationPosition));
    lastButtonPressed = "HumanPlayerStation";
    System.out.println(lastButtonPressed);
    System.out.println(humanPlayerStationPosition);
  }

  public void LastPositionUp(){
    if(lastButtonPressed == "L1"){
      l1Position = l1Position + 1;
      lift1.setControl(new MotionMagicVoltage(l1Position));
    } else if (lastButtonPressed == "L2"){
      l2Position = l2Position + 1;
      lift1.setControl(new MotionMagicVoltage(l2Position)); 
    }else if (lastButtonPressed == "L3"){
      l3Position = l3Position + 1;
      lift1.setControl(new MotionMagicVoltage(l3Position));
    }else if (lastButtonPressed == "L4"){
      l4Position = l4Position + 1;
      lift1.setControl(new MotionMagicVoltage(l4Position));
    }else if (lastButtonPressed == "HumanPlayerStation"){
      humanPlayerStationPosition = humanPlayerStationPosition + 1;
      lift1.setControl(new MotionMagicVoltage(humanPlayerStationPosition));
    }
  }

  public void LastPositionDown(){
    if(lastButtonPressed == "L1"){
      l1Position = l1Position - 1;
      lift1.setControl(new MotionMagicVoltage(l1Position));
    } else if (lastButtonPressed == "L2"){
      l2Position = l2Position - 1;
      lift1.setControl(new MotionMagicVoltage(l2Position)); 
    }else if (lastButtonPressed == "L3"){
      l3Position = l3Position - 1;
      lift1.setControl(new MotionMagicVoltage(l3Position));
    }else if (lastButtonPressed == "L4"){
      l4Position = l4Position - 1;
    }else if (lastButtonPressed == "HumanPlayerStation"){
      humanPlayerStationPosition = humanPlayerStationPosition - 1;
      lift1.setControl(new MotionMagicVoltage(humanPlayerStationPosition));
    }
  }

  public void tromboneNoise(){
    bottomAlgeaIntake.setControl(new MusicTone(lift1.getPosition().getValueAsDouble()/1.667));
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
