/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.model.bean;

import java.io.Serializable;

/**
 *
 * @author olgac
 */
public class Pessoa implements Serializable {
    private int id;
    private String nome;
    private int id_LOG;
    
    public Pessoa(int id, String nome, int id_LOG) {
        this.id = id;
        this.nome = nome;
        this.id_LOG = id_LOG;
    }
    public Pessoa(String nome, int id_LOG) {
        this.nome = nome;
        this.id_LOG = id_LOG;
    }
    public Pessoa(String nome) {
        this.nome = nome;
    }
    public Pessoa(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_LOG() {
        return id_LOG;
    }
    public void setId_LOG(int id_LOG) {
        this.id_LOG = id_LOG;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", id_LOG=" + id_LOG + "]";
    }
    
    
}