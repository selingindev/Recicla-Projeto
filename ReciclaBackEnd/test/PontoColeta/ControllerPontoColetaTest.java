/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package PontoColeta;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reciclabackend.controller.ControllerPontoColeta;
import reciclabackend.model.bean.PontoColeta;
import static org.junit.Assert.*;

/**
 *
 * @author ana
 */
public class ControllerPontoColetaTest {
    
    public ControllerPontoColetaTest() {
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
     * Test of inserir method, of class ControllerPontoColeta.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Object obj = new PontoColeta(0, 1, "Ponto Teste", "QR123");
        ControllerPontoColeta instance = new ControllerPontoColeta();
        Object result = instance.inserir(obj);
        assertTrue(result instanceof PontoColeta);
        PontoColeta ponto = (PontoColeta) result;
        assertNotNull(ponto.getId());
    }

    /**
     * Test of alterar method, of class ControllerPontoColeta.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        PontoColeta original = new PontoColeta(0, 2, "Original", "QR999");
        ControllerPontoColeta instance = new ControllerPontoColeta();
        PontoColeta criada = (PontoColeta) instance.inserir(original);

        criada.setNome("Alterado");
        criada.setQrCode("QR456");
        PontoColeta alterada = (PontoColeta) instance.alterar(criada);

        assertEquals(criada.getId(), alterada.getId());
        assertEquals("Alterado", alterada.getNome());
        assertEquals("QR456", alterada.getQrCode());
    }

    /**
     * Test of buscar method, of class ControllerPontoColeta.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        ControllerPontoColeta instance = new ControllerPontoColeta();
        PontoColeta inserido = (PontoColeta) instance.inserir(new PontoColeta(0, 3, "Buscar Teste", "QR789"));
        Object result = instance.buscar(inserido.getId());
        assertTrue(result instanceof PontoColeta);
        PontoColeta encontrado = (PontoColeta) result;

        assertEquals(inserido.getId(), encontrado.getId());
        assertEquals(inserido.getNome(), encontrado.getNome());
        assertEquals(inserido.getQrCode(), encontrado.getQrCode());
    }

    /**
     * Test of excluir method, of class ControllerPontoColeta.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        ControllerPontoColeta instance = new ControllerPontoColeta();
        PontoColeta ponto = (PontoColeta) instance.inserir(new PontoColeta(0, 4, "Excluir Teste", "QR000"));
        boolean result = instance.excluir(ponto.getId());
        assertTrue(result);
    }

    /**
     * Test of listar method, of class ControllerPontoColeta.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        String filtro = "Filtro";
        ControllerPontoColeta instance = new ControllerPontoColeta();
        PontoColeta p1 = new PontoColeta(0, 5, "Filtro Teste A", "QRA");
        PontoColeta p2 = new PontoColeta(0, 6, "Filtro Teste B", "QRB");
        instance.inserir(p1);
        instance.inserir(p2);

        List<Object> result = instance.listar(filtro);
        assertNotNull(result);
        assertTrue(result.size() >= 2);

        for (Object obj : result) {
            assertTrue(obj instanceof PontoColeta);
        }
    }
}
