public class Tricerapto extends Unidade {
    public Tricerapto(double ataque, double defesa, double vida, String cor, Posicao posicao, String simbolo) {
        super(ataque, defesa, vida, cor, posicao, simbolo);
    }

    //gsfdgsdgsdg
    @Override
    public boolean atacar(Tabuleiro tabuleiro, Jogador jogador, Posicao posicao) {
        int posicaoNoTabuleiro = tabuleiro.getListaDePosicaoes().indexOf(posicao);


        for (int i = 4; i <= 6; i++) {

            if (this.getCor() == "Azul") {
                Unidade adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + i).getUnidade();
                if (adversario != null) {
                    if (adversario.equals(getCor() == "Vermelho")) {
                        if (adversario.getDefesa() == 0) {
                            adversario.setVida(adversario.getVida() - this.getAtaque());
                            return true;
                        } else {
                            adversario.setDefesa(adversario.getDefesa() - this.getAtaque());
                            if (adversario.getVida() == 0) {
                                adversario.setPosicao(null);
                                jogador.removeUnidade(adversario, tabuleiro);
                            }
                            return true;
                        }
                    }
                    return true;
                }
                } else if (this.getCor() == "Vermelho") {
                Unidade adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro - i).getUnidade();
                if (adversario != null) {
                    if (adversario.equals(getCor() == "Azul")) {
                        if (adversario.getDefesa() == 0) {
                            adversario.setVida(adversario.getVida() - this.getAtaque());
                            return true;
                        } else {
                            adversario.setDefesa(adversario.getDefesa() - this.getAtaque());
                            if (adversario.getVida() == 0) {
                                adversario.setPosicao(null);
                                jogador.removeUnidade(adversario, tabuleiro);
                            }
                            return true;
                        }
                    }
                }
            }



        }
        return false;

    }
}
