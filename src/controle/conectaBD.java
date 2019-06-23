/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Diarley Gomes
 */
public class conectaBD {
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://www.db4free.net/projeintegrado2";
    private String usuario = "grupo6";
    private String senha = "dialuabru";
    public Connection con;
    
    public void conexao(){
        try{
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexão Efetuada com Sucesso!!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados:\n"+ex.getMessage());
        }
    }
    
    public void executaSql(String sql){
    try {
    stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
    rs = stm.executeQuery(sql);
    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Erro ExecutaSql:\n"+ex.getMessage());
    }
    
    }
    
    public void desconecta(){
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "BD Desconectado com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com BD:\n"+ex.getMessage());
        }
    }
}
