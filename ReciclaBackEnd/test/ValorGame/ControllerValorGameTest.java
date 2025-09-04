/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ValorGame;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reciclabackend.controller.ControllerValorGame;
import static org.junit.Assert.*;
import reciclabackend.model.bean.ValorGame;

/**
 *
 * @author raife
 */
public class ControllerValorGameTest {
    
    public ControllerValorGameTest() {
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
     * Test of buscar method, of class ControllerValorGame.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 1;
        ControllerValorGame instance = new ControllerValorGame();
        ValorGame expResult = new ValorGame(1, 10, 3, 4, 1);
        ValorGame result = (ValorGame) instance.buscar(id);
        assertTrue(result instanceof ValorGame); 
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de buca valor-game falhou.");
    }

    /**
     * Test of inserir method, of class ControllerValorGame.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        ValorGame valor = new ValorGame(1, 10, 3, 4, 1);
        ControllerValorGame instance = new ControllerValorGame();
        ValorGame result = (ValorGame) instance.inserir(valor);
        assertTrue(result instanceof ValorGame); 
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de inserir falhou.");
    }

    /**
     * Test of alterar method, of class ControllerValorGame.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        ValorGame valor1 = new ValorGame(1, 10, 3, 4, 1);
        ControllerValorGame instance = new ControllerValorGame();
        ValorGame criado = (ValorGame) instance.inserir(valor1);
        
        criado.setValor(20);
        
        ValorGame result = (ValorGame) instance.alterar(criado);
        
        // Verifica
        assertEquals(criado.getId(), result.getId());
        assertEquals(20, result.getValor());
        
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de alterar falhou.");
    }

    /**
     * Test of excluir method, of class ControllerValorGame.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 1;
        ControllerValorGame instance = new ControllerValorGame();
        boolean result = instance.excluir(id);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de excluir falhou.");
    }

    /**
     * Test of listar method, of class ControllerValorGame.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        String filtro = "";
        ControllerValorGame instance = new ControllerValorGame();
        List<Object> result = instance.listar(filtro);
        assertTrue(result.size() >= 2); 
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de listar falhou.");
    }
    
}
