// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

/** Add your docs here. */
public class ConstMotion {
  public static TalonFXConfiguration TURRET_CONFIG = new TalonFXConfiguration();

  static {
    // elevator motor config
    // TODO: tune pid values
    TURRET_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    TURRET_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    TURRET_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    TURRET_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Rotations.of(60).in(Units.Rotations);
    TURRET_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    TURRET_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Rotations.of(0).in(Units.Rotations);
    TURRET_CONFIG.Slot0.GravityType = GravityTypeValue.Elevator_Static;
    TURRET_CONFIG.Slot0.kP = 0;
    TURRET_CONFIG.Slot0.kI = 0;
    TURRET_CONFIG.Slot0.kD = 0;
    TURRET_CONFIG.Slot0.kS = 0;
    TURRET_CONFIG.Slot0.kG = 0;

    TURRET_CONFIG.Feedback.SensorToMechanismRatio = (0); // TODO: replace with actual ratio
    TURRET_CONFIG.MotionMagic.MotionMagicCruiseVelocity = 0;
    TURRET_CONFIG.MotionMagic.MotionMagicAcceleration = 0;
    TURRET_CONFIG.MotionMagic.MotionMagicExpo_kV = 0;
    TURRET_CONFIG.MotionMagic.MotionMagicExpo_kA = 0;
    TURRET_CONFIG.CurrentLimits.SupplyCurrentLimitEnable = true;
    TURRET_CONFIG.CurrentLimits.SupplyCurrentLowerLimit = 30; // TODO: tune current limits
    TURRET_CONFIG.CurrentLimits.SupplyCurrentLimit = 60; // TODO: tune current limits
    TURRET_CONFIG.CurrentLimits.SupplyCurrentLowerTime = 1;

    // elevator pivot motor config
    TURRET_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    TURRET_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    TURRET_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    TURRET_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Rotations.of(0)
        .in(Units.Degrees);
    TURRET_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    TURRET_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Rotations.of(0)
        .in(Units.Degrees);

    TURRET_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    TURRET_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Rotations.of(0)
        .in(Units.Degrees);
  }

  public static TalonFXConfiguration HOOD_CONFIG = new TalonFXConfiguration();

  static {
    // elevator motor config
    // TODO: tune pid values
    HOOD_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    HOOD_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    HOOD_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    HOOD_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Rotations.of(60).in(Units.Rotations);
    HOOD_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    HOOD_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Rotations.of(0).in(Units.Rotations);
    HOOD_CONFIG.Slot0.GravityType = GravityTypeValue.Elevator_Static;
    HOOD_CONFIG.Slot0.kP = 0;
    HOOD_CONFIG.Slot0.kI = 0;
    HOOD_CONFIG.Slot0.kD = 0;
    HOOD_CONFIG.Slot0.kS = 0;
    HOOD_CONFIG.Slot0.kG = 0;

    HOOD_CONFIG.Feedback.SensorToMechanismRatio = (0); // TODO: replace with actual ratio
    HOOD_CONFIG.MotionMagic.MotionMagicCruiseVelocity = 0;
    HOOD_CONFIG.MotionMagic.MotionMagicAcceleration = 0;
    HOOD_CONFIG.MotionMagic.MotionMagicExpo_kV = 0;
    HOOD_CONFIG.MotionMagic.MotionMagicExpo_kA = 0;
    HOOD_CONFIG.CurrentLimits.SupplyCurrentLimitEnable = true;
    HOOD_CONFIG.CurrentLimits.SupplyCurrentLowerLimit = 30; // TODO: tune current limits
    HOOD_CONFIG.CurrentLimits.SupplyCurrentLimit = 60; // TODO: tune current limits
    HOOD_CONFIG.CurrentLimits.SupplyCurrentLowerTime = 1;

    // elevator pivot motor config
    HOOD_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    HOOD_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    HOOD_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    HOOD_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Rotations.of(0)
        .in(Units.Degrees);
  }

  public static final double POSITION_TOLERANCE = Units.Degrees.of(1).in(Units.Rotations);

  public static class MechanismPositionGroup {
    public Angle turretPivotMotorAngle;
    public Angle hoodMotorAngle;
  }
}
