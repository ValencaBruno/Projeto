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
import modelo.ModeloCurso;
import visão.Cadastrodecurso;

/**
 *
 * @author Diarley Gomes
 */


public class ControleCurso {
    conectaBD conex = new conectaBD();
    ModeloCurso mod = new ModeloCurso();
    //public String BotaoCurso;
    
    public void Salvar (ModeloCurso mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into Cursos(TIPO_DE_CURSO,MODALIDADE,CURSO,HABILITACAO,LOCAL_DE_OFERTA,TURNOS_DE_FUNCIONAMENTO,NUMERO_DE_VAGAS_PARA_CADA_TURNO,CARGA_HORARIA_DO_CURSO,REGIME_LETIVO,PERIODOS,NOME,CPF,TITULACAO,TEMPO_DE_DEDICACAO) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getTIPO_CURSO());
            pst.setString(2, mod.getMODALIDADE());
            pst.setString(3, mod.getCURSO());
            pst.setString(4, mod.getHABILITACAO());
            pst.setString(5, mod.getLOCAL_OFERTA());
            pst.setString(6, mod.getTURNO_FUNCIONAMENTO());
            pst.setInt(7, mod.getNUMERO_VAGAS());
            pst.setInt(8, mod.getCARGA_HORARIA());
            pst.setString(9, mod.getREGIME_LETIVO());
            pst.setString(10, mod.getPERIODOS());
            pst.setString(11, mod.getNOME());
            pst.setString(12, mod.getCPF());
            pst.setString(13, mod.getTITULACAO());
            pst.setString(14, mod.getTEMPO_DEDICACAO());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\n"+ex);
        }
        conex.desconecta();
    }
    
    public void Editar(ModeloCurso mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update Cursos set TIPO_DE_CURSO=?, MODALIDADE=?, CURSO=?, HABILITACAO=?, LOCAL_DE_OFERTA=?, TURNOS_DE_FUNCIONAMENTO=?, NUMERO_DE_VAGAS_PARA_CADA_TURNO=?, CARGA_HORARIA_DO_CURSO=?, REGIME_LETIVO=?, PERIODOS=?, NOME=?, CPF=?, TITULACAO=?, TEMPO_DE_DEDICACAO=? where ID_CURSOS=?;");
            pst.setString(1, mod.getTIPO_CURSO());
            pst.setString(2, mod.getMODALIDADE());
            pst.setString(3, mod.getCURSO());
            pst.setString(4, mod.getHABILITACAO());
            pst.setString(5, mod.getLOCAL_OFERTA());
            pst.setString(6, mod.getTURNO_FUNCIONAMENTO());
            pst.setInt(7, mod.getNUMERO_VAGAS());
            pst.setInt(8, mod.getCARGA_HORARIA());
            pst.setString(9, mod.getREGIME_LETIVO());
            pst.setString(10, mod.getPERIODOS());
            pst.setString(11, mod.getNOME());
            pst.setString(12, mod.getCPF());
            pst.setString(13, mod.getTITULACAO());
            pst.setString(14, mod.getTEMPO_DEDICACAO());
            pst.setInt(15, mod.getID_CURSO());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados");
        }
        
        conex.desconecta();
        
    }
    
    public ModeloCurso buscaCurso(ModeloCurso mod, int ID){
        Cadastrodecurso tela = new Cadastrodecurso();
        conex.conexao();
        conex.executaSql("SELECT * FROM Cursos WHERE ID_CURSOS = "+ID+";");
        try {
            conex.rs.first();
            //JOptionPane.showMessageDialog(null, ID+conex.rs.getString("TIPO_DE_CURSO"));
            mod.setTIPO_CURSO(conex.rs.getString("TIPO_DE_CURSO"));
            mod.setMODALIDADE(conex.rs.getString("MODALIDADE"));
            mod.setCURSO(conex.rs.getString("CURSO"));
            mod.setHABILITACAO(conex.rs.getString("HABILITACAO"));
            mod.setLOCAL_OFERTA(conex.rs.getString("LOCAL_DE_OFERTA"));
            mod.setTURNO_FUNCIONAMENTO(conex.rs.getString("TURNOS_DE_FUNCIONAMENTO"));
            mod.setNUMERO_VAGAS(conex.rs.getInt("NUMERO_DE_VAGAS_PARA_CADA_TURNO"));
            mod.setCARGA_HORARIA(conex.rs.getInt("CARGA_HORARIA_DO_CURSO"));
            mod.setREGIME_LETIVO(conex.rs.getString("REGIME_LETIVO"));
            mod.setPERIODOS(conex.rs.getString("PERIODOS"));
            mod.setNOME(conex.rs.getString("NOME"));
            mod.setCPF(conex.rs.getString("CPF"));
            mod.setTITULACAO(conex.rs.getString("TITULACAO"));
            mod.setTEMPO_DEDICACAO(conex.rs.getString("TEMPO_DE_DEDICACAO"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: "+ex);
    }
    
    
    conex.desconecta();
    return mod;
    }
}
