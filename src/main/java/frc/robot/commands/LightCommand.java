package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.LightsSubsystemConstants;
import frc.robot.subsystems.LightsSubsystem;

public class LightCommand extends Command {

private final LightsSubsystem m_subsystem;
private final Double kR, kG, kB;


public Color GetColor()
{
    return LightsSubsystemConstants.Orange;
}


public LightCommand(LightsSubsystem subsystem, Double R, Double G, double B) {
    m_subsystem = subsystem;
    kR = R;
    kG = G;
    kB = B;
    addRequirements(subsystem);
}


@Override
public void initialize() {

    //m_subsystem.setColor(GetColor());
}

// Called every time the scheduler runs while the command is scheduled.
@Override
public void execute() {
   m_subsystem.setColor(new Color(kR, kG, kB));
}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {
    m_subsystem.setColor(new Color(0,0,0));
}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}
    
}

