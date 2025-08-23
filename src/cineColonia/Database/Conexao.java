package cineColonia.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    public Connection conn; 
    private String url, usuario, senha;

    public Conexao(){
        url = "jdbc:mysql://localhost:3306/cineColonial";
        usuario = "root";
        senha = "";
    }

    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, senha);
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro: interno!" );
            return false;
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro: interno!" );
            return false;
        }
    }

    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sistema se encontra inoperante!" );
        }
    }
}
