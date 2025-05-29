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
public class UsuarioSistema implements Serializable{
    
    private int id;
    private int idU;
    private int idS;
    private Object usu;
    private Object sis;
    private String obs;

    public UsuarioSistema(int id) {
        this.id = id;
    }

    public UsuarioSistema(String obs) {
        this.obs = obs;
    }

    public UsuarioSistema(int idU, int idS, String obs) {
        this.idU = idU;
        this.idS = idS;
        this.obs = obs;
    }

    public UsuarioSistema(int id, int idU, int idS, String obs) {
        this.id = id;
        this.idU = idU;
        this.idS = idS;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Object getUsu() {
        return usu;
    }

    public void setUsu(Object usu) {
        this.usu = usu;
    }

    public Object getSis() {
        return sis;
    }

    public void setSis(Object sis) {
        this.sis = sis;
    }

    @Override
    public String toString() {
        return "UsuarioSistema{" + "id=" + id + ", idU=" + idU + ", idS=" + idS + ", obs=" + obs + '}';
    }
    
    
    
}
