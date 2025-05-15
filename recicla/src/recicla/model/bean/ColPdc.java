package recicla.model.bean;

import java.time.LocalDate;


public class ColPdc {
    
    private int id;
    private int idCol;
    private int idPdc;
    private LocalDate data;
    
    public ColPdc() {
    }
    
    public ColPdc(int id, int idCol, int idPdc, LocalDate data) {
        this.id = id;
        this.idCol = idCol;
        this.idPdc = idPdc;
        this.data = data;
    }

    public ColPdc(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    public LocalDate getData() {
        return data;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "ColPdc [id=" + id + ", idCol=" + idCol + ", idPdc=" + idPdc + ", data=" + data + "]";
    }
}
