// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap.mapRotors;
import frc.robot.constants.*;

@Logged
public class Rotors extends SubsystemBase {
  /** Creates a new Rotors. */

  TalonFX ballShooterMotor;

  public Rotors() {
    ballShooterMotor = new TalonFX(mapRotors.BALL_SHOOTER_CAN);

    ballShooterMotor.getConfigurator().apply(ConstRotors.BALL_SHOOTER_CONFIG);
  }

  public void setBallShooterMotorSpeed(double speed) {
    ballShooterMotor.set(speed);
  }

  public double getBallShooterMotorSpeed() {
    return ballShooterMotor.getRotorVelocity().getValue().in(Units.RPM);
  }

  public void stopBallShooterMotor() {
    ballShooterMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
