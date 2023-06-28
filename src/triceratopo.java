public class triceratopo extends Unidade {

    //Protege adversarios
    public triceratopo(double ataque, double defesa, double vida, String cor) {
        super(50, 150, 600, cor);
    }

    @Override
    public boolean atacar(Unidade adversario, Tabuleiro tabuleiro) {

        return false;
    }


}
