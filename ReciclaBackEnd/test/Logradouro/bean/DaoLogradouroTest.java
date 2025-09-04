package Logradouro.bean;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import reciclabackend.model.bean.Logradouro;
import reciclabackend.model.dao.DaoLogradouro;

public class DaoLogradouroTest {

    private DaoLogradouro dao;

    @Before
    public void setUp() throws Exception {
        dao = new DaoLogradouro();
    }

    @After
    public void tearDown() throws Exception {
        // Limpa registros de teste
        List<Object> lista = dao.listar("JUnit");
        for (Object obj : lista) {
            Logradouro log = (Logradouro) obj;
            dao.excluir(log.getId());
        }
    }

    @Test
    public void testInserir() throws Exception {
        Logradouro log = new Logradouro();
        log.setCep("11111-111");
        log.setNumero("123");
        log.setComplementoApi("fundos");
        log.setComplementoOutros("JUnit");

        Logradouro inserido = (Logradouro) dao.inserir(log);
        assertNotNull(inserido.getId());
        assertEquals("11111-111", inserido.getCep());
    }

    @Test
    public void testAlterar() throws Exception {
        Logradouro log = new Logradouro();
        log.setCep("22222-222");
        log.setNumero("456");
        log.setComplementoApi("lado");
        log.setComplementoOutros("JUnit");
        Logradouro inserido = (Logradouro) dao.inserir(log);

        inserido.setNumero("789");
        inserido.setCep("99999-999");
        Logradouro alterado = (Logradouro) dao.alterar(inserido);

        assertEquals("99999-999", alterado.getCep());
        assertEquals("789", alterado.getNumero());
    }

    @Test
    public void testBuscar() throws Exception {
        Logradouro log = new Logradouro();
        log.setCep("33333-333");
        log.setNumero("321");
        log.setComplementoApi("topo");
        log.setComplementoOutros("JUnit");
        Logradouro inserido = (Logradouro) dao.inserir(log);

        Logradouro encontrado = (Logradouro) dao.buscar(inserido.getId());
        assertEquals("33333-333", encontrado.getCep());
        assertEquals("321", encontrado.getNumero());
    }

    @Test
    public void testExcluir() throws Exception {
        Logradouro log = new Logradouro();
        log.setCep("44444-444");
        log.setNumero("400");
        log.setComplementoApi("porta");
        log.setComplementoOutros("JUnit");
        Logradouro inserido = (Logradouro) dao.inserir(log);

        boolean excluido = dao.excluir(inserido.getId());
        assertTrue(excluido);
    }

    @Test
    public void testListar() throws Exception {
        Logradouro log = new Logradouro();
        log.setCep("55555-555");
        log.setNumero("500");
        log.setComplementoApi("escada");
        log.setComplementoOutros("JUnit");
        dao.inserir(log);

        List<Object> lista = dao.listar("JUnit");
        assertFalse(lista.isEmpty());

        for (Object obj : lista) {
            assertTrue(obj instanceof Logradouro);
            Logradouro l = (Logradouro) obj;
            assertEquals("JUnit", l.getComplementoOutros());
        }
    }
}
