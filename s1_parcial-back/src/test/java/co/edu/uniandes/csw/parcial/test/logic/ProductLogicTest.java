/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial.test.logic;

import co.edu.uniandes.csw.parcial.ejb.ProductLogic;
import co.edu.uniandes.csw.parcial.ejb.SportLogic;
import co.edu.uniandes.csw.parcial.entities.ProductEntity;
import co.edu.uniandes.csw.parcial.entities.SportEntity;
import co.edu.uniandes.csw.parcial.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.parcial.persistence.ProductPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author omarv
 */

@RunWith(Arquillian.class)
public class ProductLogicTest {
    
    
    
     private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ProductLogic ProductLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;
    private List<SportEntity> datasport = new ArrayList<SportEntity>();
    private List<ProductEntity> data = new ArrayList<ProductEntity>();
    @Inject
    private SportLogic billLogic;
    

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ProductEntity.class.getPackage())
                .addPackage(ProductLogic.class.getPackage())
                .addPackage(ProductPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from ProductEntity").executeUpdate();
       
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 8; i++) {
            ProductEntity entity = factory.manufacturePojo(ProductEntity.class);

            em.persist(entity);
            data.add(entity);
        }
         for (int i = 0; i < 8; i++) {
           SportEntity entity = factory.manufacturePojo(SportEntity.class);

            em.persist(entity);
            datasport.add(entity);
        }
        
     
    }

    /**
     * Prueba para crear un Product
     *
     * @throws co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException
     * @throws co.edu.uniandes.csw.Productstore.exceptions.BusinessLogicException
     */
    @Test
    public void createProductTest() throws BusinessLogicException {
        ProductEntity newEntity = factory.manufacturePojo(ProductEntity.class);
        ProductEntity result = ProductLogic.createProduct(newEntity);
        Assert.assertNotNull(result);
        ProductEntity entity = em.find(ProductEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCantidad(),entity.getCantidad());
        Assert.assertEquals(newEntity.getDescripcion(),entity.getDescripcion());
         
      
        
    }

    @Test(expected = BusinessLogicException.class)
    public void createNameNull() throws BusinessLogicException {
        ProductEntity newEntity = factory.manufacturePojo(ProductEntity.class);
        newEntity.setName(null);
        ProductLogic.createProduct(newEntity);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createNegative() throws BusinessLogicException {
        ProductEntity newEntity = factory.manufacturePojo(ProductEntity.class);
        newEntity.setValor(-8);
        newEntity.setCantidad(-5);
        ProductLogic.createProduct(newEntity);
    }
    
    
}
