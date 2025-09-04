package Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.sql.SQLException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reciclabackend.controller.ControllerUsuario;
import reciclabackend.model.bean.Usuario;

/**
 *
 * @author LAB 211
 */
public final class TesteControllerUsuario {
    
    public TesteControllerUsuario() throws SQLException, ClassNotFoundException {
        ControllerUsuario();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void ControllerUsuario() throws SQLException, ClassNotFoundException {
        buscar();
        inserir();
    }

    public void buscar () throws SQLException, ClassNotFoundException {
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.buscar(1);
        String login = usuSaida.getLogin();
        Assert.assertEquals(login,"BIT");
    }
 
    public void excluir () throws SQLException, ClassNotFoundException {
    }

    public void inserir () throws SQLException, ClassNotFoundException {
    }

    public void alterar () throws SQLException, ClassNotFoundException{
    }

    public void listar () throws SQLException, ClassNotFoundException {
    }

    
}
