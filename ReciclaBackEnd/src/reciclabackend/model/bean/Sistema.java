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
public class Sistema implements Serializable{
    
    private int id;
    private String nome;
    private String servidor;
    private String status;
    private String ip;

    public Sistema(int id) {
        this.id = id;
    }

    public Sistema(String nome) {
        this.nome = nome;
    }

    public Sistema(String nome, String servidor, String status, String ip) {
        this.nome = nome;
        this.servidor = servidor;
        this.status = status;
        this.ip = ip;
    }

    public Sistema(int id, String nome, String servidor, String status, String ip) {
        this.id = id;
        this.nome = nome;
        this.servidor = servidor;
        this.status = status;
        this.ip = ip;
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

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Sistema{" + "id=" + id + ", nome=" + nome + ", servidor=" + servidor + ", status=" + status + ", ip=" + ip + '}';
    }
    
    
    
    
}
