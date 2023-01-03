package frc.robot.commands.drive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DrivebaseSubsystem;

public class ArcadeDrive extends CommandBase {

    ArcadeDrive() {
        addRequirements(Robot.drivebase);
    }

    
    //Robot.drivebase.startArcadeDrive(Robot.leftJoystick.getY(), Robot.rightJoystick.getTwist());
}
