import java.util.ArrayList;

public class Brachiosaurus extends Unidade {
//gsfdgsdgsdg

    public Brachiosaurus(double ataque, double defesa, double vida, String cor, Posicao posicao) {
        super(35, 55, 500, cor, posicao);
    }

    @Override
    public boolean atacar(Tabuleiro tabuleiro, Jogador jogador) {
        //Acerta os adversarios até 4 casas de distancia
        int posicaoNoTabuleiro= tabuleiro.getListaDePosicaoes().indexOf(this);
        ArrayList<Posicao> posicaoTabuleiro= tabuleiro.getListaDePosicaoes();
        Unidade adversario= tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro+20).getUnidade();

        for (int i = 5; i <20 ; i+=5) {

            if (this.getCor() == "Azul") {
                if (tabuleiro.getListaDePosicaoes().get(i).equals(getCor() == "Vermelho")) {
                        if(adversario.getDefesa()==0){
                            adversario.setVida(adversario.getVida()-35);
                        }else{
                            adversario.setDefesa(adversario.getDefesa()-35);
                            if(adversario.getVida()==0){
                                adversario.setPosicao(null);
                                jogador.removeUnidade(adversario,tabuleiro);
                            }
                        }
                    return true;
                }
            }
            if (this.getCor() == "Vermelho") {
                if (tabuleiro.getListaDePosicaoes().get(i).equals(getCor() == "Azul")) {
                    if(adversario.getDefesa()==0){
                        adversario.setVida(adversario.getVida()-35);
                    }else{
                        adversario.setDefesa(adversario.getDefesa()-35);
                        if(adversario.getVida()==0){
                            adversario.setPosicao(null);
                            jogador.removeUnidade(adversario, tabuleiro);
                        }
                    }
                    return true;
                }
            }
        }


        return false;
    }



}
