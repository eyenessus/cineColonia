/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cenaflix;
import cenaflix.Database.Conexao;
import cenaflix.Screens.SignUpScreen;

/**
 *
 * @author Emerson S.
 */
public class CenaFlix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao con = new Conexao();
        con.conectar();
        new SignUpScreen();
      
    }

}
