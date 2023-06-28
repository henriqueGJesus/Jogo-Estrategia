public class Velociraptor extends Unidade {

    private String habilidade;
    private Posicao posicao;

    public Velociraptor(double ataque, double defesa, double vida, String cor) {
        super(70, 25, 250, cor);
    }


    @Override
    public boolean atacar(Unidade adversario, Tabuleiro tabuleiro) {
        // Acerta dois hits por vez
    return false;
    }

}

