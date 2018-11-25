/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import connectionPool.Conexao;
import connectionPool.ConnectionPool;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Agenda;

/**
 *
 * @author jose
 */
public class AgendaBDDao implements Dao{
    
    private ConnectionPool pool;
    private Conexao conexao;
    
    public AgendaBDDao(){
          this.pool= new ConnectionPool("jdbc:mysql://localhost:3306/db_Agenda","root","SuaSenhaAqui","com.mysql.jdbc.Driver");
    }

    @Override
    public boolean inserir(Object object) {
        
        this.conexao=this.pool.getConnection();
        
        
          
         Agenda agenda = (Agenda) object;
        
        String sql="INSERT INTO agenda (nome,email,telefone) VALUES (?, ?, ?)";
        
        
        
        try {
            
            
            
           
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setString(1, agenda.getNome());
            this.conexao.getStmt().setString(2, agenda.getEmail());
            this.conexao.getStmt().setString(3, agenda.getTelefone());
            
            
            
            
            this.conexao.getStmt().execute();
            
            return true;
        } catch (SQLException ex) {
            
            System.err.println("Erro:"+ex);
            
            return false;
        }finally{
            
            this.pool.devolveConexao(conexao);
            conexao=null;
        }
        
    }

    @Override
    public boolean deletar(Object object) {
        
        this.conexao=this.pool.getConnection();
        
        Agenda agenda=(Agenda) object;
       
        System.out.println(agenda.getId());
        String sql="DELETE FROM agenda WHERE id=?";
        
        try {
            
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setInt(1, agenda.getId());
            this.conexao.getStmt().execute();
            
            
            return true;
        } catch (SQLException ex) {
            
            System.out.println("Erro:"+ex);
            return false;
        }finally{
           this.pool.devolveConexao(conexao);
           conexao=null;
        }
                
        
    }

    @Override
    public List buscar() {
        
        this.conexao=this.pool.getConnection();
        
        List <Agenda> lista= new ArrayList<>();
        
        String sql ="SELECT * FROM agenda ";
        
      
        
        try {
            
            
            this.conexao.setStmt(conexao.getConexaoBd().prepareStatement(sql));
            
            this.conexao.setRs(this.conexao.getStmt().executeQuery());
            
            
            
            while(this.conexao.getRs().next()){
                
                Agenda agenda1 = new Agenda ();
                
                agenda1.setEmail(this.conexao.getRs().getString("email"));
                agenda1.setId(this.conexao.getRs().getInt("id"));
                agenda1.setNome(this.conexao.getRs().getString("nome"));
                agenda1.setTelefone(this.conexao.getRs().getString("telefone"));
                
                lista.add(agenda1);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }finally{
            
            this.pool.devolveConexao(conexao);
            conexao=null;
        }
        
        
        
        return lista;
    }

    @Override
    public boolean atualizar(Object object) {
        this.conexao=this.pool.getConnection();
        Agenda agenda = (Agenda)object;
        
        
        String sql="UPDATE agenda SET nome=?,email=?,telefone=? WHERE id=?";
        
        
        try {
          
            
            this.conexao.setStmt(this.conexao.getConexaoBd().prepareStatement(sql));
            this.conexao.getStmt().setString(1, agenda.getNome());
            this.conexao.getStmt().setString(2, agenda.getEmail());
            this.conexao.getStmt().setString(3, agenda.getTelefone());
            this.conexao.getStmt().setInt(4, agenda.getId());
            this.conexao.getStmt().executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        }finally{
            
          boolean res= this.pool.devolveConexao(conexao);
           conexao=null;
      
        }
        
        
       
    }
    
    
    
    
    
}
