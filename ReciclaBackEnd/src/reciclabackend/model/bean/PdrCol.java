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
public class PdrCol implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private int id;
    private int idPRD;
    private int idCOL;

    public PdrCol(int id) {
        this.id = id;
    }

    public PdrCol(int idPRD, int idCOL) {
        this.idPRD = idPRD;
        this.idCOL = idCOL;
    }

    public PdrCol(int id, int idPRD, int idCOL) {
        this.id = id;
        this.idPRD = idPRD;
        this.idCOL = idCOL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPRD() {
        return idPRD;
    }

    public void setIdPRD(int idPRD) {
        this.idPRD = idPRD;
    }

    public int getIdCOL() {
        return idCOL;
    }

    public void setIdCOL(int idCOL) {
        this.idCOL = idCOL;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", idPRD=" + idPRD + ", idCOL=" + idCOL + '}';
    }
}
