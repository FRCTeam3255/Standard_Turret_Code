// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;
import frc.robot.constants.ConstMotion.MechanismPositionGroup;
import frc.robot.Robot;
import frc.robot.RobotMap.*;

@Logged
public class Motion extends SubsystemBase {
  /** Creates a new Motion. */
  TalonFX turretPivotMotor;
  TalonFX hoodMotor;

  private Angle turretPivotLastDesiredAngle = Degrees.zero();
  private Angle hoodLastDesiredAngle = Degrees.zero();
  MotionMagicExpoVoltage positionRequest = new MotionMagicExpoVoltage(0);

  public Motion() {
    turretPivotMotor = new TalonFX(mapMotion.TURRET_PIVOT_CAN);
    hoodMotor = new TalonFX(mapMotion.HOOD_CAN);
  }

  private void setHoodPivotAngle(Angle angle, int slot) {
    hoodMotor.setControl(positionRequest.withPosition(angle).withSlot(slot));
    hoodLastDesiredAngle = angle;
  }

  private final void setTurretPivotAngle(Angle angle, int slot) {
    turretPivotMotor.setControl(positionRequest.withPosition(angle).withSlot(slot));
    turretPivotLastDesiredAngle = angle;
  }

  public void setHoodCoastMode(boolean coastMode) {
    if (coastMode) {
      ConstMotion.HOOD_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Coast;
      hoodMotor.getConfigurator().apply(ConstMotion.HOOD_CONFIG);
    } else {
      ConstMotion.HOOD_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      hoodMotor.getConfigurator().apply(ConstMotion.HOOD_CONFIG);
    }
  }

  public void setTurretCoastMode(boolean coastMode) {
    if (coastMode) {
      ConstMotion.TURRET_PIVOT_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Coast;
      turretPivotMotor.getConfigurator().apply(ConstMotion.TURRET_PIVOT_CONFIG);
    } else {
      ConstMotion.TURRET_PIVOT_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      turretPivotMotor.getConfigurator().apply(ConstMotion.TURRET_PIVOT_CONFIG);
    }
  }

  public Angle getHoodAngle() {
    if (Robot.isSimulation()) {
      return hoodLastDesiredAngle;
    }
    return hoodMotor.getPosition().getValue();
  }

  public Angle getTurretPivotAngle() {
    if (Robot.isSimulation()) {
      return turretPivotLastDesiredAngle;
    }
    return turretPivotMotor.getPosition().getValue();
  }

  public AngularVelocity getTurretPivotVelocity() {
    return turretPivotMotor.getRotorVelocity().getValue();
  }

  public AngularVelocity getHoodVelocity() {
    return hoodMotor.getRotorVelocity().getValue();
  }

  public boolean isTurretPivotVelocityZero() {
    return getTurretPivotVelocity().isNear(Units.RotationsPerSecond.zero(), 0.01);
  }

  public boolean isHoodVelocityZero() {
    return getHoodVelocity().isNear(Units.RotationsPerSecond.zero(), 0.01);
  }

  public boolean arePositionsAtSetPoint(MechanismPositionGroup positionGroup) {
    return (getTurretPivotAngle().isNear(positionGroup.turretPivotMotorAngle, ConstMotion.POSITION_TOLERANCE)
        && getHoodAngle().isNear(positionGroup.hoodMotorAngle, ConstMotion.POSITION_TOLERANCE));
  }

  @Override
  public void periodic() {
    //

  }
}
