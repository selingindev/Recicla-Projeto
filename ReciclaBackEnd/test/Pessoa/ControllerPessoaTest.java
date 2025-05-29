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
        Object obj = new Pessoa("biel", 1);
        ControllerPessoa instance = new ControllerPessoa();
        Object expResult = new Pessoa(1, "biel", 1);
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
        Pessoa existente = new Pessoa("Original", 1);
        ControllerPessoa instance = new ControllerPessoa();
        Pessoa criada = (Pessoa) instance.inserir(existente);
    
         // Altera
        criada.setNome("biel alteração");
        criada.setIdLog(2);
        Pessoa alterada = (Pessoa) instance.alterar(criada);
    
        // Verifica
        assertEquals(criada.getId(), alterada.getId());
        assertEquals("biel alteração", alterada.getNome());
        assertEquals(2, alterada.getIdLog());
    }

    /**
     * Test of buscar method, of class ControllerPessoa.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 1;
        ControllerPessoa instance = new ControllerPessoa();
        Object expResult = new Pessoa(id, "teste banco", 4);
        Object result = instance.buscar(id);
        assertTrue(result instanceof Pessoa); 
        assertEquals(expResult, result);
        
    }

    /**
     * Test of excluir method, of class ControllerPessoa.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 1;
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
        Pessoa negocia = new Pessoa(123, "negocia", 2);
        Pessoa negocia2 = new Pessoa(124, "negocia", 5);
        List<Object> expResult = null;
        expResult.add(negocia2);
        expResult.add(negocia);
        List<Object> result = instance.listar(filtro);
        assertEquals(expResult, result);
    }

    /**
     * Test of listarTodos method, of class ControllerPessoa.
     */
    @Test
    public void testListarTodos() throws Exception {
        System.out.println("listarTodos");
        ControllerPessoa instance = new ControllerPessoa();
        List<Object> result = instance.listarTodos();
        assertTrue(result.size() >= 2); // Pode ter mais de outros testes
    
        // Verifica integridade básica
        for (Object obj : result) {
            assertTrue(obj instanceof Pessoa);
        }
    }
    
}
