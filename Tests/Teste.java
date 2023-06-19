package Tests;

import Source.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    public void testeCriarMapa() {
        String mapa_matrix[][];
        Labirinto mapa = new Labirinto();
        mapa.criarMapa();
        mapa_matrix = mapa.getMapa();
        assertEquals("E", mapa_matrix[mapa.getxEntrada()][mapa.getyEntrada()]);
        assertEquals("S", mapa_matrix[mapa.getxSaida()][mapa.getySaida()]);
    }

    @Test
    public void testeRandomizar() {
        Labirinto mapa = new Labirinto();
        mapa.randomizar();
        assertTrue(mapa.getX() < 21 && mapa.getX() > -1, "Latitude dentro do range de (0,20) x: " + mapa.getX());
        assertTrue(mapa.getY() < 21 && mapa.getY() > -1, "Longitude dentro do range de (0,20) y: " + mapa.getY());
    }

    @Test
    public void testeGerarParedes() {
        Labirinto mapa = new Labirinto();
        assertTrue(mapa.gerarParedes(), "Paredes sendo geradas com sucesso!");
    }

    @Test
    public void testeEncontrarSaida() {
        Labirinto mapa = new Labirinto();
        mapa.criarMapa();
        Rato rato = new Rato(mapa);
        assertTrue(new Rato(mapa).acharSaida('j', mapa.getxRato(), mapa.getyRato()));
    }

    @Test
    public void  testeGerarCaminho(){
        Labirinto mapa = new Labirinto();
        String mapaTeste[][] = new String[20][20];

        for (String[] linha : mapaTeste)
            Arrays.fill(linha, ".");

        mapa.gerarCaminho();
        assertArrayEquals(mapa.getMapa(),mapaTeste);
    }

    @Test
    public void testeGetXYRato(){
        Labirinto mapa = new Labirinto();
        assertTrue(mapa.getxRato() < 21 && mapa.getxRato() > -1, "Latitude dentro do range de (0,20) x: " + mapa.getxRato());
        assertTrue(mapa.getyRato() < 21 && mapa.getyRato() > -1, "Longitude dentro do range de (0,20) y: " + mapa.getyRato());
    }

    @Test
    public  void testeNParedes(){
        Labirinto mapa = new Labirinto();
        assertEquals(120,mapa.getnParedes());
    }

    @Test
    public void testeGetXYEntrada(){
        Labirinto mapa = new Labirinto();
        assertTrue(mapa.getxEntrada() < 21 && mapa.getxEntrada() > -1, "Latitude dentro do range de (0,20) x: " + mapa.getxEntrada());
        assertTrue(mapa.getyEntrada() < 21 && mapa.getyEntrada() > -1, "Longitude dentro do range de (0,20) y: " + mapa.getyEntrada());
    }

    @Test
    public void testeGetXYSaida(){
        Labirinto mapa = new Labirinto();
        assertTrue(mapa.getxSaida() < 21 && mapa.getxSaida() > -1, "Latitude dentro do range de (0,20) x: " + mapa.getxSaida());
        assertTrue(mapa.getySaida() < 21 && mapa.getySaida() > -1, "Longitude dentro do range de (0,20) y: " + mapa.getySaida());
    }
}
