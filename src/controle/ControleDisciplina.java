/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
