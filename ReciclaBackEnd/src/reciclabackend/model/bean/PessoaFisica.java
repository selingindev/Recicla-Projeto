package reciclabackend.model.bean;




public class PessoaFisica {

    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PessoaFisica(int id, int idPes, String cpf, String rg) {
        this.id = id;
        this.idPes = idPes;
        this.cpf = cpf;
        this.rg = rg;
    }
    private int id;
    private int idPes;
    private String cpf;
    private String rg;

    public PessoaFisica() {
    }

    public PessoaFisica(int idPes, String cpf, String rg) {
        this.idPes = idPes;
        this.cpf = cpf;
        this.rg = rg;
    }

    public int getIdPes() {
        return idPes;
    }

    public void setIdPes(int idPes) {
        this.idPes = idPes;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "idPes=" + idPes + ", cpf=" + cpf + ", rg=" + rg + '}';
    }
}
