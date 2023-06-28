import java.util.ArrayList;

public class brachiosaurus extends Unidade {


    public brachiosaurus(double ataque, double defesa, double vida, String cor) {
        super(35, 55, 500, cor);
    }

    @Override
    public boolean atacar(Unidade adversario,Tabuleiro tabuleiro) {
        //Acerta os adversarios até 4 casas de distancia
        int posicaoNoTabuleiro= tabuleiro.getListaDePosicaoes().indexOf(this);
        ArrayList<Posicao> posicaoTabuleiro= tabuleiro.getListaDePosicaoes();
        adversario= tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro+20).getUnidade();

        for (int i = 0; i <50 ; i++) {

            if (this.getCor() == "Azul") {
                if (tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro+20).equals(getCor() == "Vermelho")) {
                    if( adversario instanceof  Trex){
                        if(adversario.getDefesa()==0){
                            adversario.setVida(adversario.getVida()-35);
                        }else{
                            adversario.setDefesa(adversario.getDefesa()-35);
                        }
                    }
                    return true;
                }
            }
            if (this.getCor() == "Vermelho") {
                if (tabuleiro.getListaDePosicaoes().get(i).equals(getCor() == "Azul")) {

                }
            }
        }


        return false;
    }


}
