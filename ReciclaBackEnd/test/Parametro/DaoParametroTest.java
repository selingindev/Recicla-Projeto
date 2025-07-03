/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Parametro;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import reciclabackend.model.dao.DaoParametro;
import reciclabackend.controller.ControllerParametro;
import reciclabackend.model.bean.Parametro;
import static org.junit.Assert.*;

/**
 *
 * @author raife
 */
public class DaoParametroTest {
    
    public DaoParametroTest() {
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
     * Test of inserir method, of class DaoParametro.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Object obj = new Parametro(4, "crash");
        ControllerParametro instance = new ControllerParametro();
        Object expResult = new Parametro(4, "crash");
        Object result = instance.inserir(obj);
        assertTrue(result instanceof Parametro);
        
        fail("Teste de inserir falhou.");
    }

    /**
     * Test of alterar method, of class DaoParametro.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        
        // Controller
        ControllerParametro instance = new ControllerParametro();
        
        //Criação do parametro
        Object obj1 = new Parametro(4, "crash");
        Parametro criada = (Parametro) instance.inserir(obj1);
        
        // Alteração
        criada.setDescricao("j");
        Parametro alterada = (Parametro) instance.alterar(criada);
        
        // Verificação
        assertEquals(criada.getId(), alterada.getId());
        assertEquals("j", alterada.getDescricao());
        
        fail("Teste de alterar parametro falhou.");
    }

    /**
     * Test of excluir method, of class DaoParametro.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 0;
        ControllerParametro instance = new ControllerParametro();
        boolean result = instance.excluir(id);
        assertTrue(result);
        fail("Teste de excluir parametro falhou.");
    }

    /**
     * Test of buscar method, of class DaoParametro.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int cod = 1;
        ControllerParametro instance = new ControllerParametro();
        
        Parametro param = new Parametro(1, "toothless");
        List<Object> expResult = new ArrayList<>();
        expResult.add(param);
        
        Object result = instance.buscar(cod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste buscar parametro falhou");
    }

    /**
     * Test of listar method, of class DaoParametro.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        String filtro = "";
        ControllerParametro instance = new ControllerParametro();
        
        List<Object> result = instance.listar(filtro);
        assertTrue(result.size() >= 2); 
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste listar Parametros falhou");
    }
    
}
