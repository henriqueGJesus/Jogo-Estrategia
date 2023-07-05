public class Velociraptor extends Unidade {

    private String habilidade;
    private Posicao posicao;

    public Velociraptor(double ataque, double defesa, double vida, String cor) {
        super(70, 25, 250, cor);
    }


    @Override
    public boolean atacar(Unidade adversario, Tabuleiro tabuleiro) {
        int posicaoNoTabuleiro = tabuleiro.getListaDePosicaoes().indexOf(this);
        adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + 5).getUnidade();


        if (this.getCor() == "Azul") {
            if (adversario.getCor().equals("Vermelho")) {
                if (adversario.getDefesa() == 0) {
                    adversario.setVida(adversario.getVida() - this.getAtaque()*2);
                    return true;
                } else {
                    adversario.setDefesa(adversario.getDefesa() - this.getAtaque()*2);
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
                    return true;
                }
            }
        }

        return false;
    }


}

