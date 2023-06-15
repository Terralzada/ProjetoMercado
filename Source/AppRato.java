package Source;

public class AppRato {

    public static void main(String[] args) {

        Labirinto teste = new Labirinto();
        Rato mickey = new Rato(teste);

        System.out.println("Mapa Criado:");
        teste.mostrarMapa();
        System.out.println();
        System.out.println();


        if(mickey.acharSaida('j', teste.getxRato(), teste.getyRato())){
            System.out.println("Achou a saida");
        }else{
            System.out.println("Nao achou a saida");
        }

        System.out.println();
        System.out.println("Caminho percorrido:");
        ciclano.mostrarCaminho();
    }
}
