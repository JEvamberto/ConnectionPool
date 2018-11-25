/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Agenda;
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
public class AgendaBDDaoTest {
    
    public AgendaBDDaoTest() {
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
     * Test of inserir method, of class AgendaBDDao.
     */
    @Test
    public void testInserir() {
      Agenda agenda = new Agenda();
      
      agenda.setEmail("Evamberto@lima.com");
      agenda.setNome("Evamberto");
      agenda.setTelefone("99899998");
      AgendaBDDao bd = new AgendaBDDao();
      bd.inserir(agenda);
    }

    /**
     * Test of deletar method, of class AgendaBDDao.
     */
    @Test
    public void testDeletar() {
         Agenda agenda = new Agenda();
      agenda.setId(2);
      
      AgendaBDDao bd = new AgendaBDDao();
      bd.deletar(agenda);
        
       
    }

    /**
     * Test of buscar method, of class AgendaBDDao.
     */
    @Test
    public void testBuscar() {
        
        
        AgendaBDDao bd = new AgendaBDDao();
        ArrayList<Agenda> lista = new ArrayList<>();
        
        lista= (ArrayList<Agenda>) bd.buscar();
        for (int i = 0; i < lista.size(); i++) {
            
            System.out.println(lista.get(i));
        }
        
        
     
    }

    /**
     * Test of atualizar method, of class AgendaBDDao.
     */
    @Test
    public void testAtualizar() {
        
          Agenda agenda = new Agenda();
      
      agenda.setEmail("Evamberto@lima.com");
      agenda.setNome("Evamberto");
      agenda.setTelefone("99899998");
      agenda.setId(3);
      AgendaBDDao bd = new AgendaBDDao();
      bd.atualizar(agenda);
        
      
    }
    
}
