/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloAlunos;

/**
 *
 * @author Diarley Gomes
 */
public class ControleAlunos {
    conectaBD conex = new conectaBD();
    ModeloAlunos mod = new ModeloAlunos();
    
    public void Salvar (ModeloAlunos mod){
        conex.conexao();
        try{
            PreparedStatement pst =conex.con.prepareStatement("insert into Alunos(MATRICULA,NOME,IDENTIDADE,ORGAO_EMISSOR,CPF,DATA_DE_NASCIMENTO,PAIS_NASCIMENTO,CIDADE_NASCIMENTO,UF_NASCIMENTO,PAI,MAE,ENDEREÇO,CIDADE_ENDERECO,UF,CEP,EMAIL,TELEFONE,CELULAR) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getMATRICULA());
            pst.setString(2, mod.getNOME());
            pst.setString(3, mod.getIDENTIDADE());
            pst.setString(4, mod.getORGAO_EMISSOR());
            pst.setString(5, mod.getCPF());
            pst.setString(6, mod.getDATA_DE_NASCIMENTO());
            pst.setString(7, mod.getPAIS_NASCIMENTO());
            pst.setString(8, mod.getCIDADE_NASCIMENTO());
            pst.setString(9, mod.getUF_NASCIMENTO());
            pst.setString(10, mod.getPAI());
            pst.setString(11, mod.getMAE());
            pst.setString(12, mod.getENDEREÇO());
            pst.setString(13, mod.getCIDADE_ENDERECO());
            pst.setString(14, mod.getUF());
            pst.setString(15, mod.getCEP());
            pst.setString(16, mod.getEMAIL());
            pst.setString(17, mod.getTELEFONE());
            pst.setString(18, mod.getCELULAR());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\n"+ex);
        }
        conex.desconecta();
    }
}
