package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class DriveWait extends CommandBase {

    private Timer timer;
    private final double time;

    public DriveWait(double time) {
        this.time = time;
        addRequirements(Robot.drivebase);
    }

    @Override 
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        Robot.drivebase.startTankDrive(0, 0);
    }

    public void end() {
        timer.reset();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= time;
    }

}
