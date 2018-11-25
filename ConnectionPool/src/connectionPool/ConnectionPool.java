/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class ConnectionPool {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static ArrayList<Connection> conexaoFila;
    private static ArrayList<Connection> filaConexaoUsada;

    private int tamanhoPool;

    public ConnectionPool(String url1, String user1, String password1,String driver, ArrayList pool1) {
       
        ConnectionPool.url=url1;
        ConnectionPool.user=user1;
        ConnectionPool.password=password1;
        ConnectionPool.conexaoFila=pool1;
        ConnectionPool.driver=driver;
               
        

    }

    public static ConnectionPool criar(String url, String user, String password,String driver) {

        conexaoFila = new ArrayList<>(4);
        filaConexaoUsada = new ArrayList<>(4);

        for (int i = 0; i < 4; i++) {

            try {
                conexaoFila.add(criarConexao(url, user, password,driver));
            } catch (SQLException | ClassNotFoundException ex) {

                System.err.println("Erro ao conectar ao banco de dados:" + ex);

            }

        }

        return new ConnectionPool(url,user,password,driver,conexaoFila) ;
    }

    public static Connection criarConexao(String url, String user, String password,String driver1) throws SQLException, ClassNotFoundException {
        
        driver=driver1;
      Class.forName(driver);

        return DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        Connection connection = conexaoFila.remove(0);
        filaConexaoUsada.add(connection);

        return connection;
    }

    public boolean devolveConexao(Connection connection) {

        boolean resultado;
        conexaoFila.add(connection);
        resultado = filaConexaoUsada.remove(connection);

        return resultado;
    }

}
