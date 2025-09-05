/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.model.bean;

import java.io.Serializable;

/**
 *
 * @author olgac
 */
public class Pessoa implements Serializable {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa(int id, String nome, int idLog, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.idLog = idLog;
        this.email = email;
        this.telefone = telefone;
    }

    public Pessoa(String nome, int idLog, String email, String telefone) {
        this.nome = nome;
        this.idLog = idLog;
        this.email = email;
        this.telefone = telefone;
    }
    
    private int id;
    private String nome;
    private int idLog;
    private String email;
    private String telefone;
    private Logradouro log;
    
    //alterar
    public Pessoa(int id, String nome, int idLog) {
        this.id = id;
        this.nome = nome;
        this.idLog = idLog;
    }
    //inserir
    public Pessoa( String nome, int idLog) {
        this.nome = nome;
        this.idLog = idLog;
    }
    
    //listar
    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    //buscar, excluir
    public Pessoa(int id) {
        this.id = id;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public Logradouro getLog() {
        return log;
    }

    public void setLog(Logradouro log) {
        this.log = log;
    }
   
}