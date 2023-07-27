

public class Brachiosaurus extends Unidade {

    public Brachiosaurus(double ataque, double defesa, double vida, String cor, Posicao posicao, String simbolo) {
        super(ataque, defesa, vida, cor, posicao, simbolo);
    }

    @Override
    public boolean atacar(Tabuleiro tabuleiro, Jogador jogador, Posicao posicao) {
        //Acerta os adversarios até 4 casas de distancia
        int posicaoNoTabuleiro = tabuleiro.getListaDePosicaoes().indexOf(posicao);

        for (int i = 5; i < 20; i += 5) {

            if (this.getCor().equals("Azul")) {
                System.out.println("Primeiro if foi");
                Unidade adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + i).getUnidade();
                if (adversario != null) {
                    System.out.println("Segundo if foi");
                    if (tabuleiro.getListaDePosicaoes().get(i).equals(getCor().equals("Vermelho"))) {
                        System.out.println("Terceiro if foi");
                        if (adversario.getDefesa() == 0) {
                            System.out.println("Quarto if foii");
                            adversario.setVida(adversario.getVida() - 35);
                        } else {
                            adversario.setDefesa(adversario.getDefesa() - 35);
                            if (adversario.getVida() == 0) {
                                adversario.setPosicao(null);
                                jogador.removeUnidade(adversario, tabuleiro);
                            }
                        }
                        return true;
                    }
                }
            }else if (this.getCor().equals("Vermelho")) {
                if (tabuleiro.getListaDePosicaoes().get(i).equals(getCor().equals("Azul"))) {

                    Unidade adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro - i).getUnidade();
                    if (adversario != null) {
                        if (adversario.getDefesa() == 0) {

                            adversario.setVida(adversario.getVida() - 35);
                        } else {
                            adversario.setDefesa(adversario.getDefesa() - 35);
                            if (adversario.getVida() == 0) {
                                adversario.setPosicao(null);
                                jogador.removeUnidade(adversario, tabuleiro);
                            }
                        }
                        return true;
                    }
                }
            }
        }


        return false;
    }


}
