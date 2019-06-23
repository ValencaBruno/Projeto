/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public ModeloAlunos buscaAlunos(ModeloAlunos mod, int ID){
        conex.conexao();
        conex.executaSql("SELECT * FROM Alunos WHERE ID_ALUNOS = "+ID+";");
        
        try {
            conex.rs.first();
            mod.setMATRICULA(conex.rs.getString("MATRICULA"));
            mod.setNOME(conex.rs.getString("NOME"));
            mod.setIDENTIDADE(conex.rs.getString("IDENTIDADE"));
            mod.setORGAO_EMISSOR(conex.rs.getString("ORGAO_EMISSOR"));
            mod.setCPF(conex.rs.getString("CPF"));
            mod.setDATA_DE_NASCIMENTO(conex.rs.getString("DATA_DE_NASCIMENTO"));
            mod.setPAIS_NASCIMENTO(conex.rs.getString("PAIS_NASCIMENTO"));
            mod.setCIDADE_NASCIMENTO(conex.rs.getString("CIDADE_NASCIMENTO"));
            mod.setUF_NASCIMENTO(conex.rs.getString("UF_NASCIMENTO"));
            mod.setPAI(conex.rs.getString("PAI"));
            mod.setMAE(conex.rs.getString("MAE"));
            mod.setENDEREÇO(conex.rs.getString("ENDEREÇO"));
            mod.setCIDADE_ENDERECO(conex.rs.getString("CIDADE_ENDERECO"));
            mod.setUF(conex.rs.getString("UF"));
            mod.setCEP(conex.rs.getString("CEP"));
            mod.setEMAIL(conex.rs.getString("EMAIL"));
            mod.setTELEFONE(conex.rs.getString("TELEFONE"));
            mod.setCELULAR(conex.rs.getString("CELULAR"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: "+ex);
        }
        conex.desconecta();
        return mod;
    }
    
    public void Editar(ModeloAlunos mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update Alunos set MATRICULA=?, NOME=?, IDENTIDADE=?, ORGAO_EMISSOR=?, CPF=?, DATA_DE_NASCIMENTO=?, PAIS_NASCIMENTO=?, CIDADE_NASCIMENTO=?, UF_NASCIMENTO=?, PAI=?, MAE=?, ENDEREÇO=?, CIDADE_ENDERECO=?, UF=?, CEP=?, EMAIL=?, TELEFONE=?, CELULAR=? where ID_ALUNOS=?;");
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
            pst.setInt(19, mod.getID_ALUNO());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados");
        }
        
        conex.desconecta();
        
    }
}
