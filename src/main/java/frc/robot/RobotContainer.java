// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;
//import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.robot.commands.AlignLeft;
import frc.robot.commands.AlignRight;
import frc.robot.commands.BottomAlgaeIn;
import frc.robot.commands.BottomAlgaeIntakeIn;
import frc.robot.commands.BottomAlgaeIntakeOut;
import frc.robot.commands.BottomAlgaeIntakeSlightOut;
import frc.robot.commands.BottomAlgaeOut;
import frc.robot.commands.CageUp;
import frc.robot.commands.CoralIn;
import frc.robot.commands.CoralOut;
import frc.robot.commands.CoralStop;
import frc.robot.commands.HumanPlayerStation;
import frc.robot.commands.L1;
import frc.robot.commands.L2;
import frc.robot.commands.L3;
import frc.robot.commands.L4;
import frc.robot.commands.LiftUp;
import frc.robot.commands.LightCommand;
import frc.robot.commands.ManualLiftDown;
import frc.robot.commands.ManualLiftUp;
import frc.robot.commands.TopAlgaeIn;
import frc.robot.commands.TopAlgaeOut;
import frc.robot.commands.TopIntakeAngleFeed;
import frc.robot.commands.TopIntakeAngleShoot;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CageSubsystem;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.LightsSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.SwitchSubsystem;

public class RobotContainer {

LightsSubsystem lights = new LightsSubsystem();
SwitchSubsystem switcher = new SwitchSubsystem();
LimelightSubsystem lime = new LimelightSubsystem();
LiftSubsystem lift = new LiftSubsystem();
IntakeSubsystem intake = new IntakeSubsystem();
CageSubsystem cage = new CageSubsystem();
    
    private double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
    private double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

    /* Setting up bindings for necessary control of the swerve drive platform */
    // private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
    //         .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
    //         .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors

            private final SwerveRequest.RobotCentric drive = new SwerveRequest.RobotCentric()
            .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors

    private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
    private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();

    private final Telemetry logger = new Telemetry(MaxSpeed);

    private final CommandPS5Controller joystick = new CommandPS5Controller(0);
    private final CommandJoystick buttonBoard = new CommandJoystick(1);
    private final CommandJoystick buttonBoardJr = new CommandJoystick(2);

