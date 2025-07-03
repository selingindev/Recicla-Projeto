/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ValorCredito;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reciclabackend.controller.ControllerValorCredito;
import static org.junit.Assert.*;
import reciclabackend.model.bean.ValorCredito;

/**
 *
 * @author raife
 */
public class ControllerValorCreditoTest {
    
    public ControllerValorCreditoTest() {
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
     * Test of buscar method, of class ControllerValorCredito.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 1;
        ControllerValorCredito instance = new ControllerValorCredito();
        // id, double valor, int idMat, int idPar, int idMuni);
        ValorCredito expResult = new ValorCredito(1, 10, 3, 4, 1);
        Object result = instance.buscar(id);
        assertTrue(result instanceof ValorCredito); 
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de buca valor-credito falhou.");
    }

    /**
     * Test of inserir method, of class ControllerValorCredito.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        ValorCredito valor = new ValorCredito(1, 10, 3, 4, 1);
        ControllerValorCredito instance = new ControllerValorCredito();
        Object result = instance.inserir(valor);
        assertTrue(result instanceof ValorCredito); 
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de inserir falhou.");
    }

    /**
     * Test of alterar method, of class ControllerValorCredito.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        ValorCredito valor1 = new ValorCredito(1, 10, 3, 4, 1);
        ControllerValorCredito instance = new ControllerValorCredito();
        ValorCredito criado = (ValorCredito) instance.inserir(valor1);
        
        criado.setValor(15);
        ValorCredito result = (ValorCredito) instance.alterar(criado);
        
        // Verifica
        assertEquals(criado.getId(), result.getId());
        assertEquals(15, result.getValor());
        
        fail("Teste de alterar falhou.");
    }

    /**
     * Test of excluir method, of class ControllerValorCredito.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 1;
        ControllerValorCredito instance = new ControllerValorCredito();
        boolean result = instance.excluir(id);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de excluir falhou.");
    }

    /**
     * Test of listar method, of class ControllerValorCredito.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        String filtro = "";
        ControllerValorCredito instance = new ControllerValorCredito();
        List<Object> result = instance.listar(filtro);
        assertTrue(result.size() >= 2); 
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de listar falhou.");
    }
    
}
