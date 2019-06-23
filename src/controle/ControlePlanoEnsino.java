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
import modelo.ModeloPlanoEnsino;
import visão.PlanoEnsino;

/**
 *
 * @author Diarley Gomes
 */
public class ControlePlanoEnsino {
    conectaBD conex = new conectaBD();
    ModeloPlanoEnsino mod = new ModeloPlanoEnsino();
    
    public void Salvar (ModeloPlanoEnsino mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into Plano_Ensino(ID_DISCIPLINA,CARGA_HORARIA,ID_PROFESSOR,PERIODO_DO_CURSO,EMENTA,COMPETENCIAS_E_HABILIDADES,METODOLOGIA_DE_ENSINO,CRONOGRAMA_DE_ATIVIDADES,AVALIACAO,BIBLIOGRAFIA) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, mod.getID_DISCIPLINA());
            pst.setInt(2, mod.getCARGA_HORARIA());
            pst.setInt(3, mod.getID_PROFESSOR());
            pst.setString(4, mod.getPERIODO_DO_CURSO());
            pst.setString(5, mod.getEMENTA());
            pst.setString(6, mod.getCOMPETENCIAS_E_HABILIDADES());
            pst.setString(7, mod.getMETODOLOGIA_DE_ENSINO());
            pst.setString(8, mod.getCRONOGRAMA_DE_ATIVIDADES());
            pst.setString(9, mod.getAVALIACAO());
            pst.setString(10, mod.getBIBLIOGRAFIA());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\n"+ex);
        }
        conex.desconecta();
    }
    
    public void Editar (ModeloPlanoEnsino mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update Plano_Ensino set ID_DISCIPLINA=?,CARGA_HORARIA=?,ID_PROFESSOR=?,PERIODO_DO_CURSO=?,EMENTA=?,COMPETENCIAS_E_HABILIDADES=?,METODOLOGIA_DE_ENSINO=?,CRONOGRAMA_DE_ATIVIDADES=?,AVALIACAO=?,BIBLIOGRAFIA=? where ID_PLANO_ENSINO=?;");
            pst.setInt(1, mod.getID_DISCIPLINA());
            pst.setInt(2, mod.getCARGA_HORARIA());
            pst.setInt(3, mod.getID_PROFESSOR());
            pst.setString(4, mod.getPERIODO_DO_CURSO());
            pst.setString(5, mod.getEMENTA());
            pst.setString(6, mod.getCOMPETENCIAS_E_HABILIDADES());
            pst.setString(7, mod.getMETODOLOGIA_DE_ENSINO());
            pst.setString(8, mod.getCRONOGRAMA_DE_ATIVIDADES());
            pst.setString(9, mod.getAVALIACAO());
            pst.setString(10, mod.getBIBLIOGRAFIA());
            pst.setInt(11, mod.getID_PLANO_ENSINO());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados");
        }
        
        conex.desconecta();
    }
    
    public ModeloPlanoEnsino buscaPlano(ModeloPlanoEnsino mod, String codigo){
        String aus = "";
        conex.conexao();
        conex.executaSql("SELECT Disciplina.ID_DISCIPLINA, Disciplina.NOME_DA_DISCIPLINA, Disciplina.CODIGO_DA_DISCIPLINA, Professor.ID_PROFESSOR, Professor.MATRICULA, Professor.PROFESSOR, Plano_Ensino.ID_PLANO_ENSINO, Plano_Ensino.CARGA_HORARIA, Plano_Ensino.PERIODO_DO_CURSO, Plano_Ensino.EMENTA, Plano_Ensino.COMPETENCIAS_E_HABILIDADES, Plano_Ensino.METODOLOGIA_DE_ENSINO, Plano_Ensino.CRONOGRAMA_DE_ATIVIDADES, Plano_Ensino.AVALIACAO, Plano_Ensino.BIBLIOGRAFIA FROM Professor INNER JOIN (Disciplina INNER JOIN Plano_Ensino ON Disciplina.ID_DISCIPLINA = Plano_Ensino.ID_DISCIPLINA) ON Professor.ID_PROFESSOR = Plano_Ensino.ID_PROFESSOR WHERE CODIGO_DA_DISCIPLINA LIKE '%" + codigo + "%';");
        
        try {
            conex.rs.first();
            mod.setID_PLANO_ENSINO(conex.rs.getInt("ID_PLANO_ENSINO"));
            mod.setID_DISCIPLINA(conex.rs.getInt("ID_DISCIPLINA"));
            mod.setCARGA_HORARIA(conex.rs.getInt("CARGA_HORARIA"));
            mod.setID_PROFESSOR(conex.rs.getInt("ID_PROFESSOR"));
            mod.setPERIODO_DO_CURSO(conex.rs.getString("PERIODO_DO_CURSO"));
            mod.setEMENTA(conex.rs.getString("EMENTA"));
            mod.setCOMPETENCIAS_E_HABILIDADES(conex.rs.getString("COMPETENCIAS_E_HABILIDADES"));
            mod.setMETODOLOGIA_DE_ENSINO(conex.rs.getString("METODOLOGIA_DE_ENSINO"));
            mod.setCRONOGRAMA_DE_ATIVIDADES(conex.rs.getString("CRONOGRAMA_DE_ATIVIDADES"));
            mod.setAVALIACAO(conex.rs.getString("AVALIACAO"));
            mod.setBIBLIOGRAFIA(conex.rs.getString("BIBLIOGRAFIA"));
            mod.setNOME_DISCIPLINA(conex.rs.getString("NOME_DA_DISCIPLINA"));
            mod.setCODIGO_DISCIPLINA(conex.rs.getString("CODIGO_DA_DISCIPLINA"));
            mod.setMATRICULA_PROFESSOR(conex.rs.getString("MATRICULA"));
            mod.setNOME_PROFESSOR(conex.rs.getString("PROFESSOR"));
        } catch (SQLException ex) {
            conex.executaSql("SELECT * FROM Disciplina WHERE CODIGO_DA_DISCIPLINA LIKE '%" + codigo + "%';");
            try {
                conex.rs.first();
                mod.setID_PLANO_ENSINO(0);
                mod.setID_DISCIPLINA(conex.rs.getInt("ID_DISCIPLINA"));
                mod.setCARGA_HORARIA(0);
                mod.setPERIODO_DO_CURSO("");
                mod.setEMENTA("Descrever a ementa do curso.");
                mod.setCOMPETENCIAS_E_HABILIDADES("Descrever as competências e habilidades a serem adquiridas com o curso.");
                mod.setMETODOLOGIA_DE_ENSINO("Descrever as técnicas e recursos da metodologia.");
                mod.setCRONOGRAMA_DE_ATIVIDADES("Descrever o cronograma de atividades.");
                mod.setAVALIACAO("Critérios de avaliação.");
                mod.setBIBLIOGRAFIA("Incluir a bibliografia básica e complementar.");
                mod.setNOME_DISCIPLINA(conex.rs.getString("NOME_DA_DISCIPLINA"));
                mod.setCODIGO_DISCIPLINA(conex.rs.getString("CODIGO_DA_DISCIPLINA"));
                mod.setMATRICULA_PROFESSOR("");
                mod.setNOME_PROFESSOR("");
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "Disciplina não localizada");
            }
        }
        
        conex.desconecta();
        return mod;
    }
}
