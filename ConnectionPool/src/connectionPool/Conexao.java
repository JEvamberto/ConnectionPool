/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author jose
 */
public class Conexao {
    
    boolean  usado;
    PreparedStatement stmt;
    ResultSet rs;
    Connection conexaoBd;
    static int qtd=0;
    private int id=0;
    
    public Conexao(String url, String user,String password, String driver){
        
        try {
            
            
            Class.forName(driver);
            conexaoBd=DriverManager.getConnection(url, user, password);
            this.usado=false;
        } catch (ClassNotFoundException | SQLException ex) {
             throw new RuntimeException("Erro ao estabelecer a comunicação com o banco de dados", ex);
        }
        
        qtd++;
        this.id=qtd;
    
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Connection getConexaoBd() {
        return conexaoBd;
    }

    private void setConexaoBd(Connection conexaoBd) {
        this.conexaoBd = conexaoBd;
    }

    protected boolean isUsado() {
        return usado;
    }

    protected void setUsado(boolean usado) {
        this.usado = usado;
    }

    public int getId() {
        return id;
    }


  




    
    
    
    
}
