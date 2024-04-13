// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  WPI_TalonSRX frontLeft = new WPI_TalonSRX(0);
  WPI_TalonSRX frontRight = new WPI_TalonSRX(1);
  WPI_TalonSRX backLeft = new WPI_TalonSRX(2);
  WPI_TalonSRX backRight = new WPI_TalonSRX(3);

  XboxController controller = new XboxController(0);

  DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);
  public Drivetrain() {
    frontRight.setInverted(true);
    backRight.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    drive.arcadeDrive(controller.getLeftY() * OperatorConstants.kShowDriveSpeed * (1 + controller.getRightTriggerAxis()), -controller.getRightX() * OperatorConstants.kShowTurnSpeed * (1 + controller.getRightTriggerAxis()));
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

  }
}
