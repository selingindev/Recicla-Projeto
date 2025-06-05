package reciclabackend.model.bean;

public class PontoColeta {
    private int id;
    private int idLog;
    private String nome;
    private String qrCode;

    public PontoColeta(int id) {
        this.id = id;
    }

    public PontoColeta(int id, int idLog, String nome, String qrCode) {
        this.id = id;
        this.idLog = idLog;
        this.nome = nome;
        this.qrCode = qrCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public String toString() {
        return "PontoColeta{id=" + id +
               ", idLog=" + idLog +
               ", nome='" + nome + '\'' +
               ", qrCode='" + qrCode + '\'' +
               '}';
    }
}
