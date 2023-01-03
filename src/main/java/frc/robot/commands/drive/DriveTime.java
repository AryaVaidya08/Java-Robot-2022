package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class DriveTime extends CommandBase {
    private Timer timer;
    private double time;
    private double speed;

    public DriveTime(double time) {
        this.time = time;
        addRequirements(Robot.drivebase);
    }
        
    @Override
    public void execute() {
        Robot.drivebase.startTankDrive(speed, speed);;
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void end(boolean interrupted) {
        timer.reset();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= time;
    }
}
