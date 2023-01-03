package frc.robot.commands.drive;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Robot;
import edu.wpi.first.math.controller.PIDController;

public class PID_DegreeTurnDrive extends PIDCommand {

    private final double setPoint;
    
    public PID_DegreeTurnDrive(double setPoint) {
        super(new PIDController(0.1,0,0),
        () -> Robot.getNavX().getAngle(), 
        setPoint, 
        (output) -> Robot.drivebase.startTankDrive(output, -output),
        Robot.drivebase);
        this.setPoint = setPoint;
        getController().enableContinuousInput(-180,180);
        getController().setTolerance(2, 0);
    }

    @Override
    public void initialize() {
        Robot.getNavX().reset();   
    }

    @Override
    public boolean isFinished() {
        return Robot.getNavX().getAngle() >= setPoint && getController().atSetpoint();
    }
}
