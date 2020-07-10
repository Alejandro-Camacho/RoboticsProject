/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import frc.robot.commands.DriveCommand;



public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new Motors.
   */
  static SpeedController = new WPI_VictorSPX(constants.method.constant);
  static SpeedController motorOne;
  static SpeedController motorTwo;
  static SpeedController motorThree;
  
  motorOne = new WPI_VictorSPX(Constants.DriveConstants.kPracOneID);
  motorTwo = new WPI_VictorSPX(Constants.DriveConstants.kPracTwoID);
  motorThree = new WPI_VictorSPX(Constants.DriveConstants.kPracThreeID);

  SpeedControllerGroup groupOne = new SpeedControllerGroup(motorOne, motorTwo);
  SpeedControllerGroup groupTwo = new SpeedControllerGroup(motorThree);

  public DifferentialDrive drive = new DifferentialDrive(groupOne, groupTwo);

  public void manualDrive(double move, double turn) {

    if (Math.abs(move) < 0.10) {
      move = 0;
    }
    
    if (Math.abs(turn) < 0.10) {
      move = 0;
    }
    drive.arcadeDrive(move, turn);

  }

  public DriveTrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

@Override
public void initDefaultCommand() {

setDefaultCommand(new DriveCommand());

}



}
