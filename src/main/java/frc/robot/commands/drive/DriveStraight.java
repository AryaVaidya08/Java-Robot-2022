package frc.robot.commands.drive;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Robot;
import edu.wpi.first.math.controller.PIDController;

public class DriveStraight extends PIDCommand {

    public final double distance;
    
    public DriveStraight(double speed, double distance) {
        super(new PIDController(0.1,0,0),
        () -> Robot.getDrivebase().getLeftEncoderDistance() - Robot.getDrivebase().getRightEncoderDistance(), 
        0, 
        (output) -> Robot.drivebase.startArcadeDrive(speed, output),
        Robot.getDrivebase());
        getController().enableContinuousInput(-180,180);
        getController().setTolerance(2, 0);

        this.distance = distance;
    }

    @Override
    public void initialize() {
        Robot.drivebase.resetEncoders();
        Robot.getNavX().reset();  
    }

    @Override
    public boolean isFinished() {
        return getController().atSetpoint() && Robot.drivebase.getTotalEncoderDistance() >= distance;
    }
}
