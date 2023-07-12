public class  Tricerapto extends Unidade {
    public Tricerapto(double ataque, double defesa, double vida, String cor, Posicao posicao) {
        super(ataque, defesa, vida, cor, posicao);
    }

    @Override
    public boolean atacar(Tabuleiro tabuleiro) {
        return false;
    }
}
