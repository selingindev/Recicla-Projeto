package reciclabackend.model.bean;

import java.io.Serializable;

public class ColPdc implements Serializable {
    
    private static final long serialVersionUID = 1L;


    private int id;
    private int idCol;
    private int idPdc;
    private String data;
    private Colaborador col;
    private PontoColeta pdc;

    // buscar e excluir
    public ColPdc(int id) {
        this.id = id;
    }

    // listar
    public ColPdc(String data) {
        this.data = data;
    }

    // inserir
    public ColPdc(int idCol, int idPdc, String data) {
        this.idCol = idCol;
        this.idPdc = idPdc;
        this.data = data;
    }

    // alterar
    public ColPdc(int id, int idCol, int idPdc, String data) {
        this.id = id;
        this.idCol = idCol;
        this.idPdc = idPdc;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCol() {
        return idCol;
    }

    public void setIdCol(int idCol) {
        this.idCol = idCol;
    }

    public int getIdPdc() {
        return idPdc;
    }

    public void setIdPdc(int idPdc) {
        this.idPdc = idPdc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Colaborador getCol() {
        return col;
    }

    public void setCol(Colaborador col) {
        this.col = col;
    }

    public PontoColeta getPdc() {
        return pdc;
    }

    public void setPdc(PontoColeta pdc) {
        this.pdc = pdc;
    }

    @Override
    public String toString() {
        return "ColPdc{" + "id=" + id + ", idCol=" + idCol + ", idPdc=" + idPdc + ", data=" + data + '}';
    }


}
