public class Trex extends Unidade {


    public Trex(double ataque, double defesa, double vida, String cor ) {
        super(150, 55, 450, cor);
    }

    @Override
    public boolean atacar(Unidade adversario, Tabuleiro tabuleiro) {
        //Ataca em area
        return false;
    }


}
