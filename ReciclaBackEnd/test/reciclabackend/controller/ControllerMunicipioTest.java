/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package reciclabackend.controller;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reciclabackend.model.bean.Municipio;

/**
 *
 * @author raife
 */
public class ControllerMunicipioTest {
    
    public ControllerMunicipioTest() {
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
     * Test of buscar method, of class ControllerMunicipio.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 1;
        ControllerMunicipio instance = new ControllerMunicipio();
        Municipio expResult = new Municipio(1, "carapicuiba");
        Municipio result = (Municipio) instance.buscar(id);
        assertTrue(result instanceof Municipio); 
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de buca valor-game falhou.");
    }

    /**
     * Test of inserir method, of class ControllerMunicipio.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Municipio muni = new Municipio(1, "carapicuiba");
        ControllerMunicipio instance = new ControllerMunicipio();
        Municipio result = (Municipio) instance.inserir(muni);
        assertTrue(result instanceof Municipio);
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de inserir falhou.");
    }

    /**
     * Test of alterar method, of class ControllerMunicipio.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Municipio muni = new Municipio(1, "carapicuiba");
        ControllerMunicipio instance = new ControllerMunicipio();
        Municipio criado = (Municipio) instance.inserir(muni);
        
        String nome = "Osasco";
        criado.setNome(nome);
        
        Municipio result = (Municipio) instance.alterar(criado);
        
        // Verifica
        assertEquals(criado.getId(), result.getId());
        assertEquals(nome, result.getNome());
        
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de alterar falhou.");
    }

    /**
     * Test of excluir method, of class ControllerMunicipio.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 1;
        ControllerMunicipio instance = new ControllerMunicipio();
        boolean result = instance.excluir(id);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de excluir falhou.");
    }

    /**
     * Test of listar method, of class ControllerMunicipio.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        String filtro = "";
        ControllerMunicipio instance = new ControllerMunicipio();
        List<Object> result = instance.listar(filtro);
        assertTrue(result.size() >= 2); 
        // TODO review the generated test code and remove the default call to fail.
        fail("Teste de listar falhou.");
    }
    
}
