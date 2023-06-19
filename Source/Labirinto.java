package Source;

import java.util.Random;
import java.util.Stack;

public class Labirinto {

    //Atributos
    private String parede , entrada, saida;
    private int x, y, nParedes, xRato, yRato, xEntrada, yEntrada, xSaida, ySaida;
    private String[][] mapa;
    private Random rand;

    //construtor
    public Labirinto(){
        parede = "P";
        entrada = "E";
        saida = "S";
        rand = new Random();
        x = 0;
        y = 0;
        xRato = 0;
        yRato = 0;
        nParedes = 0;
        criarMapa();
    }

    public void criarMapa(){
        //definicao de caminho
        gerarCaminho();

        //definicao da saida
        randomizar();
        mapa[x][y] = saida;
        xSaida = x;
        ySaida = y;

        //definicao da entrada
        while(mapa[x][y] == saida){
            randomizar();
        }

        mapa[x][y] = entrada;
        xEntrada = x;
        yEntrada = y;
        xRato = x;
        yRato = y;

        //definicao das paredes (100)
        gerarParedes();
    }


    public void randomizar(){
        x = rand.nextInt(20);
        y = rand.nextInt(20);
    }

    public boolean gerarParedes(){
        randomizar();
        if (nParedes > 119) {
            return true;
        }else if(mapa[x][y] == parede){
            gerarParedes();
        }else if(mapa[x][y] == saida){
            gerarParedes();
        }else if(mapa[x][y] == entrada){
            gerarParedes();
        }else{
            mapa[x][y] = parede;
            nParedes++;
            if (gerarParedes()) {
                return true;
            }
        }

        return true;
    }

    public void gerarCaminho(){
        mapa = new String[20][20];

        for (int colunas = 0; colunas < 20; colunas++) {
            for (int linhas = 0; linhas < 20; linhas++) {
                mapa[colunas][linhas] = ".";

            }
        }
    }

    public void mostrarMapa(){
        for (int colunas = 0; colunas < 20; colunas++) {
            for (int linhas = 0; linhas < 20; linhas++) {
                System.out.print(mapa[colunas][linhas] + " ");
            }
            System.out.println();
        }
    }

    public int getxRato() {
        return xRato;
    }

    public int getyRato() {
        return yRato;
    }

    public String[][] getMapa() {
        return mapa;
    }

    public int getX(){ return x;}

    public int getY(){ return y;}

    public int getnParedes(){ return nParedes;}

    public int getxEntrada() {return xEntrada;}

    public int getyEntrada() {return yEntrada;}

    public int getxSaida() {return xSaida;}

    public int getySaida() {return ySaida;}


}