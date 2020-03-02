/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class ALBasePilotable extends SubsystemBase {
  
//Déclaration des variables pour les 4 moteurs CIM de notre base pilotable  dans le  fichier "Class" Constants.java
// SpeedController est une librairie de WPI qui doit être importé
// SpeedControllerGroup est une librairie de WPI qui doit être importé
// DriveConstatnts doit être importé
//// DifferentialDrive est une librairie de WPI qui doit être importé

private final SpeedController m_rightFront = new WPI_TalonSRX(DriveConstants.kFRONT_RM_ID);
private final SpeedController m_rightFollower  = new WPI_VictorSPX(DriveConstants.kFOLLOWER_RM_ID);
private final SpeedController m_leftFront = new WPI_TalonSRX(DriveConstants.kFRONT_LM_ID);
private final SpeedController m_leftFollower = new WPI_VictorSPX(DriveConstants.kFOLLOWER_LM_ID);

//Déclaration des variables pour regrouper les moteurs en deux côtés 
private final SpeedControllerGroup m_leftSide;
private final SpeedControllerGroup m_rightSide;

// déclaration de la variable servant à appeler la conduite de style “Arcade Drive”
private DifferentialDrive m_drive;

// fin Étape 2

//étape 3  - Aller dans le fichier CONSTANTS.java
//Et créer une sous-classe appelé DriveConstants à l’intérieur de la classe Constants



// Étape 4 -Initialisation des sens de rotation des moteurs dans le constructeur 
  public ALBasePilotable() {

//inversion des sens de rotation des moteurs du côté droit du robot 
m_rightFront.setInverted(true);
m_rightFollower.setInverted(true);
m_leftFront.setInverted(false);
m_leftFollower.setInverted(false);


//regroupement des moteurs en pairs pour un côté gauche et droite 

m_rightSide = new SpeedControllerGroup( m_rightFront, m_rightFollower);
m_leftSide = new SpeedControllerGroup(m_leftFront, m_leftFollower);

// instanciation et initialisation de la variable m_drive dans le constructeur
//comme étant = à l’objet de la classe  DifferentialDrive et incluant les paramètres m_leftSide, et m_rightSide

m_drive = new DifferentialDrive(m_leftSide, m_rightSide);

//Fin Étape 4


  }


//Étape 5  - ajout de deux méthodes(actions) une pour la conduite de style ArcadeDrive 
//et l'autre pour l'arrêt du robot

// méthode pour la conduite de style arcade
public void drive(double forward, double turn) {
  m_drive.arcadeDrive(forward, turn);
}

// méthode pour arrêter le robot
public void stop() { 
  m_drive.stopMotor();
}





  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
