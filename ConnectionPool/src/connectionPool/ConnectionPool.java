/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionPool;

/**
 *
 * @author jose
 */
public class ConnectionPool {

    private String driver;
    private String url;
    private String user;
    private String password;
    private Conexao[] conexaos = new Conexao[10];
    private int qtdConexExistente;
    private int qtdConexUtilizado;

    public ConnectionPool(String url, String user, String password, String driver) {
        
        this.driver=driver;
        this.url=url;
        this.password=password;
        this.user=user;

        for (int i = 0; i < 4; i++) {

            conexaos[i] = new Conexao(url, user, password, driver);
            
            this.qtdConexExistente = i;

        }

    }
    
    
    public Conexao getConnection() {
        Conexao conexao = null;

        
        for (int i = 0; i < this.qtdConexExistente; i++) {
            if (!conexaos[i].isUsado()) {
                
                   conexaos[i].setUsado(true);
                   conexao=conexaos[i];
                   
               
                break;
            }
           
           
            
        }
        
       

        this.qtdConexUtilizado++;
        
         if (this.qtdConexExistente == this.qtdConexUtilizado) {

            if (this.qtdConexExistente < this.conexaos.length) {

                this.conexaos[this.qtdConexExistente + 1] = new Conexao(this.url, this.user, this.password, this.driver);
            }
        }

        return conexao;
    }

    public boolean devolveConexao(Conexao connection) {
        this.qtdConexUtilizado--;
        boolean resultado=false;
            for (int i = 0; i <this.qtdConexExistente; i++) {
                
                if (conexaos[i].getId()==connection.getId()) {
                    
                    connection.setUsado(false);
                    conexaos[qtdConexExistente].setUsado(false);
                    resultado=true;
                    
                }else{
                    
                }
            }

       return resultado;
    }

}
