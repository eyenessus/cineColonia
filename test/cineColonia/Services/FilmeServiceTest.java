/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cineColonia.Services;

import cineColonia.Model.Category;
import cineColonia.Model.Film;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emers
 */
public class FilmeServiceTest {

    public FilmeServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of registrarFilme method, of class FilmeService.
     */
    @Test
    public void testRegistrarFilme() {
        System.out.println("registrarFilme");
        Category category = new Category("Futebol");

        Film film = new Film();
        film.setId(Long.valueOf(1));
        film.setTitle("Jogo 360");
        film.setDate(new java.util.Date());
        film.setCategory(category);
        FilmeService instance = new FilmeService();
        boolean expResult = true;
        boolean result = instance.registrarFilme(film);
        assertEquals(expResult, result);
        System.err.println("Filme registrado com sucesso.");
    }

}
