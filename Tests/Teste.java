package Tests;

import Source.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {

     @Test
    public void TesteRandomizar(){
        Labirinto mapa = new Labirinto();
        mapa.randomizar();
        assertTrue(mapa.getX() < 21 && mapa.getX() > -1);
        assertTrue(mapa.getY() < 21 && mapa.getY() > -1);
    }

}
