package ecp.aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //Caminho do banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/dbUser";
    //Usuario do banco de dados
    private static final String user= "";
    //Senha do banco de dados
    private static final String password = "";
    //Criar conexão
    public static Connection createConnection(){
        try{
            return DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
