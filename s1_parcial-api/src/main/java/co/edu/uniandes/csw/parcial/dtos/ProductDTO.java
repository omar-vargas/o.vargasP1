/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial.dtos;

import co.edu.uniandes.csw.parcial.entities.ProductEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author elProfe
 */
public class ProductDTO {
    private Long id;
     private String name;
    private String descripcion;
    private int cantidad;
    private int valor;
    private boolean unico;
  
    public ProductDTO(){
        
        
       
    }
    public ProductEntity toEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(this.id);
      
        

        return productEntity;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isUnico() {
        return unico;
    }

    public void setUnico(boolean unico) {
        this.unico = unico;
    }
    
    
     public ProductDTO(ProductEntity productEntity) {
        if (productEntity != null) {
            this.id = productEntity.getId();
            this.name = productEntity.getName();
            this.cantidad= productEntity.getCantidad();
        }

    /**
     * Método para transformar el DTO a una entidad.
     *
     * @return La entidad del libro asociado.
     */
    
     }} 
    
   
    
    
    
    
    
    
    
    

