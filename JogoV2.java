import java.util.Random;
public class JogoV2 {
    public static void main(String[] args) throws Exception {
        Personagem cacador = new Personagem(10, 0, 0);
        Personagem soneca = new Personagem(2, 4, 9);
        Random gerador = new Random();
        int oQueFazer;
        while(true){
            //Para o personagem caçador
            oQueFazer = gerador.nextInt(3) + 1;
            executarAcao(cacador, oQueFazer);

            //Para o personagem soneca
            oQueFazer = gerador.nextInt(100) + 1;
            oQueFazer = oQueFazer <= 15 ? 1 : oQueFazer <= 30 ? 2 : 3;
            executarAcao(soneca, oQueFazer);
            Thread.sleep(1000);
        }
    }

    public static void executarAcao(Personagem p, int acao){
        switch(acao){
            case 1:
                p.cacar();
                break;
            case 2:
                p.comer();
                break;
            case 3:
                p.dormir();
                break;
            default:
                int oQueFazer = new Random().nextInt(3) + 1;
                executarAcao(p, oQueFazer);
                break;
        }
    }
}
