package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ClimberDown extends CommandBase {

    private double speed;

    public ClimberDown(double speed) {
        addRequirements(Robot.climb);
        this.speed = speed;
    }

    @Override
    public void execute() {
        Robot.climb.climberMove(-speed);
    }

    @Override
    public boolean isFinished() {
        return Robot.climb.climbAtBottom();
    }

    @Override
    public void end(boolean interrupted) {
        Robot.climb.climberMove(0);
    }
    
}
