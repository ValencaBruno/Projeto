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
import modelo.ModeloPPC;

/**
 *
 * @author Diarley Gomes
 */
public class ControlePPC {
    conectaBD conex = new conectaBD();
    ModeloPPC mod = new ModeloPPC();
    
    
    public ModeloPPC buscaPPC(ModeloPPC mod, String curso){
        conex.conexao();
        conex.executaSql("SELECT PPC.PERFIL_CURSO, PPC.REPRESENTACAO_GRAFICA, PPC.FORMA_DE_ACESSO_CURSO, PPC.SISTEMA_DE_AVALIACAO, PPC.SISTEMA_DE_AVALIACAO_DO_PROCESSO_ENSINO_APRENDIZAGEM, PPC.TRABALHO_DE_CONCLUSAO_DE_CURSO, PPC.ESTAGIO_CURRICULAR, PPC.POLITICA_DE_ATENDIMENTO_A_PESSOA_COM_DEFICIENCIA FROM Cursos INNER JOIN PPC ON Cursos.ID_CURSOS = PPC.ID_CURSO WHERE (Cursos.CURSO = '"+curso+"');");
        try {
            conex.rs.first();
            mod.setPERFIL_CURSO(conex.rs.getString("PERFIL_CURSO"));
            mod.setREPRESENTACAO_GRAFICA(conex.rs.getString("REPRESENTACAO_GRAFICA"));
            mod.setFORMA_DE_ACESSO_CURSO(conex.rs.getString("FORMA_DE_ACESSO_CURSO"));
            mod.setSISTEMA_DE_AVALIACAO(conex.rs.getString("SISTEMA_DE_AVALIACAO"));
            mod.setSISTEMA_DE_AVALIACAO_DO_PROCESSO_ENSINO_APRENDIZAGEM(conex.rs.getString("SISTEMA_DE_AVALIACAO_DO_PROCESSO_ENSINO_APRENDIZAGEM"));
            mod.setTRABALHO_DE_CONCLUSAO_DE_CURSO(conex.rs.getString("TRABALHO_DE_CONCLUSAO_DE_CURSO"));
            mod.setESTAGIO_CURRICULAR(conex.rs.getString("ESTAGIO_CURRICULAR"));
            mod.setPOLITICA_DE_ATENDIMENTO_A_PESSOA_COM_DEFICIENCIA(conex.rs.getString("POLITICA_DE_ATENDIMENTO_A_PESSOA_COM_DEFICIENCIA"));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao buscar: "+ex);
            mod.setPERFIL_CURSO("");
            mod.setREPRESENTACAO_GRAFICA("");
            mod.setFORMA_DE_ACESSO_CURSO("");
            mod.setSISTEMA_DE_AVALIACAO("");
            mod.setSISTEMA_DE_AVALIACAO_DO_PROCESSO_ENSINO_APRENDIZAGEM("");
            mod.setTRABALHO_DE_CONCLUSAO_DE_CURSO("");
            mod.setESTAGIO_CURRICULAR("");
            mod.setPOLITICA_DE_ATENDIMENTO_A_PESSOA_COM_DEFICIENCIA("");
            
    }
    conex.desconecta();
    return mod;
    }
    
    public void Salvar (ModeloPPC mod, String curso){ 
        conex.conexao();
        conex.executaSql("SELECT * FROM Cursos WHERE (Cursos.CURSO = '"+curso+"');");
        try{
            conex.rs.first();
            mod.setID_CURSO(conex.rs.getInt("ID_CURSOS"));
            
            conex.executaSql("SELECT * FROM PPC WHERE (PPC.ID_CURSO = "+mod.getID_CURSO()+");");
            if(conex.rs.next()){
                try{
                    PreparedStatement pst = conex.con.prepareStatement("UPDATE PPC SET ID_CURSO=?, PERFIL_CURSO=?, REPRESENTACAO_GRAFICA=?, FORMA_DE_ACESSO_CURSO=?, SISTEMA_DE_AVALIACAO=?, SISTEMA_DE_AVALIACAO_DO_PROCESSO_ENSINO_APRENDIZAGEM=?, TRABALHO_DE_CONCLUSAO_DE_CURSO=?, ESTAGIO_CURRICULAR=?, POLITICA_DE_ATENDIMENTO_A_PESSOA_COM_DEFICIENCIA=? WHERE PPC.ID_CURSO="+mod.getID_CURSO()+";");
                    pst.setInt(1, mod.getID_CURSO());
                    pst.setString(2, mod.getPERFIL_CURSO());
                    pst.setString(3, mod.getREPRESENTACAO_GRAFICA());
                    pst.setString(4, mod.getFORMA_DE_ACESSO_CURSO());
                    pst.setString(5, mod.getSISTEMA_DE_AVALIACAO());
                    pst.setString(6, mod.getSISTEMA_DE_AVALIACAO_DO_PROCESSO_ENSINO_APRENDIZAGEM());
                    pst.setString(7, mod.getTRABALHO_DE_CONCLUSAO_DE_CURSO());
                    pst.setString(8, mod.getESTAGIO_CURRICULAR());
                    pst.setString(9, mod.getPOLITICA_DE_ATENDIMENTO_A_PESSOA_COM_DEFICIENCIA());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados!\n"+ex);
                }
            }else{
                try{
                    PreparedStatement pst = conex.con.prepareStatement("INSERT INTO PPC(ID_CURSO,PERFIL_CURSO,REPRESENTACAO_GRAFICA,FORMA_DE_ACESSO_CURSO,SISTEMA_DE_AVALIACAO,SISTEMA_DE_AVALIACAO_DO_PROCESSO_ENSINO_APRENDIZAGEM,TRABALHO_DE_CONCLUSAO_DE_CURSO,ESTAGIO_CURRICULAR,POLITICA_DE_ATENDIMENTO_A_PESSOA_COM_DEFICIENCIA) VALUES(?,?,?,?,?,?,?,?,?)");
                    pst.setInt(1, mod.getID_CURSO());
                    pst.setString(2, mod.getPERFIL_CURSO());
                    pst.setString(3, mod.getREPRESENTACAO_GRAFICA());
                    pst.setString(4, mod.getFORMA_DE_ACESSO_CURSO());
                    pst.setString(5, mod.getSISTEMA_DE_AVALIACAO());
                    pst.setString(6, mod.getSISTEMA_DE_AVALIACAO_DO_PROCESSO_ENSINO_APRENDIZAGEM());
                    pst.setString(7, mod.getTRABALHO_DE_CONCLUSAO_DE_CURSO());
                    pst.setString(8, mod.getESTAGIO_CURRICULAR());
                    pst.setString(9, mod.getPOLITICA_DE_ATENDIMENTO_A_PESSOA_COM_DEFICIENCIA());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\n"+ex);
                }
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar dados!\n"+ex);
        }
        conex.desconecta();
    }
    
    
    
    
}
