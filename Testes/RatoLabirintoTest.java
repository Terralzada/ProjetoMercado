package Testes;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class RatoLabirintoTest {
    private Labirinto labirinto;
    private Rato rato;

    @Before
    public void configuracao() {
        labirinto = new Labirinto();
        rato = new Rato(labirinto);
    }

    @Test
    public void testAcharSaida() {
        boolean encontrouSaida = rato.acharSaida('j', labirinto.getxRato(), labirinto.getyRato());
        Assert.assertTrue("O rato deveria encontrar a saída", encontrouSaida);
    }

    @Test
    public void testMostrarCaminho() {
        rato.acharSaida('j', labirinto.getxRato(), labirinto.getyRato());

        // Redireciona a saída do console para capturar o labirinto impresso
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        rato.mostrarCaminho();

        // Restaura a saída do console
        System.setOut(originalOut);

        // Compara o labirinto impresso com a saída esperada
        String saidaEsperada =
                "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 5 \n";

        Assert.assertEquals(saidaEsperada.trim(), outputStream.toString().trim(),
                "O labirinto impresso não coincide com a saída esperada");
    }
}
