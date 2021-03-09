/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author elProfe
 */
@Entity
public class SportEntity extends BaseEntity {
    
    private String name;
    @PodamExclude
    @OneToMany(mappedBy = "sport")
    private List<ProductEntity> events= new ArrayList<ProductEntity >();

    public List<ProductEntity> getEvents() {
        return events;
    }

    public void setEvents(List<ProductEntity> events) {
        this.events = events;
    }
    
    
    public SportEntity() {
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
}
