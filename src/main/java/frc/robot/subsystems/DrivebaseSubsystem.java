package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap.DrivebaseConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.MotorSafety;
import java.beans.Encoder;

public class DrivebaseSubsystem extends SubsystemBase {
    private final CANSparkMax leftFrontMotor;
    private final CANSparkMax leftBackMotor;
    private final CANSparkMax rightFrontMotor;
    private final CANSparkMax rightBackMotor;
    private final MotorControllerGroup leftMotorGroup;
    private final MotorControllerGroup rightMotorGroup;
    private final DifferentialDrive diffDriveSystem;
    private final RelativeEncoder leftFrontEncoder;
    private final RelativeEncoder leftBackEncoder;
    private final RelativeEncoder rightFrontEncoder;
    private final RelativeEncoder rightBackEncoder;

    public DrivebaseSubsystem() {
        leftFrontMotor = new CANSparkMax(DrivebaseConstants.LEFT_FRONT_SPARK_ID, MotorType.kBrushless);
        leftBackMotor = new CANSparkMax(DrivebaseConstants.LEFT_BACK_SPARK_ID, MotorType.kBrushless);
        rightFrontMotor = new CANSparkMax(DrivebaseConstants.RIGHT_FRONT_SPARK_ID, MotorType.kBrushless);
        rightBackMotor = new CANSparkMax(DrivebaseConstants.RIGHT_BACK_SPARK_ID, MotorType.kBrushless);
        leftMotorGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
        rightMotorGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);

        leftFrontMotor.setInverted(DrivebaseConstants.LEFT_FRONT_SPARK_INVERTED);
        leftBackMotor.setInverted(DrivebaseConstants.LEFT_BACK_SPARK_INVERTED);
        rightFrontMotor.setInverted(DrivebaseConstants.RIGHT_FRONT_SPARK_INVERTED);
        rightBackMotor.setInverted(DrivebaseConstants.RIGHT_BACK_SPARK_INVERTED);

        leftFrontMotor.setIdleMode(DrivebaseConstants.MOTOR_IDLE_MODE);
        leftBackMotor.setIdleMode(DrivebaseConstants.MOTOR_IDLE_MODE);
        rightFrontMotor.setIdleMode(DrivebaseConstants.MOTOR_IDLE_MODE);
        rightBackMotor.setIdleMode(DrivebaseConstants.MOTOR_IDLE_MODE);

        diffDriveSystem = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

        leftFrontEncoder = leftFrontMotor.getEncoder();
        leftBackEncoder = leftBackMotor.getEncoder();
        rightFrontEncoder = rightFrontMotor.getEncoder();
        rightBackEncoder = rightBackMotor.getEncoder();
    }

    public DifferentialDrive getDiffDrive() {
        return diffDriveSystem;
    }

    public double getLeftEncoderDistance() {
        return (Math.abs(leftFrontEncoder.getPosition()) + Math.abs(leftBackEncoder.getPosition())) / 2;
    }

    public double getRightEncoderDistance() {
        return (Math.abs(rightFrontEncoder.getPosition()) + Math.abs(rightFrontEncoder.getPosition())) / 2;
    }

    public double getTotalEncoderDistance() {
        return (Math.abs(getLeftEncoderDistance()) + Math.abs(getRightEncoderDistance())) / 2;
    }
    
    public RelativeEncoder getLeftFrontEncoder() {
        return leftFrontEncoder;
    }
    public RelativeEncoder getLeftBackEncoder() {
        return leftBackEncoder;
    }
    public RelativeEncoder getRightFrontEncoder() {
        return rightFrontEncoder;
    }

    public RelativeEncoder getRightBackEncoder() {
        return rightBackEncoder;
    }

    public CANSparkMax getLeftFrontMotor() {
        return leftFrontMotor;
    }

    public CANSparkMax getLeftBackMotor() {
        return leftBackMotor;
    }
    public CANSparkMax getRightFrontMotor() {
        return rightFrontMotor;
    }
    public CANSparkMax getRightBackMotor() {
        return rightBackMotor;
    }

    public MotorControllerGroup getRightMotorGroup() {
        return rightMotorGroup;
    }

    public void resetEncoders() {
        leftFrontEncoder.setPosition(0);
        leftBackEncoder.setPosition(0);
        rightFrontEncoder.setPosition(0);
        rightBackEncoder.setPosition(0);
    }

    public void resetEncoders(double amount) {
        leftFrontEncoder.setPosition(amount);
        leftBackEncoder.setPosition(amount);
        rightFrontEncoder.setPosition(amount);
        rightBackEncoder.setPosition(amount);
    }

    public void startArcadeDrive(double speed, double rotation) {
        diffDriveSystem.arcadeDrive(speed, rotation);
    }

    public void startTankDrive(double leftSpeed, double rightSpeed) {
        //MotorSafety.checkMotors();
        diffDriveSystem.tankDrive(leftSpeed, rightSpeed);
    }

    public void startCurvatureDrive(double speed, double rotation, boolean turnInPlace) {
        diffDriveSystem.curvatureDrive(speed, rotation, turnInPlace);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("X Pos", Robot.getNavX().getQuaternionX());
        SmartDashboard.putNumber("Y Pos", Robot.getNavX().getQuaternionY());
    }
}
