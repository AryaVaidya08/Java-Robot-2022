package frc.robot.commands.drive;

import frc.robot.subsystems.DrivebaseSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DefaultDrive extends CommandBase {

    DefaultDrive() {
        addRequirements(Robot.drivebase);
    }

    @Override
    public void execute() {
        Robot.drivebase.startTankDrive(-Robot.leftJoystick.getY(), -Robot.rightJoystick.getY());
        //Robot.drivebase.startArcadeDrive(-Robot.leftJoystick.getY(), -Robot.rightJoystick.getTwist());
        //Robot.drivebase.startCurvatureDrive(Robot.leftJoystick.getY(), Robot.rightJoystick.getTwist(), false);
    }
}
