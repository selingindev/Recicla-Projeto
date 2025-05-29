/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.model.bean;

import java.io.Serializable;

/**
 *
 * @author LAB 211
 */
public class PontoReciclagem implements Serializable{

    public PontoReciclagem() {
    }
    
    private int id;
    private int idPEJ;
    private String nome;
    
public PontoReciclagem(int id, int idPEJ) {
        this.id = id;
        this.idPEJ = idPEJ;
}

public PontoReciclagem(String nome) {
        this.nome = nome;
}

public PontoReciclagem(int id) {
        this.idPEJ = id;
}

public PontoReciclagem(int idPEJ, String nome) {
    this.idPEJ = idPEJ;
    this.nome = nome;
    }

    public PontoReciclagem(int id, int idPEJ, String nome) {
        this.id = id;
        this.idPEJ = idPEJ;
        this.nome = nome;
    }
    

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getIdPEJ() {
    return idPEJ;
}

public void setIdPEJ(int idPEJ) {
    this.idPEJ = idPEJ;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

@Override
public String toString() {
    return "Ponto de Reciclagem{" + "id=" + id + ", nome=" + nome + ", idPSJ=" + idPEJ + '}';
   
}
    
}

