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
import modelo.ModeloDisciplina;
/**
 *
 * @author Diarley Gomes
 */
public class ControleDisciplina {
    conectaBD conex = new conectaBD();
    ModeloDisciplina mod = new ModeloDisciplina();
    
    public void Salvar(ModeloDisciplina mod){
        conex.conexao();
        try{
            PreparedStatement pst =conex.con.prepareStatement("insert into Disciplina(NOME_DA_DISCIPLINA,DESCRICAO,CODIGO_DA_DISCIPLINA,SEMESTRE,CARGA_HORARIA) values(?,?,?,?,?)");
            pst.setString(1, mod.getNOME_DISCIPLINA());
            pst.setString(2, mod.getDESCRICAO());
            pst.setString(3, mod.getCODIGO());
            pst.setString(4, mod.getSEMESTRE());
            pst.setInt(5, mod.getCARGA_HORARIA());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!"); 
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\n"+ex);
        }
        conex.desconecta();
    }
    
    public void Editar(ModeloDisciplina mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update Disciplina set NOME_DA_DISCIPLINA=?,DESCRICAO=?,CODIGO_DA_DISCIPLINA=?,SEMESTRE=?,CARGA_HORARIA=? where ID_DISCIPLINA=?;");
            pst.setString(1, mod.getNOME_DISCIPLINA());
            pst.setString(2, mod.getDESCRICAO());
            pst.setString(3, mod.getCODIGO());
            pst.setString(4, mod.getSEMESTRE());
            pst.setInt(5, mod.getCARGA_HORARIA());
            pst.setInt(6, mod.getID_DISCIPLINA());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!"); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados");
        }
        conex.desconecta();
    }
    
    public ModeloDisciplina buscaDisciplina(ModeloDisciplina mod, int ID){
        conex.conexao();
        conex.executaSql("SELECT * FROM Disciplina WHERE ID_DISCIPLINA = "+ID+";");
        try {
            conex.rs.first();
            mod.setNOME_DISCIPLINA(conex.rs.getString("NOME_DA_DISCIPLINA"));
            mod.setDESCRICAO(conex.rs.getString("DESCRICAO"));
            mod.setCODIGO(conex.rs.getString("CODIGO_DA_DISCIPLINA"));
            mod.setSEMESTRE(conex.rs.getString("SEMESTRE"));
            mod.setCARGA_HORARIA(conex.rs.getInt("CARGA_HORARIA"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: "+ex);
        }
        
        conex.desconecta();
        return mod;
    }
    
}
