import java.util.Random;
public class Labirinto {

    //Atributos
    private int parede , entrada, saida;
    private int x, y, nParedes, xFulano, yFulano;
    private int mapa[][];
    private Random rand;

    //construtor
    public Labirinto(){
        parede = 1;
        entrada = 3;
        saida = 5;
        rand = new Random();
        x = 0;
        y = 0;
        xFulano = 0;
        yFulano = 0;
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
        xFulano = x;
        yFulano = y;

        //definicao das paredes (100)
        gerarParedes();
    }
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
