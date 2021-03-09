/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial.ejb;

import co.edu.uniandes.csw.parcial.entities.ProductEntity;
import co.edu.uniandes.csw.parcial.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.parcial.persistence.ProductPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author omarv
 */
@Stateless
public class ProductLogic {
    
    
    
    
    @Inject
    private ProductPersistence persistence; 
    
    
    public ProductEntity createProduct(ProductEntity ProductEntity) throws BusinessLogicException {
       
        // Verifica la regla de negocio que dice que no puede haber dos Productes con el mismo nombre
        if (persistence.find(ProductEntity.getId()) != null    ){
            throw new BusinessLogicException("Ya existe una Product con el id dado  \""  + "\"");
        }
        
         if (  ProductEntity.getName()==null|| ProductEntity.getName().equals("")    ){
            throw new BusinessLogicException("  El nombre  no pueden ser vacio o nulo "  + "\"");
        }
         
        if (ProductEntity.getValor()==0&& ProductEntity.getCantidad()>=1 ) {
            throw new BusinessLogicException( "El valor del producto no puede ser cero si el producto tiene unidades");
        }
          
         if (ProductEntity.getValor()<0&& ProductEntity.getCantidad()<1 ) {
            throw new BusinessLogicException( "Ni el valor ni las unidades pueden ser negativas");
        }
        if (ProductEntity.getSport().getName().contains("Futbol")&& ProductEntity.isUnico()) {
            throw new BusinessLogicException( "No se permiten productos únicos para el deporte 'Futbol'.");
        }  
        
        if (ProductEntity.getSport()==null) {
            throw new BusinessLogicException( "El deporte no puede ser nulo");
        }  
        
        // Invoca la persistencia para crear la Product
        persistence.create(ProductEntity);
      
        return ProductEntity;
    }
    
    
}
