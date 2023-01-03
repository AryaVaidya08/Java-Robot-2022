package frc.robot.autonomous;

import static frc.robot.autonomous.AutonomousProgram.create;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drive.DriveDistance;
import frc.robot.commands.drive.DriveWait;
import frc.robot.commands.climber.ClimberDown;
import frc.robot.commands.drive.DegreeTurnDrive;
/**
 * Quick guide to Command Groups:
 *
 * SequentialComandGroup:
 * Will run all commands in order within it's parentheses
 * Note: If a command does not have a isFinshed statment the code will be stuck
 * on that command forever
 *
 * ParallelCommandGroup:
 * Will run commands in parallel if they use diffrent SubSystems
 * Note: Both commands will have to finish to move on
 *
 * ParallelRaceGoup:
 * Will run commands in parallel if they use diffrent SubSystems
 * Note: As soon as one command runs it's isfinished method runs then both
 * commands will end
 *
 * ParallelDeadlineGroup
 * Will run commands in parallel if they use diffrent SubSystems
 * Note: Only the first command will finish the group
 */
public class Autonomous {

  public static void init() {
    /* Start with back against hub */
	/* Just Taxi */
    create("Drive Forward 8ft", () -> new DriveDistance(8 * 12, 0.5));
    create("Drive Forward 7ft", () -> new DriveDistance(7 * 12, 0.5));
    create("Drive Forward 6ft", () -> new DriveDistance(6 * 12, 0.5));
    create("Drive Backwards 8ft", () -> new DriveDistance(8 * 12, -0.5));
    create("Drive Backwards 7ft", () -> new DriveDistance(7 * 12, -0.5));
    create("Drive Backwards 6ft", () -> new DriveDistance(6 * 12, -0.5));
  }
}
