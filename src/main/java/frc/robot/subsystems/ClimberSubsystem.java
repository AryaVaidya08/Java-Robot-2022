// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.beans.Encoder;

import javax.swing.text.html.HTMLDocument.BlockElement;

//import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;

import frc.robot.RobotMap;
import frc.robot.RobotMap.Climber;
import frc.robot.util.GroundedDigitalInput;

public class ClimberSubsystem extends SubsystemBase {

	private CANSparkMax climbMotor;
	private GroundedDigitalInput blLimitSwitch, brLimitSwitch, tlLimitSwitch, trLimitSwitch;
	private RelativeEncoder climbMotorEncoder;

	public ClimberSubsystem() {
		climbMotor = new CANSparkMax(RobotMap.Climber.CLIMB_PORT_ID, MotorType.kBrushless);
		climbMotor.setInverted(RobotMap.Climber.CLIMB_MOTOR_INVERTED);
		climbMotor.setIdleMode(IdleMode.kBrake);
		blLimitSwitch = new GroundedDigitalInput(RobotMap.Climber.BOTTOM_LEFT_LIMIT_SWITCH);
		brLimitSwitch = new GroundedDigitalInput(RobotMap.Climber.BOTTOM_RIGHT_LIMIT_SWITCH);
		tlLimitSwitch = new GroundedDigitalInput(RobotMap.Climber.TOP_LEFT_LIMIT_SWITCH);
		trLimitSwitch = new GroundedDigitalInput(RobotMap.Climber.TOP_RIGHT_LIMIT_SWITCH);
		climbMotorEncoder = climbMotor.getEncoder();
	}

	public void setClimbMotor(CANSparkMax motor) {
		climbMotor = motor;
	}

	public CANSparkMax getClimbMotor() {
		return climbMotor;
	}

	public RelativeEncoder getMotorEncoder() {
		return climbMotorEncoder;
	}

	public boolean getBottomLeftLimitSwitchValue() {
		return blLimitSwitch.get();
	}

	public boolean getBottomRightLimitSwitchValue() {
		return brLimitSwitch.get();
	}

	public boolean getTopLeftLimitSwitchValue() {
		return tlLimitSwitch.get();
	}

	public boolean getTopRightLimitSwitchValue() {
		return trLimitSwitch.get();
	}

	public boolean climbAtBottom() {
		return blLimitSwitch.get() || brLimitSwitch.get();
	}

	public boolean climbAtTop() {
		return tlLimitSwitch.get() || trLimitSwitch.get();
	}

	public double getEncoderDistance() {
		return Math.abs(climbMotorEncoder.getPosition());
	}

	public void climberMove(double speed) {
		climbMotor.set(speed);
	}

	public void resetEncoders() {
		climbMotorEncoder.setPosition(0);
	}

	public void setNeutralMode(IdleMode mode) {
		climbMotor.setIdleMode(mode);
	}

	public void updateBrakeSwitch() {
		//UHHHHHHHHHHHHHHHHHHHHHHHh
	}

}
