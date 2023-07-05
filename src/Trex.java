public class Trex extends Unidade {


    public Trex(double ataque, double defesa, double vida, String cor ) {
        super(150, 55, 450, cor);
    }

    @Override
    public boolean atacar(Unidade adversario, Tabuleiro tabuleiro) {
        int posicaoNoTabuleiro = tabuleiro.getListaDePosicaoes().indexOf(this);

        for (int i = 4; i <=6 ; i++) {
            if (this.getCor() == "Azul") {
                adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + i).getUnidade();
                if (adversario.equals(getCor() == "Vermelho")) {
                    if (adversario.getDefesa() == 0) {
                        adversario.setVida(adversario.getVida() - this.getAtaque());
                        return true;
                    } else {
                        adversario.setDefesa(adversario.getDefesa() - this.getAtaque());
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
                        return true;
                    }
                }

            }
        }
        return false;
    }


}