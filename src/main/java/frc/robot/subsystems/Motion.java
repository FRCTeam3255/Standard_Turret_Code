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
  TalonFX turretMotor;
  TalonFX hoodMotor;

  private Angle turretLastDesiredAngle = Degrees.zero();
  private Angle hoodLastDesiredAngle = Degrees.zero();
  MotionMagicExpoVoltage positionRequest = new MotionMagicExpoVoltage(0);

  public Motion() {
    turretMotor = new TalonFX(mapMotion.TURRET_PIVOT_CAN);
    hoodMotor = new TalonFX(mapMotion.HOOD_CAN);

    turretMotor.getConfigurator().apply(ConstMotion.TURRET_CONFIG);
    hoodMotor.getConfigurator().apply(ConstMotion.HOOD_CONFIG);
  }

  private void setHoodAngle(Angle angle, int slot) {
    hoodMotor.setControl(positionRequest.withPosition(angle).withSlot(slot));
    hoodLastDesiredAngle = angle;
  }

  private final void setTurretAngle(Angle angle, int slot) {
    turretMotor.setControl(positionRequest.withPosition(angle).withSlot(slot));
    turretLastDesiredAngle = angle;
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
      ConstMotion.TURRET_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Coast;
      turretMotor.getConfigurator().apply(ConstMotion.TURRET_CONFIG);
    } else {
      ConstMotion.TURRET_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      turretMotor.getConfigurator().apply(ConstMotion.TURRET_CONFIG);
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
      return turretLastDesiredAngle;
    }
    return turretMotor.getPosition().getValue();
  }

  public AngularVelocity getTurretPivotVelocity() {
    return turretMotor.getRotorVelocity().getValue();
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
