package Tests;

import Source.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    public void testeCriarMapa() {
        int mapa_matrix[][];
        Labirinto mapa = new Labirinto();
        mapa.criarMapa();
        mapa_matrix = mapa.getMapa();
        assertEquals(3, mapa_matrix[mapa.getxEntrada()][mapa.getyEntrada()]);
        assertEquals(5, mapa_matrix[mapa.getxSaida()][mapa.getySaida()]);
    }

    @Test
    public void TesteRandomizar() {
        Labirinto mapa = new Labirinto();
        mapa.randomizar();
        assertTrue(mapa.getX() < 21 && mapa.getX() > -1, "Latitude dentro do range de (0,20) x: " + mapa.getX());
        assertTrue(mapa.getY() < 21 && mapa.getY() > -1, "Longitude dentro do range de (0,20) y: " + mapa.getY());
    }

    @Test
    public void testeGerarParedes() {
        Labirinto mapa = new Labirinto();
        assertTrue(mapa.gerarParedes(), "Paredes sendo geradas com sucesso!");
        assertEquals(120, mapa.getnParedes());
    }


}
