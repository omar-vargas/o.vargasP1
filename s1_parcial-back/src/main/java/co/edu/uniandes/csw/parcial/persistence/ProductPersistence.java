/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial.persistence;

import co.edu.uniandes.csw.parcial.entities.ProductEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author omarv
 */

  @Stateless
public class ProductPersistence {
    

    private static final Logger LOGGER = Logger.getLogger(ProductPersistence.class.getName());
    @PersistenceContext( unitName= "parcial1PU" )
    protected EntityManager em;
   

     public ProductEntity create( ProductEntity product ) {
        em.persist( product );
        return product;
    }
    
      public ProductEntity find( Long MedicoId ) {
        return em.find( ProductEntity.class, MedicoId );
    }
     
}
