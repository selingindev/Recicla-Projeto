package reciclabackend.model.bean;

public class ValorCredito {
    private int id;
    private double valor;
    private int idMat;
    private int idPar;
    private int idMuni;

    // Construtor que recebe apenas o ID
    public ValorCredito(int id) {
        this.id = id;
    }

    // Construtor que recebe todos os atributos
    public ValorCredito(int id, double valor, int idMat, int idPar, int idMuni) {
        this.id = id;
        this.valor = valor;
        this.idMat = idMat;
        this.idPar = idPar;
        this.idMuni = idMuni;
    }
    
    // Construtor que recebe todos os atributos
    public ValorCredito(double valor, int idMat, int idPar, int idMuni) {
        this.valor = valor;
        this.idMat = idMat;
        this.idPar = idPar;
        this.idMuni = idMuni;
    }


    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public int getIdPar() {
        return idPar;
    }

    public void setIdPar(int idPar) {
        this.idPar = idPar;
    }

    public int getIdMuni() {
        return idMuni;
    }

    public void setIdMuni(int idMuni) {
        this.idMuni = idMuni;
    }

    // Método toString
    @Override
    public String toString() {
        return "ValorCredito{" +
                "id=" + id +
                ", valor=" + valor +
                ", idMat=" + idMat +
                ", idPar=" + idPar +
                ", idMuni=" + idMuni +
                '}';
    }
}
