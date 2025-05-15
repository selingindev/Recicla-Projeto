/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.model.bean;


public class PontoColeta {

    public PontoColeta(String nome) {
        this.nome = nome;
    }
    private int id;
    private int idLog;
    private String nome;

    public PontoColeta(int id) {
        this.id = id;
    }
    
    
    public PontoColeta(int id, int idLog, String nome) {
        this.id = id;
        this.idLog = idLog;
        this.nome = nome;
    }
    
    public int getId (){
        return id; 
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public int getIdLog () {
        return idLog;
    }
    
    public void setIdLog (int idLog) {
        this.idLog = idLog;
    }
    
    public String getNome () {
        return nome;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
}
