package PDRCOL;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import reciclabackend.controller.ControllerPDRCOL;
import static org.junit.Assert.*;
import reciclabackend.model.bean.PdrCol;

public class ControllerPDRCOLTest {
    
    ControllerPDRCOL controller;
    PdrCol pdrCriado;

    @Before
    public void setUp() {
        controller = new ControllerPDRCOL();
    }

    @After
    public void tearDown() throws Exception {
        if (pdrCriado != null && pdrCriado.getId() > 0) {
            controller.excluir(pdrCriado.getId());
        }
    }

    @Test
    public void testInserir() throws Exception {
        pdrCriado = new PdrCol(1, 2); // idPRD = 1, idCOL = 2
        PdrCol resultado = (PdrCol) controller.inserir(pdrCriado);
        assertNotNull(resultado);
        assertTrue(resultado.getId() > 0);
        assertEquals(1, resultado.getIdPRD());
        assertEquals(2, resultado.getIdCOL());
    }

    @Test
    public void testAlterar() throws Exception {
        pdrCriado = new PdrCol(3, 4);
        pdrCriado = (PdrCol) controller.inserir(pdrCriado);

        pdrCriado.setIdPRD(5);
        pdrCriado.setIdCOL(6);
        PdrCol alterado = (PdrCol) controller.alterar(pdrCriado);

        assertEquals(5, alterado.getIdPRD());
        assertEquals(6, alterado.getIdCOL());
    }

    @Test
    public void testBuscar() throws Exception {
        pdrCriado = new PdrCol(7, 8);
        pdrCriado = (PdrCol) controller.inserir(pdrCriado);

        PdrCol resultado = (PdrCol) controller.buscar(pdrCriado.getId());
        assertNotNull(resultado);
        assertEquals(7, resultado.getIdPRD());
        assertEquals(8, resultado.getIdCOL());
    }

    @Test
    public void testExcluir() throws Exception {
        pdrCriado = new PdrCol(9, 10);
        pdrCriado = (PdrCol) controller.inserir(pdrCriado);

        boolean resultado = controller.excluir(pdrCriado.getId());
        assertTrue(resultado);
        pdrCriado = null; // evita que o @After tente excluir de novo
    }

    @Test
    public void testListar() throws Exception {
        pdrCriado = new PdrCol(11, 12);
        controller.inserir(pdrCriado);

        List<Object> lista = controller.listar("");
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testValidar() throws Exception {
        pdrCriado = new PdrCol(13, 14);
        pdrCriado = (PdrCol) controller.inserir(pdrCriado);

        PdrCol entrada = new PdrCol(13, 14);
        boolean resultado = controller.validar(entrada);
        assertTrue(resultado);
    }

    @Test
    public void testValidarWeb() throws Exception {
        pdrCriado = new PdrCol(15, 16);
        pdrCriado = (PdrCol) controller.inserir(pdrCriado);

        PdrCol entrada = new PdrCol(15, 16);
        PdrCol resultado = controller.validarWeb(entrada);
        assertNotNull(resultado);
        assertEquals(15, resultado.getIdPRD());
        assertEquals(16, resultado.getIdCOL());
    }
}
