package cenaflix.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    Connection conn; //criando um objeto do tipo connection chamado conn
    public String url, usuario, senha;

    public Conexao(){
        url = "jdbc:mysql://localhost:3306/ATIVIDADE1";
        usuario = "root";
        senha = "";
    }

    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, senha);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM filme");
            
            while(rs.next()){
                System.out.println(rs.getString("titulo"));
            }
            
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
