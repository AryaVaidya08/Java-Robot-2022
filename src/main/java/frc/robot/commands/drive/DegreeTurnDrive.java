package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import com.kauailabs.navx.frc.AHRS;

public class DegreeTurnDrive extends CommandBase {
    private final double degrees;
    private final double speed;
    
    public DegreeTurnDrive(double degrees, double speed) {
        this.degrees = degrees;
        this.speed = speed;
        addRequirements(Robot.drivebase);
    }

    @Override
    public void initialize() {
        Robot.getNavX().setAngleAdjustment(degrees);
    }

    @Override
    public void execute() {
        Robot.drivebase.startTankDrive(speed, -speed);
    }

    @Override
    public boolean isFinished() {
        return Robot.getNavX().isRotating();
    }

}
