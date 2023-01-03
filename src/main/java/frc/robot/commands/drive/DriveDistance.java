package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveDistance extends CommandBase {

    private final double distance;
    private final double speed;

    public DriveDistance(double distance, double speed) {
        this.distance = distance;
        this.speed = speed;
        addRequirements(Robot.drivebase);
    }
        
    
    @Override
    public void initialize() {
        Robot.drivebase.resetEncoders();
    }

    @Override
    public void execute() {
        Robot.drivebase.startTankDrive(speed, speed);;
    }

    @Override
    public boolean isFinished() { 
        return Robot.drivebase.getTotalEncoderDistance() >= distance;
    }
}
