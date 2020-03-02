/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ALBasePilotable;

public class DriveCommand extends CommandBase {
  
  //Étape 7 -- Création des variables contenant les objets du sous-système "ALBasePilotable" et du Joystick
     
  private final DoubleSupplier m_forward;
  private final DoubleSupplier m_rotation;
  private final ALBasePilotable m_alBasePilotable;





//Étape 8 -  Déclaration des sous-systèmes et stockage des attributs dans le Constructeur: 
  public DriveCommand(DoubleSupplier forward, DoubleSupplier rotation, ALBasePilotable alBasePilotable) {
    
    m_forward = forward;
    m_rotation = rotation;
    m_alBasePilotable = alBasePilotable;

    addRequirements(m_alBasePilotable);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Étape 9 - Appel de la méthode drive associé avec la base pilotable 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_alBasePilotable.drive(m_forward.getAsDouble(), m_rotation.getAsDouble());

  }

  //Étape 10 - appel de la fonction end quand la valeur du booléenne (VRAI)
//est interrompue  
// Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_alBasePilotable.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
