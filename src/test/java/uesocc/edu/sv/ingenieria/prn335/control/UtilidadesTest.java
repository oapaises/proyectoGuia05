/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.control;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uesocc.edu.sv.ingenieria.prn335.entities.Marca;

/**
 *
 * @author oapaises
 */
@RunWith(Arquillian.class)
public class UtilidadesTest {
    
    public UtilidadesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class Utilidades.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Marca entity = new Marca(1,"Toyota",true) ;
        Marca entity1= new Marca(2, "Ford", true);
        Marca entity2= new Marca(3, "Suzuky", true);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Utilidades instance = (Utilidades)container.getContext().lookup("java:global/classes/Utilidades");
        instance.insert(entity);
        instance.insert(entity1);
        instance.insert(entity2);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
         System.out.println("insert complete");
    }

    /**
     * Test of update method, of class Utilidades.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Marca entity = new Marca(1,"Nissan",true);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Utilidades instance = (Utilidades)container.getContext().lookup("java:global/classes/Utilidades");
        instance.update(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
         System.out.println("update Complete");
    }

    /**
     * Test of delete method, of class Utilidades.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Marca entity = new Marca(3,"Suzuky", true);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Utilidades instance = (Utilidades)container.getContext().lookup("java:global/classes/Utilidades");
        instance.delete(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("delete Complete");
    }

    /**
     * Test of selectAll method, of class Utilidades.
     */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println("selectAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Utilidades instance = (Utilidades)container.getContext().lookup("java:global/classes/Utilidades");
        List<Marca> expResult = null;
        List<Marca> result = instance.selectAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByCampos method, of class Utilidades.
     */
    @Test
    public void testFindByCampos() throws Exception {
        System.out.println("findByCampos");
        String busqueda = "Ford";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Utilidades instance = (Utilidades)container.getContext().lookup("java:global/classes/Utilidades");
        List<Marca> expResult = null;
        List<Marca> result = instance.findByCampos(busqueda);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("findByCampos Complete");
    }

    /**
     * Test of findRange method, of class Utilidades.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int inicio = 1;
        int fin = 2;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Utilidades instance = (Utilidades)container.getContext().lookup("java:global/classes/Utilidades");
        List<Marca> expResult = null;
        List<Marca> result = instance.findRange(inicio, fin);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("findRange Complete");
    }

    /**
     * Test of findByMultiple method, of class Utilidades.
     */
    @Test
    public void testFindByMultiple() throws Exception {
        System.out.println("findByMultiple");
        String[] campos = null;
        String[] busquedas = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Utilidades instance = (Utilidades)container.getContext().lookup("java:global/classes/Utilidades");
        List<Marca> expResult = null;
        List<Marca> result = instance.findByMultiple(campos, busquedas);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
