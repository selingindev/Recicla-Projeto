/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.model.bean;

/**
 *
 * @author raife
 */
public class Parametro {
    private int id;
    private int cod;
    private String descricao;

    public Parametro(int cod) {
        this.cod = cod;
    }

    public Parametro(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCod() {
        return id;
    }

    public void setCod(int cod) {
        this.id = cod;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Parametro{id = " + this.id + ", codigo = " + this.cod + " descricao " + this.descricao;
    }
}
