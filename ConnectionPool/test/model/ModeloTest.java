/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Dao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class ModeloTest {
    
    public ModeloTest() {
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
     * Test of attach method, of class Modelo.
     */
    @Test
    public void testAttach() {
      
    }

    /**
     * Test of dettach method, of class Modelo.
     */
    @Test
    public void testDettach() {
       
    }

    /**
     * Test of NotifyTtoAll method, of class Modelo.
     */
    @Test
    public void testNotifyTtoAll() {
        
    }

    /**
     * Test of resgistraContato method, of class Modelo.
     */
    @Test
    public void testResgistraContato() {
      
    }

    /**
     * Test of atualizaContato method, of class Modelo.
     */
    @Test
    public void testAtualizaContato() {
       
    }

    /**
     * Test of excluir method, of class Modelo.
     */
    @Test
    public void testExcluir() {
     
    }

    /**
     * Test of getAgenda method, of class Modelo.
     */
    @Test
    public void testGetAgenda() {
        
    }

    /**
     * Test of setAgenda method, of class Modelo.
     */
    @Test
    public void testSetAgenda() {
     
    }

    /**
     * Test of getDao method, of class Modelo.
     */
    @Test
    public void testGetDao() {
      
    }

    /**
     * Test of setDao method, of class Modelo.
     */
    @Test
    public void testSetDao() {
    
    }

    /**
     * Test of buscarNome method, of class Modelo.
     */
    @Test
    public void testBuscarNome() {
        String nome="Evamberto";
        
        Modelo modelo = new Modelo()                        ;
        
        String resultado=modelo.buscarNome(nome);
       System.out.println(resultado);
    }
    
}
