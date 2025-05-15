package recicla.model.bean;

import java.io.Serializable;

public class Material implements Serializable {
    private int id;
    private String nome;
    private String descricao;

    public Material(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Material(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Material(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Material(String nome) {
        this.nome = nome;
    }

    public Material(int id) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Material {" + "id= " + id + ", nome= " + nome + ", descrição= " + descricao + " }";
    }
}
