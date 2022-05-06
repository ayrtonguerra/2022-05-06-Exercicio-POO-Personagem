public class Personagem {
    //Membros
    //Atributos (variáveis)
    private String nome;
    private int energia;
    private int fome;
    private int sono;
    private final static int MAX_ENERGIA = 10; //Constante: tudo maiúsculo e padrão snake-case
    private final static int MIN_ENERGIA = 0;
    private final static int MAX_FOME = 10;
    private final static int MIN_FOME = 0;
    private final static int MAX_SONO = 10;
    private final static int MIN_SONO = 0;


    //método de acesso (getter)
    //tipo de retorno
    //nome
    //lista de parâmetros
    //corpo
    public int getEnergia(){
        return energia;
    }

    //setter
    //public void setEnergia(int energia){
    //    this.energia = energia;
    //}
    //Apagado pelo princípio do menor privilégio

    public Personagem(){
        this(MAX_ENERGIA, MIN_FOME, MIN_SONO);
        // this.energia = 10;
        // this.fome = 0;
        // this.sono = 0;
    }

    public Personagem(String nome){
        this();
        this.nome = nome;
    }

    public Personagem(int energia, int fome, int sono){
        //resolver o problema usando o operador ternário
        //se a energia estiver no intervalo válido, fazer 
        // a atribuição. Caso contrário, atribuir 10
        //anti-pattern: números mágicos (estão voando e você não sabe muito bem o que eles significam)

        this.energia = energia >= MIN_ENERGIA && energia <= MAX_ENERGIA ? energia : MAX_ENERGIA;
        this.fome = fome >= MIN_FOME && fome <= MAX_FOME ? fome : MAX_FOME;
        this.sono = sono >= MIN_SONO && sono <= MAX_SONO ? sono : MAX_SONO;

        // if(energia >= 0 && energia <= 10){
        //     this.energia = energia;
        // }
        // if(fome >= 0 && fome <= 10){
        //     this.fome = fome;
        // }
        // if(sono >= 0 && sono <= 10){
        //     this.sono = sono;
        // }
    }

    public Personagem(String nome, int energia, int fome, int sono) {
        this(nome);
        this(energia, fome, sono);
    }

    //métodos (comportamentos)
    //tipo de retorno
    //nome
    //lista de parâmetros
    //corpo
    //public final abstract native
    void cacar(){
        if(energia >= 2){
            System.out.println(nome + " caçando...");
            //energia = energia - 2;
            energia-=2;
        } else {
            System.out.printf("%s sem energia para caçar...%n", nome);
        }
        fome = fome + 1 <= 10 ? fome + 1 : 10;
        sono = Math.min(sono + 1, 10);
        this.exibirEstado();
    }

    void comer(){
        if(fome >= 1){
            System.out.println(nome + " comendo...");
            energia = Math.min(energia + 1, 10);
            fome--;
        } else {
            System.out.printf("%s sem fome...%n", nome);
        }
        this.exibirEstado();
    }

    void dormir(){
        if(sono >= 1){
            System.out.printf("%s dormindo...%n", nome);
            energia = energia + 1 <= 10 ? energia + 1 : 10;
            //sono = sono - 1;
            //sono -= 1;
            //sono--;
            --sono;
        } else {
            System.out.printf("%s sem sono...%n", nome);
            //String s = String.format("%s sem sono...", nome);
        }
        this.exibirEstado();
    }

    void exibirEstado(){
        System.out.format("%s - Energia: %d Fome: %d Sono: %d%n", this.nome, this.energia, this.fome, this.sono);
        System.out.println("==============================================================");
    }
}
