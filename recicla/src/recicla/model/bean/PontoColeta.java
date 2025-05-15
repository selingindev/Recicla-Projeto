package recicla.model.bean;


public class PontoColeta {
    private int id;
    private String idLog;
    private String nome;
    private String qrCode;
    
    
    public PontoColeta(int id, String idLog, String nome, String qrCode) {
        this.id = id;
        this.idLog = idLog;
        this.nome = nome;
        this.qrCode = qrCode;
    }
    
    public int getId (){
        return id; 
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public String getIdLog () {
        return idLog;
    }
    
    public void setIdLog (String idLog) {
        this.idLog = idLog;
    }
    
    public String getNome () {
        return nome;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public String getQrCode () {
        return qrCode;
    }
    
    public void setQrCode (String qrCode) {
        this.qrCode = qrCode;
    }
}