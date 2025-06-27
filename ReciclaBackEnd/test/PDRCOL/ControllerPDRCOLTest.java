package PDRCOL;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import reciclabackend.controller.ControllerPDRCOL;
import reciclabackend.model.bean.PdrCol;
import static org.junit.Assert.*;

public class ControllerPDRCOLTest {
    
    private ControllerPDRCOL controller;

    @Before
    public void setUp() {
        controller = new ControllerPDRCOL();
    }

    @After
    public void tearDown() {
        // opcional: limpar dados depois dos testes
    }

    @Test
    public void testInserir() throws Exception {
        PdrCol pdr = new PdrCol(0, 10, 20); // id=0 (novo), idPRD=10, idCOL=20
        Object result = controller.inserir(pdr);
        assertNotNull(result);
        assertTrue(result instanceof PdrCol);
        PdrCol criado = (PdrCol) result;
        assertTrue(criado.getId() > 0);  // assumindo que o banco gera id
        assertEquals(10, criado.getIdPRD());
        assertEquals(20, criado.getIdCOL());
    }

    @Test
    public void testAlterar() throws Exception {
        PdrCol pdr = new PdrCol(0, 30, 40);
        PdrCol criado = (PdrCol) controller.inserir(pdr);
        
        criado.setIdPRD(50);
        criado.setIdCOL(60);
        Object alteradoObj = controller.alterar(criado);
        assertNotNull(alteradoObj);
        assertTrue(alteradoObj instanceof PdrCol);
        PdrCol alterado = (PdrCol) alteradoObj;
        assertEquals(criado.getId(), alterado.getId());
        assertEquals(50, alterado.getIdPRD());
        assertEquals(60, alterado.getIdCOL());
    }

    @Test
    public void testBuscar() throws Exception {
        PdrCol pdr = new PdrCol(0, 70, 80);
        PdrCol criado = (PdrCol) controller.inserir(pdr);
        
        Object encontrado = controller.buscar(criado.getId());
        assertNotNull(encontrado);
        assertTrue(encontrado instanceof PdrCol);
        PdrCol pdrEncontrado = (PdrCol) encontrado;
        assertEquals(criado.getId(), pdrEncontrado.getId());
        assertEquals(70, pdrEncontrado.getIdPRD());
        assertEquals(80, pdrEncontrado.getIdCOL());
    }

    @Test
    public void testExcluir() throws Exception {
        PdrCol pdr = new PdrCol(0, 90, 100);
        PdrCol criado = (PdrCol) controller.inserir(pdr);
        
        boolean excluido = controller.excluir(criado.getId());
        assertTrue(excluido);
        
        Object buscado = controller.buscar(criado.getId());
        assertNull(buscado);
    }

    @Test
    public void testListar() throws Exception {
        controller.inserir(new PdrCol(0, 111, 222));
        controller.inserir(new PdrCol(0, 333, 444));
        
        List<Object> lista = controller.listar("");
        assertNotNull(lista);
        assertTrue(lista.size() >= 2);
        for (Object obj : lista) {
            assertTrue(obj instanceof PdrCol);
        }
    }

    @Test
    public void testValidar() throws Exception {
        // Seu validar usa PdrCol e retorna boolean se achou no DAO
        PdrCol pdr = new PdrCol(0, 555, 666);
        controller.inserir(pdr);
        
        PdrCol paraValidar = new PdrCol(0, 555, 666);
        boolean valido = controller.validar(paraValidar);
        assertTrue(valido);

        PdrCol invalido = new PdrCol(0, 999, 888);
        boolean naoValido = controller.validar(invalido);
        assertFalse(naoValido);
    }

    @Test
    public void testValidarWeb() throws Exception {
        PdrCol pdr = new PdrCol(0, 777, 888);
        controller.inserir(pdr);

        PdrCol paraValidar = new PdrCol(0, 777, 888);
        PdrCol validado = controller.validarWeb(paraValidar);
        assertNotNull(validado);
        assertEquals(777, validado.getIdPRD());
        assertEquals(888, validado.getIdCOL());

        PdrCol invalido = new PdrCol(0, 111, 222);
        PdrCol naoValidado = controller.validarWeb(invalido);
        assertNull(naoValidado);
    }
}
