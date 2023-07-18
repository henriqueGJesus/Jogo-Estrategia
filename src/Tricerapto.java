public class  Tricerapto extends Unidade {
    public Tricerapto(double ataque, double defesa, double vida, String cor, Posicao posicao) {
        super(ataque, defesa, vida, cor, posicao);
    }
    //gsfdgsdgsdg
    @Override
    public boolean atacar(Tabuleiro tabuleiro, Jogador jogador) {
        int posicaoNoTabuleiro = tabuleiro.getListaDePosicaoes().indexOf(this);

        for (int i = 4; i <=6 ; i++) {
            Unidade adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + i).getUnidade();
            if (this.getCor() == "Azul") {
                if (adversario.equals(getCor() == "Vermelho")) {
                    if (adversario.getDefesa() == 0) {
                        adversario.setVida(adversario.getVida() - this.getAtaque());
                        return true;
                    } else {
                        adversario.setDefesa(adversario.getDefesa() - this.getAtaque());
                        if(adversario.getVida()==0){
                            adversario.setPosicao(null);
                            jogador.removeUnidade(adversario,tabuleiro);
                        }
                        return true;
                    }
                }
                return true;
            }else if(this.getCor() =="Vermelho"){
                adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro - i).getUnidade();
                if (adversario.equals(getCor() == "Azul")) {
                    if (adversario.getDefesa() == 0) {
                        adversario.setVida(adversario.getVida() - this.getAtaque());
                        return true;
                    } else {
                        adversario.setDefesa(adversario.getDefesa() - this.getAtaque());
                        if(adversario.getVida()==0){
                            adversario.setPosicao(null);
                            jogador.removeUnidade(adversario,tabuleiro);
                        }
                        return true;
                    }
                }

            }
        }
        return false;

    }
}