package recicla.model.bean;

import java.io.Serializable;

public class PEF_PDC implements Serializable {

    private int id;
    private int idPef;
    private int idCol;
    private int idMat;
    private int idPdc;
    private int cod;
    private int quant;
    private String data;

    public PEF_PDC() {}

    // construtor sem id (para INSERT)
    public PEF_PDC(int idPef, int idCol, int idMat, int idPdc,
                   int cod, int quant, String data) {
        this(0, idPef, idCol, idMat, idPdc, cod, quant, data);
    }

    // construtor completo
    public PEF_PDC(int id, int idPef, int idCol, int idMat, int idPdc,
                   int cod, int quant, String data) {
        this.id     = id;
        this.idPef  = idPef;
        this.idCol  = idCol;
        this.idMat  = idMat;
        this.idPdc  = idPdc;
        this.cod    = cod;
        this.quant  = quant;
        this.data   = data;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPef() { return idPef; }
    public void setIdPef(int idPef) { this.idPef = idPef; }

    public int getIdCol() { return idCol; }
    public void setIdCol(int idCol) { this.idCol = idCol; }

    public int getIdMat() { return idMat; }
    public void setIdMat(int idMat) { this.idMat = idMat; }

    public int getIdPdc() { return idPdc; }
    public void setIdPdc(int idPdc) { this.idPdc = idPdc; }

    public int getCod() { return cod; }
    public void setCod(int cod) { this.cod = cod; }

    public int getQuant() { return quant; }
    public void setQuant(int quant) { this.quant = quant; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    @Override
    public String toString() {
        return String.format(
            "PEF_PDC{id=%d, idPef=%d, idCol=%d, idMat=%d, idPdc=%d, cod=%d, quant=%d, data=%s}",
            id, idPef, idCol, idMat, idPdc, cod, quant, data
        );
    }
}