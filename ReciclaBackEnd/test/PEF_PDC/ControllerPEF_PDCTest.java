/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package PEF_PDC;

import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reciclabackend.controller.ControllerPEF_PDC;
import reciclabackend.model.bean.PefPdc;

/**
 *
 * @author olgac
 */
public class ControllerPEF_PDCTest {

    private ControllerPEF_PDC controller;
    private PefPdc registro;

    public ControllerPEF_PDCTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Início dos testes de PEF_PDC");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fim dos testes de PEF_PDC");
    }

    @Before
    public void setUp() throws Exception {
        controller = new ControllerPEF_PDC();

        // Criando um registro para ser usado nos testes
        registro = new PefPdc(0, 1, 1, 1, 1, "COD-TESTE", 10.0, new Date(System.currentTimeMillis()));
        registro = (PefPdc) controller.inserir(registro);
        assertNotNull(registro.getId());
    }

    @After
    public void tearDown() throws Exception {
        if (registro != null && registro.getId() > 0) {
            controller.excluir(registro.getId());
        }
    }

    /**
     * Test of inserir method, of class ControllerPEF_PDC.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        assertNotNull(registro);
        assertEquals("COD-TESTE", registro.getCod());
    }

    /**
     * Test of alterar method, of class ControllerPEF_PDC.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        registro.setCod("COD-ALTERADO");
        registro.setQuant(99.9);
        PefPdc alterado = (PefPdc) controller.alterar(registro);

        assertEquals("COD-ALTERADO", alterado.getCod());
        assertEquals(99.9, alterado.getQuant(), 0.01);
    }

    /**
     * Test of buscar method, of class ControllerPEF_PDC.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        PefPdc buscado = (PefPdc) controller.buscar(registro.getId());

        assertNotNull(buscado);
        assertEquals(registro.getId(), buscado.getId());
        assertEquals("COD-TESTE", buscado.getCod());
    }

    /**
     * Test of listar method, of class ControllerPEF_PDC.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        List<Object> lista = controller.listar("COD-TESTE");
        assertNotNull(lista);
        assertTrue(lista.size() > 0);

        boolean achou = false;
        for (Object o : lista) {
            assertTrue(o instanceof PefPdc);
            PefPdc p = (PefPdc) o;
            if (p.getId() == registro.getId()) {
                achou = true;
                break;
            }
        }
        assertTrue(achou);
    }

    /**
     * Test of excluir method, of class ControllerPEF_PDC.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        PefPdc novo = new PefPdc(0, 1, 1, 1, 1, "APAGAR", 5.5, new Date(System.currentTimeMillis()));
        PefPdc criado = (PefPdc) controller.inserir(novo);
        assertNotNull(criado.getId());

        boolean ok = controller.excluir(criado.getId());
        assertTrue(ok);
    }
}