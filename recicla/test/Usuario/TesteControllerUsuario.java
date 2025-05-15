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
import recicla.controller.ControllerUsuario;
import recicla.model.bean.Usuario;

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
        Object usuEnt = new Usuario(1);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.buscar(usuEnt);
        String login = usuSaida.getLogin();
        Assert.assertEquals(login,"BIT");
    }
}
