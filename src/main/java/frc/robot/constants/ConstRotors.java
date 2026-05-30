// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.measure.AngularVelocity;

import static edu.wpi.first.units.Units.RPM;

public class ConstRotors {
  public static TalonFXConfiguration BALL_SHOOTER_CONFIG = new TalonFXConfiguration();

  static {
    BALL_SHOOTER_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    BALL_SHOOTER_CONFIG.CurrentLimits.SupplyCurrentLimitEnable = true;
    BALL_SHOOTER_CONFIG.CurrentLimits.SupplyCurrentLimit = 85; // TODO: tune current limits
    BALL_SHOOTER_CONFIG.CurrentLimits.SupplyCurrentLowerLimit = 60; // TODO: tune current limits
    BALL_SHOOTER_CONFIG.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    BALL_SHOOTER_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    BALL_SHOOTER_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    BALL_SHOOTER_CONFIG.Slot0.kS = 0; 
    BALL_SHOOTER_CONFIG.Slot0.kV = 0;
    BALL_SHOOTER_CONFIG.Slot0.kS = 0; 
    BALL_SHOOTER_CONFIG.Slot0.kV = 0;
    BALL_SHOOTER_CONFIG.Slot0.kA = 0;
    BALL_SHOOTER_CONFIG.Slot0.kP = 0;
    
    BALL_SHOOTER_CONFIG.MotionMagic.MotionMagicCruiseVelocity = 60;
    BALL_SHOOTER_CONFIG.MotionMagic.MotionMagicAcceleration = 600;
    BALL_SHOOTER_CONFIG.MotionMagic.MotionMagicJerk = 6000;
  }

  public static final AngularVelocity BALL_SHOOTER_SPEED = RPM.of(0.2); // TODO: Replace with actual speed
}
