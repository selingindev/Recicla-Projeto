package Colaborador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.sql.SQLException;
import reciclabackend.model.dao.DaoColaborador;
import reciclabackend.controller.ControllerColaborador;
import reciclabackend.model.bean.Colaborador;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raife
 */
public class DaoColaboradorTest {
    
    public DaoColaboradorTest() {
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
     * Test of buscar method, of class DaoColaborador.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 0;
        ControllerColaborador instance = new ControllerColaborador();
        Object expResult = new Colaborador(id);
        Object result = instance.buscar(id);
        assertTrue(result instanceof Colaborador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class DaoColaborador.
     */
    @Test
    public void testInserir() throws Exception{
        System.out.println("inserir");
        Object obj = null;
        DaoColaborador instance = new DaoColaborador();
        Object expResult = null;
        Object result = instance.inserir(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class DaoColaborador.
     */
    @Test
    public void testAlterar() throws Exception{
        System.out.println("alterar");
        Object obj = null;
        DaoColaborador instance = new DaoColaborador();
        Object expResult = null;
        Object result = instance.alterar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class DaoColaborador.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 0;
        DaoColaborador instance = new DaoColaborador();
        boolean expResult = false;
        boolean result = instance.excluir(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class DaoColaborador.
     */
    @Test
    public void testListar() throws Exception{
        System.out.println("listar");
        String filtro = "";
        DaoColaborador instance = new DaoColaborador();
        List<Object> expResult = null;
        List<Object> result = instance.listar(filtro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
