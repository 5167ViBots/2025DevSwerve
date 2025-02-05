package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LightsSubsystem extends SubsystemBase {
    private CANdle candle;
    
    public LightsSubsystem(){
        candle = new CANdle(0, Constants.LightsSubsystemConstants.CandleLightsCan);

        CANdleConfiguration config = new CANdleConfiguration();
        config.stripType = LEDStripType.RGB;
       // config.brightnessScalar = 0.5;
        candle.configAllSettings(config);
        
        candle.setLEDs(225,225,255); //set color
    }


    private int toInt (double input) {
        return (int)input * 255;
    }
public void setOrange()
{
    candle.setLEDs(toInt(Constants.LightsSubsystemConstants.Orange.red), toInt(Constants.LightsSubsystemConstants.Orange.green), toInt(Constants.LightsSubsystemConstants.Orange.blue));
}

    public void setColor(Color InColor)
    {
        candle.setLEDs(toInt(InColor.red), toInt(InColor.green), toInt(InColor.blue));
    }



}

