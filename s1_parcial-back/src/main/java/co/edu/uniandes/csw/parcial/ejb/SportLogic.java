/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

import co.edu.uniandes.csw.parcial.persistence.SportPersistence;
import co.edu.uniandes.csw.parcial.entities.SportEntity;

/**
 *
 * @author elProfe
 */
@Stateless
public class SportLogic {
    
    private static final Logger LOGGER = Logger.getLogger( SportLogic.class.getName() );

    @Inject
    private SportPersistence persistence;
    
    public SportEntity getSport( Long sportId ) {
        LOGGER.log( Level.INFO, "Inicia proceso de consultar el deporte con id = {0}", sportId );
        SportEntity sportEntity = persistence.find( sportId );
        if( sportEntity == null ) {
            LOGGER.log( Level.SEVERE, "El deporte con el id = {0} no existe", sportId );
        }
        LOGGER.log( Level.INFO, "Termina proceso de consultar el deporte con id = {0}", sportId );
        return sportEntity;
    }
    
    
    
    
}
