/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial.entities;

import javax.persistence.Entity;

/**
 *
 * @author elProfe
 */
@Entity
public class SportEntity extends BaseEntity {
    
    private String name;
    
    public SportEntity() {
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
}
