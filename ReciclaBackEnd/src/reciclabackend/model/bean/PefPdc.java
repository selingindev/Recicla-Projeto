package reciclabackend.model.bean;

import java.io.Serializable;

public class PefPdc implements Serializable {

    private static final long serialVersionUID = 1L;


    private int id;
    private int idPef;
    private int idCol;
    private int idMat;
    private int idPdc;
    private int cod;
    private int quant;
    private String data;
    private PessoaFisica pef;
    private Colaborador col;
    private Material mat;
    private PontoColeta pdc;
    


}