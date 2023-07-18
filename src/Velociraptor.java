public class Velociraptor extends Unidade {

    private String habilidade;
    private Posicao posicao;

    public Velociraptor(double ataque, double defesa, double vida, String cor, Posicao posicao) {
        super(70, 25, 250, cor,posicao);
    }
//gsfdgsdgsdg

    @Override
    public boolean atacar( Tabuleiro tabuleiro, Jogador jogador) {
        int posicaoNoTabuleiro = tabuleiro.getListaDePosicaoes().indexOf(this);
       Unidade adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + 5).getUnidade();


        if (this.getCor() == "Azul") {
            if (adversario.getCor().equals("Vermelho")) {
                if (adversario.getDefesa() == 0) {
                    adversario.setVida(adversario.getVida() - this.getAtaque()*2);
                    return true;
                } else {
                    adversario.setDefesa(adversario.getDefesa() - this.getAtaque()*2);
                    if(adversario.getVida()==0){
                        adversario.setPosicao(null);
                        jogador.removeUnidade(adversario,tabuleiro);
                    }
                    return true;
                }
            }
        } else if (this.getCor() == "Vermelho") {
            if (adversario.getCor().equals("Azul")) {
                if (adversario.getDefesa() == 0) {
                    adversario.setVida(adversario.getVida() - this.getAtaque()*2);
                    return true;
                } else {
                    adversario.setDefesa(adversario.getDefesa() - this.getAtaque()*2);
                    if(adversario.getVida()==0){
                        adversario.setPosicao(null);
                        jogador.removeUnidade(adversario,tabuleiro);
                    }
                    return true;
                }
            }
        }

        return false;
    }


}

