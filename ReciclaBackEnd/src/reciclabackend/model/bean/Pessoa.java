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
    
    private int id;
    private String nome;
    private int idLog;
    private Logradouro log;
    
    //inserir
    public Pessoa(int id, String nome, int idLog) {
        this.id = id;
        this.nome = nome;
        this.idLog = idLog;
    }
    

    
    //listar
    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    //buscar alterar
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