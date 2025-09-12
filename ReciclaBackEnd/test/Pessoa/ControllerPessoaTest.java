/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Pessoa;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reciclabackend.controller.ControllerPessoa;
import static org.junit.Assert.*;
import reciclabackend.model.bean.Pessoa;

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
        Object obj = new Pessoa("biel", 6, "emaildobiel", "4385732");
        ControllerPessoa instance = new ControllerPessoa();
        Object result = instance.inserir(obj);
        assertTrue(result instanceof Pessoa);
        Pessoa pessoa = (Pessoa) result;
        assertNotNull(pessoa.getId());
    }

    /**
     * Test of alterar method, of class ControllerPessoa.
     */
    @Test
    public void testAlterar() throws Exception {
         // Pré-cria registro
        Pessoa existente = new Pessoa("Original", 6, "email", "242332425");
        ControllerPessoa instance = new ControllerPessoa();
        Pessoa criada = (Pessoa) instance.inserir(existente);
    
         // Altera
        criada.setNome("biel alteração");
        criada.setEmail("alteração email");
        Pessoa alterada = (Pessoa) instance.alterar(criada);
    
        // Verifica
        assertEquals(criada.getId(), alterada.getId());
        assertEquals("biel alteração", alterada.getNome());
        assertEquals(6, alterada.getIdLog());
    }

    /**
     * Test of buscar method, of class ControllerPessoa.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 1;
        ControllerPessoa instance = new ControllerPessoa();
        Object result = instance.buscar(id);
        assertTrue(result instanceof Pessoa); 
        
    }

    /**
     * Test of excluir method, of class ControllerPessoa.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 2;
        ControllerPessoa instance = new ControllerPessoa();
        boolean result = instance.excluir(id);
        assertTrue(result);
    }

    /**
     * Test of listar method, of class ControllerPessoa.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        String filtro = "negocia";
        ControllerPessoa instance = new ControllerPessoa();
        List<Object> result = instance.listar(filtro);
        assertFalse(result.isEmpty());
        Pessoa negocia = (Pessoa) result.getFirst();
        assertEquals(negocia.getNome(), "Negocia");
    }

    /** 
     * Test of listarTodos method, of class ControllerPessoa.
     */
    @Test
    public void testListarTodos() throws Exception {
        System.out.println("listarTodos");
        ControllerPessoa instance = new ControllerPessoa();
        List<Object> result = instance.listarTodos();
        assertTrue(result.size() >= 2); 
    
        
        for (Object obj : result) {
            assertTrue(obj instanceof Pessoa);
        }
    }
    
}
