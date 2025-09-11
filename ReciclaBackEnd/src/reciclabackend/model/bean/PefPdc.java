package reciclabackend.model.bean;

import java.sql.Date;

public class PefPdc {
    private int id;
    private int idPef;
    private int idCol;
    private int idMat;
    private int idPdc;
    private String cod;
    private double quant;
    private Date data;

    public PefPdc() {}

    public PefPdc(int id) {
        this.id = id;
    }

    public PefPdc(int id, int idPef, int idCol, int idMat, int idPdc, String cod, double quant, Date data) {
        this.id = id;
        this.idPef = idPef;
        this.idCol = idCol;
        this.idMat = idMat;
        this.idPdc = idPdc;
        this.cod = cod;
        this.quant = quant;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPef() {
        return idPef;
    }

    public void setIdPef(int idPef) {
        this.idPef = idPef;
    }

    public int getIdCol() {
        return idCol;
    }

    public void setIdCol(int idCol) {
        this.idCol = idCol;
    }

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public int getIdPdc() {
        return idPdc;
    }

    public void setIdPdc(int idPdc) {
        this.idPdc = idPdc;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PefPdc{id=" + id + 
               ", idPef=" + idPef + 
               ", idCol=" + idCol + 
               ", idMat=" + idMat + 
               ", idPdc=" + idPdc + 
               ", cod='" + cod + '\'' + 
               ", quant=" + quant + 
               ", data=" + data + 
               '}';
    }
}