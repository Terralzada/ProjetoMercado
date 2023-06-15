import java.util.Random;
public class Labirinto {

    //Atributos
    private String parede , entrada, saida;
    private int x, y, nParedes, xRato, yRato;
    private String mapa[][];
    private Random rand;

    //construtor
    public Labirinto(){
        parede = "|";
        entrada = "*";
        saida = "#";
        rand = new Random();
        x = 0;
        y = 0;
        xRato = 0;
        yRato = 0;
        nParedes = 0;
        criarMapa();
    }

    private void criarMapa(){
        //definicao de caminho
        gerarCaminho();

        //definicao da saida
        randomizar();
        mapa[x][y] = saida;

        //definicao da entrada
        while(mapa[x][y] == saida){
            randomizar();
        }

        mapa[x][y] = entrada;
        xRato = x;
        yRato = y;

        //definicao das paredes (100)
        gerarParedes();
    }


    private void randomizar(){
        x = rand.nextInt(20);
        y = rand.nextInt(20);
    }

    private boolean gerarParedes(){
        randomizar();
        if (nParedes > 120) {
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

    private void gerarCaminho(){
        mapa = new String[20][20];

        for (int colunas = 0; colunas < 20; colunas++) {
            for (int linhas = 0; linhas < 20; linhas++) {
                mapa[colunas][linhas] = " ";

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
}