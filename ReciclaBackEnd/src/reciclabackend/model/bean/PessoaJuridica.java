/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciclabackend.model.bean;

/**
 *
 * @author olgac
 */
public class PessoaJuridica {

    public PessoaJuridica(int idPes, String cnpj, String inscEst) {
        this.idPes = idPes;
        this.cnpj = cnpj;
        this.inscEst = inscEst;
    }

    public PessoaJuridica(int id, int idPes, String cnpj, String inscEst) {
        this.id = id;
        this.idPes = idPes;
        this.cnpj = cnpj;
        this.inscEst = inscEst;
    }

    public PessoaJuridica(int id) {
        this.id = id;
    }

    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;    
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "id=" + id + ", idPes=" + idPes + ", cnpj=" + cnpj + ", inscEst=" + inscEst + '}';
    }
    
    private int id;
    private int idPes;
    private String cnpj;
    private String inscEst;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPes() {
        return idPes;
    }

    public void setIdPes(int idPes) {
        this.idPes = idPes;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscEst() {
        return inscEst;
    }

    public void setInscEst(String inscEst) {
        this.inscEst = inscEst;
    }
    
    
    
}
