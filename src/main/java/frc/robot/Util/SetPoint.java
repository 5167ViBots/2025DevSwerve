package frc.robot.Util;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;


public class SetPoint {
    double SetPointValue = 0;
    public double Step = 1;
    public SetPoint(double SetPoint) {
        SetPointValue = SetPoint;
    }
    private void RaiseValue()
    {
        SetPointValue = SetPointValue + Step;
    }
    private void LowerValue()
    {
        SetPointValue = SetPointValue - Step;
    }
    public double get()
    {
        return SetPointValue;
    }
    public void set(double Value)
    {
        SetPointValue = Value;
    }


    public Command GetRaiseCommand()
    {
        return new FunctionalCommand(
            //Init
            () -> {} , 
            //Exec
            this::RaiseValue,
            //End
            interrupted -> {},
            //Finished
            () -> {return true;},
            //Subsystems
             (Subsystem[])null);
    }


    public Command GetLowerCommand()
    {
        return new FunctionalCommand(
        //Init
        () -> {} , 
        //Exec
        this::LowerValue,
        //End
        interrupted -> {},
        //Finished
        () -> {return true;},
        //Subsystems
         (Subsystem[])null);
    }

}
