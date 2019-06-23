/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Diarley Gomes
 */
public class ModeloDisciplina {
    private String NOME_DISCIPLINA;
    private String DESCRICAO;
    private String CODIGO;
    private String SEMESTRE;
    private int CARGA_HORARIA;
    private int ID_DISCIPLINA;

    /**
     * @return the NOME_DISCIPLINA
     */
    public String getNOME_DISCIPLINA() {
        return NOME_DISCIPLINA;
    }

    /**
     * @param NOME_DISCIPLINA the NOME_DISCIPLINA to set
     */
    public void setNOME_DISCIPLINA(String NOME_DISCIPLINA) {
        this.NOME_DISCIPLINA = NOME_DISCIPLINA;
    }

    /**
     * @return the DESCRICAO
     */
    public String getDESCRICAO() {
        return DESCRICAO;
    }

    /**
     * @param DESCRICAO the DESCRICAO to set
     */
    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    /**
     * @return the CODIGO
     */
    public String getCODIGO() {
        return CODIGO;
    }

    /**
     * @param CODIGO the CODIGO to set
     */
    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    /**
     * @return the SEMESTRE
     */
    public String getSEMESTRE() {
        return SEMESTRE;
    }

    /**
     * @param SEMESTRE the SEMESTRE to set
     */
    public void setSEMESTRE(String SEMESTRE) {
        this.SEMESTRE = SEMESTRE;
    }

    /**
     * @return the CARGA_HORARIA
     */
    public int getCARGA_HORARIA() {
        return CARGA_HORARIA;
    }

    /**
     * @param CARGA_HORARIA the CARGA_HORARIA to set
     */
    public void setCARGA_HORARIA(int CARGA_HORARIA) {
        this.CARGA_HORARIA = CARGA_HORARIA;
    }

    /**
     * @return the ID_DISCIPLINA
     */
    public int getID_DISCIPLINA() {
        return ID_DISCIPLINA;
    }

    /**
     * @param ID_DISCIPLINA the ID_DISCIPLINA to set
     */
    public void setID_DISCIPLINA(int ID_DISCIPLINA) {
        this.ID_DISCIPLINA = ID_DISCIPLINA;
    }
}
