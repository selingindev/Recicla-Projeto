/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Pessoa;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reciclabackend.controller.ControllerPessoa;
import static org.junit.Assert.*;

/**
 *
 * @author olgac
 */
public class ControllerPessoaTest {
    
    public ControllerPessoaTest() {
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
     * Test of inserir method, of class ControllerPessoa.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Object obj = null;
        ControllerPessoa instance = new ControllerPessoa();
        Object expResult = null;
        Object result = instance.inserir(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class ControllerPessoa.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Object obj = null;
        ControllerPessoa instance = new ControllerPessoa();
        Object expResult = null;
        Object result = instance.alterar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ControllerPessoa.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 0;
        ControllerPessoa instance = new ControllerPessoa();
        Object expResult = null;
        Object result = instance.buscar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class ControllerPessoa.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 0;
        ControllerPessoa instance = new ControllerPessoa();
        boolean expResult = false;
        boolean result = instance.excluir(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class ControllerPessoa.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        String filtro = "";
        ControllerPessoa instance = new ControllerPessoa();
        List<Object> expResult = null;
        List<Object> result = instance.listar(filtro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class ControllerPessoa.
     */
    @Test
    public void testListarTodos() throws Exception {
        System.out.println("listarTodos");
        ControllerPessoa instance = new ControllerPessoa();
        List<Object> expResult = null;
        List<Object> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
