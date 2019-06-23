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
import modelo.ModeloProfessor;


/**
 *
 * @author Diarley Gomes
 */
public class ControleProfessor {
    conectaBD conex = new conectaBD();
    ModeloProfessor mod = new ModeloProfessor();
    
    public void Salvar(ModeloProfessor mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into Professor(MATRICULA,PROFESSOR,CPF,MAIOR_TITULACAO,AREA,CURRICULO,DATA_ATUALIZACAO) values(?,?,?,?,?,?,?)");
            pst.setString(1, mod.getMatricula());
            pst.setString(2, mod.getProfessor());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getMaior_titulacao());
            pst.setString(5, mod.getArea());
            pst.setString(6, mod.getCurriculo());
            pst.setString(7, mod.getData());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\n"+ex);
        }
        conex.desconecta();
    }
    
    public ModeloProfessor buscaProfessor(ModeloProfessor mod, int ID){
        conex.conexao();
        conex.executaSql("SELECT * FROM Professor WHERE ID_PROFESSOR = "+ID+";");
        try {
            conex.rs.first();
            mod.setMatricula(conex.rs.getString("MATRICULA"));
            mod.setProfessor(conex.rs.getString("PROFESSOR"));
            mod.setCpf(conex.rs.getString("CPF"));
            mod.setMaior_titulacao(conex.rs.getString("MAIOR_TITULACAO"));
            mod.setArea(conex.rs.getString("AREA"));
            mod.setCurriculo(conex.rs.getString("CURRICULO"));
            mod.setData(conex.rs.getString("DATA_ATUALIZACAO"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: "+ex);
        }
        
        conex.desconecta();
        return mod;
    }
    
    public void Editar(ModeloProfessor mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update Professor set MATRICULA=?, PROFESSOR=?, CPF=?, MAIOR_TITULACAO=?, AREA=?, CURRICULO=?, DATA_ATUALIZACAO=? where ID_PROFESSOR=?;");
            pst.setString(1, mod.getMatricula());
            pst.setString(2, mod.getProfessor());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getMaior_titulacao());
            pst.setString(5, mod.getArea());
            pst.setString(6, mod.getCurriculo());
            pst.setString(7, mod.getData());
            pst.setInt(8, mod.getID_PROFESSOR());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados");
        }
        conex.desconecta();
    }
    
    
}
