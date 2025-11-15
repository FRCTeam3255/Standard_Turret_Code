// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class ConstRotors {
  public static TalonFXConfiguration BALL_SHOOTER_CONFIG = new TalonFXConfiguration();

  static {
    BALL_SHOOTER_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    BALL_SHOOTER_CONFIG.CurrentLimits.SupplyCurrentLimitEnable = true;
    BALL_SHOOTER_CONFIG.CurrentLimits.SupplyCurrentLimit = 85; // TODO: tune current limits
    BALL_SHOOTER_CONFIG.CurrentLimits.SupplyCurrentLowerLimit = 60; // TODO: tune current limits
    BALL_SHOOTER_CONFIG.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
  }

  public static final double BALL_SHOOTER_SPEED = 0.2; // TODO: Replace with actual speed
}
