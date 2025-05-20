/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recicla.model.bean;

/**
 *
 * @author raife
 */
public class Municipio {

    private int id;
    private int codigo;
    private String nome;

    // Construtor com ID
    public Municipio(int id) {
        this.id = id;
    }

    // Construtor com código
    public Municipio(int codigo, boolean isCodigo) {
        this.codigo = codigo;
    }

    // Construtor com código e nome
    public Municipio(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // toString
    @Override
    public String toString() {
        return "Municipio{id = " + id + ", codigo = " + codigo + ", nome = " + nome + "}";
    }
}