    public final CommandSwerveDrivetrain drivetrain = TunerConstants.createDrivetrain();
    private final SwerveRequest.RobotCentric forwardStraight = new SwerveRequest.RobotCentric()
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage);

    /* Path follower */
    //private final SendableChooser<Command> autoChooser;
    public RobotContainer() {
        registerPathPlannerCommands();
        configureBindings();
        registerAutons();
      }
    


      private void registerPathPlannerCommands() {
         NamedCommands.registerCommand("L1", new L1(lift)); 
         NamedCommands.registerCommand("L2", new L2(lift));
         NamedCommands.registerCommand("L3", new L3(lift));
         NamedCommands.registerCommand("L4", new L4(lift));
         NamedCommands.registerCommand("HumanPlayerStation", new HumanPlayerStation(lift));
         NamedCommands.registerCommand("CoralIn", new CoralIn(intake));
         NamedCommands.registerCommand("CoralOut", new CoralOut(intake));
         NamedCommands.registerCommand("TopAglaeIn", new TopAlgaeIn(intake));
         NamedCommands.registerCommand("TopAglaeOut", new TopAlgaeOut(intake));
         NamedCommands.registerCommand("TopIntakeAngleFeed", new TopIntakeAngleFeed(intake));
         NamedCommands.registerCommand("TopIntakeAngleShoot", new TopIntakeAngleShoot(intake));
         NamedCommands.registerCommand("BottomAlgeaIntakeIn", new BottomAlgaeIntakeIn(intake));
         NamedCommands.registerCommand("BottomAlgeaIntakeOut", new BottomAlgaeIntakeOut(intake));
         NamedCommands.registerCommand("BottomAlgeaIntakeSlightOut", new BottomAlgaeIntakeSlightOut(intake));
         NamedCommands.registerCommand("BottomAlgeaIn", new BottomAlgaeIn(intake));
         NamedCommands.registerCommand("BottomAlgeaOut", new BottomAlgaeOut(intake));
        }
    
        public SendableChooser<String> AutonChooser = new SendableChooser<String>();
    private void registerAutons() {
    
    //Create Shuffleboard Tab
    var tab = Shuffleboard.getTab("Auton");

    //Register Auton modes
    AutonChooser.addOption("Leave and Score","Leave and Score");
    
    
    //Set the default Auton
    AutonChooser.setDefaultOption("Leave and Score","Leave and Score");
    
    //Add to shuffleboard
    tab.add(AutonChooser);
  }

    public void configureBindings() {
        // Note that X is defined as forward according to WPILib convention,
        // and Y is defined as to the left according to WPILib convention.
        drivetrain.setDefaultCommand(
            // Drivetrain will execute this command periodically
            drivetrain.applyRequest(() ->
                drive.withVelocityX(-joystick.getLeftY() * MaxSpeed) // Drive forward with negative Y (forward)
                    .withVelocityY(-joystick.getLeftX() * MaxSpeed) // Drive left with negative X (left)
                    .withRotationalRate(-joystick.getRightX() * MaxAngularRate) // Drive counterclockwise with negative X (left)
            )
        );

                //bumpers are set to align the robot
        joystick.R1().whileTrue(new AlignRight(drivetrain, lime));
        joystick.L1().whileTrue(new AlignLeft(drivetrain, lime));
        joystick.cross().whileTrue(drivetrain.applyRequest(() -> brake));
        joystick.circle().whileTrue(drivetrain.applyRequest(() ->
            point.withModuleDirection(new Rotation2d(-joystick.getLeftY(), -joystick.getLeftX()))
        ));

        joystick.pov(0).whileTrue(drivetrain.applyRequest(() ->
        forwardStraight.withVelocityX(0.5).withVelocityY(0))
    );
    joystick.pov(180).whileTrue(drivetrain.applyRequest(() ->
        forwardStraight.withVelocityX(-0.5).withVelocityY(0))
    );

        // Run SysId routines when holding back/start and X/Y.
        // Note that each routine should be run exactly once in a single log.
        // joystick.back().and(joystick.y()).whileTrue(drivetrain.sysIdDynamic(Direction.kForward));
        // joystick.back().and(joystick.x()).whileTrue(drivetrain.sysIdDynamic(Direction.kReverse));
        // joystick.start().and(joystick.y()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kForward));
        // joystick.start().and(joystick.x()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kReverse));
        new Trigger(switcher::isItSwitched).whileTrue(new LightCommand(lights, 0.0, 225.0, 0.0));
        //new Trigger(switcher::isItSwitched).onTrue(new CoralStop(intake));

        // reset the field-centric heading on left bumper press
        //joystick.leftBumper().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldCentric()));

        drivetrain.registerTelemetry(logger::telemeterize);

        //assings pov right and left to a color when pushed
        joystick.povRight().whileTrue(new LightCommand(lights, 0.0, 225.0, 0.0));
        joystick.povLeft().whileTrue(new LightCommand(lights, 225.0, 0.0, 225.0));

        buttonBoard.button(1).whileTrue(new HumanPlayerStation(lift));
        buttonBoard.button(2).whileTrue(new L4(lift));
        buttonBoard.button(3).whileTrue(new L3(lift));
        buttonBoard.button(4).whileTrue(new L2(lift));
        buttonBoard.button(5).whileTrue(new L1(lift));

        buttonBoard.button(6).whileTrue(new BottomAlgaeIntakeIn(intake));
        buttonBoard.button(7).whileTrue(new BottomAlgaeIntakeOut(intake));

        buttonBoard.button(8).whileTrue(new TopIntakeAngleShoot(intake));
        buttonBoard.button(9).whileTrue(new TopIntakeAngleFeed(intake));

        buttonBoard.button(10).whileTrue(new ManualLiftUp(lift));
        buttonBoard.button(11).whileTrue(new ManualLiftDown(lift));
        buttonBoard.button(12).whileTrue(new CageUp(cage));
        buttonBoardJr.button(6).whileTrue(new CoralIn(intake));
        buttonBoardJr.button(7).whileTrue(new CoralOut(intake));
        buttonBoardJr.button(4).whileTrue(new TopAlgaeIn(intake));
        buttonBoardJr.button(5).whileTrue(new TopAlgaeOut(intake));
    }

    public Command getAutonomousCommand() {
        /* Run the path selected from the auto chooser */
        return new Command() {
            
        };
    }
}