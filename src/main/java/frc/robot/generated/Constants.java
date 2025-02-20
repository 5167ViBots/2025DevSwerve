package frc.robot.generated;
//This is where the motors get their ID value 
public class Constants {
    public static final String RioCanBus = "rio";

    public static class LiftSubsystemConstants {
    public static final int liftMotorID1 = 9;
    public static final String liftMotor1Can = RioCanBus;

    public static final int liftMotorID2 = 10;
    public static final String liftMotor2Can = RioCanBus;
    }

    public static class IntakeSubsystemConstants {
    
    public static final int coralIntake = 11;
    public static final String coralIntakeCan = RioCanBus;

    public static final int topAlgaeIntake = 12;
    public static final String topAlgaeIntakeCan = RioCanBus;
        
    public static final int bottomAlgeaIntake = 13;
    public static final String bottomAlgeaIntakeCAN = RioCanBus;

    public static final int bottomAlgeaIntakeSetter = 14;
    public static final String bottomAlgeaIntakeSetterCAN = RioCanBus;
    }

    public static class CageSubsystemConstants {
    public static final int cageMotor = 15;
    public static final String cageMotorCAN = RioCanBus;    
    }
}
