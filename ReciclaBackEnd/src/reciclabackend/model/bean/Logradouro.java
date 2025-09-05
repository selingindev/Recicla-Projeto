 package reciclabackend.model.bean;

import java.io.Serializable;

public class Logradouro implements Serializable{

   private int id;
   private String cep;
   private String numero;
   private String complemento_api;
   private String complemento_outros;

    public Logradouro(int id, String cep, String numero, String complemento_api) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
        this.complemento_api = complemento_api;
    }
    public Logradouro(String cep, String numero, String complemento_outros) {
        this.cep = cep;
        this.numero = numero;
        this.complemento_outros = complemento_outros;
    }
    public Logradouro(String cep, String numero, String complemento_api, String complemento_outros) {
        this.cep = cep;
        this.numero = numero;
        this.complemento_api = complemento_api;
        this.complemento_outros = complemento_outros;
    }
    public Logradouro(int id, String cep, String numero, String complemento_api, String complemento_outros) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
        this.complemento_api = complemento_api;
        this.complemento_outros = complemento_outros;
    }
    
    public Logradouro(String cep) {
        this.cep = cep;
    }

    public Logradouro(int id) {
     
    }
        public Logradouro() {
     
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplementoApi() {
        return complemento_api;
    }
    public void setComplementoApi(String complemento_api) {
        this.complemento_api = complemento_api;
    }
    
    public String getComplementoOutros() {
        return complemento_api;
    }
    public void setComplementoOutros(String complemento_outros) {
        this.complemento_outros = complemento_outros;
    }
    
    @Override
    public String toString() {
        return "Logradouro{" + "id=" + id + ", cep=" + cep + ", numero=" + numero + ", complementos da api=" + complemento_api + ", outros complementos=" + complemento_outros + '}';
    }
    
    
}