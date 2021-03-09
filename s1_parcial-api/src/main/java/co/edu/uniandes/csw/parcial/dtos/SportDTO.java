/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial.dtos;

import co.edu.uniandes.csw.parcial.entities.SportEntity;
import java.io.Serializable;

/**
 *
 * @author elProfe
 */
public class SportDTO implements Serializable {
    
    private Long id;
    
    private String name;
    
    public SportDTO() {
        
    }
    
    public SportDTO( SportEntity entity ) {
        if( entity != null ) {
            this.id = entity.getId();
            this.name = entity.getName();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
    
    public SportEntity toEntity() {
        SportEntity entity = new SportEntity();
        entity.setId( this.id );
        entity.setName( this.name );
        return entity;
    }
}
