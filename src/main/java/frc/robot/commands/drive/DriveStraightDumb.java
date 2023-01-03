package frc.robot.commands.drive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Robot;

public class DriveStraightDumb extends CommandBase {

    private final double speed;
    private final double distance;
    private double error, previousError;
    private double P, I = 0, D, kP, kI, kD;

    public DriveStraightDumb(double speed, double distance, double kP, double kI, double kD) {
        this.speed = speed;
        this.distance = distance;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        addRequirements(Robot.getDrivebase());
    }

    @Override
    public void initialize() {
        Robot.getNavX().reset();
        Robot.getDrivebase().resetEncoders();
    }

    @Override
    public void execute() {
        error = (Robot.getNavX().getAngle() - 0);
        P = error * kP;
        I += (error) * kI;
        D = (error - previousError) * kP;
        previousError = error;
        Robot.getDrivebase().startArcadeDrive(speed, P + I + D);
    }

    @Override
    public boolean isFinished() {
        return Robot.getDrivebase().getTotalEncoderDistance() >= distance && (error == 0);
    }

}
