package PontoReciclagem;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reciclabackend.controller.ControllerPontoReciclagem;
import static org.junit.Assert.*;
import reciclabackend.model.bean.PontoReciclagem;

public class ControllerPontoReciclagemTest {
    
    ControllerPontoReciclagem controller;
    PontoReciclagem pontoCriado;

    public ControllerPontoReciclagemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        controller = new ControllerPontoReciclagem();
    }

    @After
    public void tearDown() throws Exception {
        if (pontoCriado != null && pontoCriado.getId() > 0) {
            controller.excluir(pontoCriado.getId());
        }
    }

    @Test
    public void testInserir() throws Exception {
        pontoCriado = new PontoReciclagem(1, "Teste Ponto");
        PontoReciclagem resultado = (PontoReciclagem) controller.inserir(pontoCriado);
        assertNotNull(resultado);
        assertTrue(resultado.getId() > 0);
        assertEquals("Teste Ponto", resultado.getNome());
    }

    @Test
    public void testAlterar() throws Exception {
        pontoCriado = new PontoReciclagem(1, "Original");
        pontoCriado = (PontoReciclagem) controller.inserir(pontoCriado);

        pontoCriado.setNome("Alterado");
        PontoReciclagem alterado = (PontoReciclagem) controller.alterar(pontoCriado);
        assertEquals("Alterado", alterado.getNome());
    }

    @Test
    public void testBuscar() throws Exception {
        pontoCriado = new PontoReciclagem(1, "Buscar Teste");
        pontoCriado = (PontoReciclagem) controller.inserir(pontoCriado);

        PontoReciclagem resultado = (PontoReciclagem) controller.buscar(pontoCriado.getId());
        assertNotNull(resultado);
        assertEquals("Buscar Teste", resultado.getNome());
    }

    @Test
    public void testExcluir() throws Exception {
        pontoCriado = new PontoReciclagem(1, "Excluir Teste");
        pontoCriado = (PontoReciclagem) controller.inserir(pontoCriado);

        boolean resultado = controller.excluir(pontoCriado.getId());
        assertTrue(resultado);
        pontoCriado = null; // Impede reexecução do teardown
    }

    @Test
    public void testListar() throws Exception {
        pontoCriado = new PontoReciclagem(1, "Filtro Teste");
        controller.inserir(pontoCriado);

        List<Object> lista = controller.listar("1");
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testValidar() throws Exception {
        pontoCriado = new PontoReciclagem(1, "Validação");
        pontoCriado = (PontoReciclagem) controller.inserir(pontoCriado);

        boolean resultado = controller.validar(pontoCriado);
        assertTrue(resultado);
    }

    @Test
    public void testValidarWeb() throws Exception {
        pontoCriado = new PontoReciclagem(1, "Web");
        pontoCriado = (PontoReciclagem) controller.inserir(pontoCriado);

        PontoReciclagem resultado = controller.validarWeb(pontoCriado);
        assertNotNull(resultado);
        assertEquals("Web", resultado.getNome());
    }
}
