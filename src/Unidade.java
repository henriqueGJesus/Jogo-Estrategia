import java.util.ArrayList;

public abstract class Unidade {
    private double vida;
    private double ataque;
    private double defesa;
    private Posicao posicao;
    private final String cor;
    private final String simbolo;
    final ArrayList<Unidade> listaUnidades = new ArrayList<>();
    final ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

    public Unidade(double ataque, double defesa, double vida, String cor, Posicao posicao, String simbolo) {
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.cor = cor;
        this.posicao = posicao;
        this.simbolo = simbolo;
        listaUnidades.add(this);
    }



    public void movimentar(Posicao posicaoDoMovimento, Posicao posicaoDeOrigem, Tabuleiro tabuleiro, Jogador jogador) {
        posicaoDeOrigem.setUnidade(null);
        posicaoDoMovimento.setUnidade(this);
        setPosicao(posicaoDoMovimento);
        tabuleiro.atualizar(this.getPosicao(), posicaoDeOrigem, jogador);

    }

    public boolean atacar(Tabuleiro tabuleiro, Jogador jogador, Posicao posicao){
        ArrayList<Unidade> unidadeAtacar = new ArrayList<>();
        int posicaoNoTabuleiro = tabuleiro.getListaDePosicaoes().indexOf(posicao);

        for (int i = 4; i <= 6; i++) {
            int j = i;

            if (this.getCor().equals("Vermelho")) {
                j *= -1;
            }
            Unidade adversario = tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + j).getUnidade();
            if (adversario != null && !this.getCor().equals(adversario.getCor())) {
                double danoVida = this.getAtaque();
                unidadeAtacar.add(adversario);
                if (adversario.getDefesa() > 0) {

                    if (this.getAtaque() > adversario.getDefesa()) {
                        danoVida = this.getAtaque() - adversario.getDefesa();
                        adversario.setDefesa(0);
                    }else {
                        adversario.setDefesa(adversario.getDefesa() - this.getAtaque());
                        danoVida = 0;
                    }

                }
                adversario.setVida(adversario.getVida() - danoVida);
                if (adversario.getVida() == 0) {
                    adversario.setPosicao(null);
                    jogador.removeUnidade(adversario, tabuleiro);
                }
            }

        }
        return (unidadeAtacar.size()>0);
    }


    public String getCor() {
        return cor;
    }

    public double getVida() {
        return vida;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public double getAtaque() {
        return ataque;
    }


    @Override
    public String toString() {
        return "Unidade" + this.getClass();

    }

    private void possiveisMovimentos(Tabuleiro tabuleiro) {

        possiveisMovimentos.clear();
        int posicaoNoTabuleiro = tabuleiro.getListaDePosicaoes().indexOf(this.posicao);

        ArrayList<Posicao> posicaoTabuleiro = tabuleiro.getListaDePosicaoes();

        for (int i = 4; i <= 6  ; i+=2) {
            int j=i;
            if (posicaoTabuleiro.get(posicaoNoTabuleiro).getUnidade().getCor().equals("Vermelho")) {
                j*=-1;
                }
                if (posicaoTabuleiro.get(posicaoNoTabuleiro + j).getUnidade() == null) {
                    possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + j));
                }
        }


            if (!verificaExtremidade(posicaoNoTabuleiro) &&
                    posicaoTabuleiro.get(posicaoNoTabuleiro + 4).getUnidade() == null) {
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + 4));
            }
            if (!verificaExtremidade(posicaoNoTabuleiro+1) &&
                    posicaoTabuleiro.get(posicaoNoTabuleiro + 6).getUnidade() == null) {
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro + 6));
            }
        }
//
//        if (posicaoTabuleiro.get(posicaoNoTabuleiro).getUnidade().getCor().equals("Vermelho")) {
//            if (posicaoTabuleiro.get(posicaoNoTabuleiro - 5).getUnidade() == null) {
//                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro - 5));
//            }
//            if (!verificaExtremidade(posicaoNoTabuleiro+1) &&
//                    posicaoTabuleiro.get(posicaoNoTabuleiro - 4).getUnidade() == null) {
//                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro - 4));
//            }
//            if ( !verificaExtremidade(posicaoNoTabuleiro) &&
//                    posicaoTabuleiro.get(posicaoNoTabuleiro - 6).getUnidade() == null) {
//                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro - 6));
//            }
//        }
//
//        if(!verificaExtremidade(posicaoNoTabuleiro+1) &&
//                posicaoTabuleiro.get(posicaoNoTabuleiro + 1).getUnidade() == null){
//
//            possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro+1));
//
//        }
//        if( !verificaExtremidade(posicaoNoTabuleiro) &&
//                posicaoTabuleiro.get(posicaoNoTabuleiro -1).getUnidade() == null){
//
//            possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(posicaoNoTabuleiro-1));
//
//        }


    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;

    }


    public String getSimbolo() {
        return simbolo;
    }

     public ArrayList<String> toStringPossiveisMovimentos(Tabuleiro tabuleiro){
        this.possiveisMovimentos(tabuleiro);
        ArrayList<String> listaDepossiveisMovimentos = new ArrayList<>();

        for (Posicao posicao: possiveisMovimentos) {
            int posicaoEscolha = tabuleiro.getListaDePosicaoes().indexOf(posicao);
            listaDepossiveisMovimentos.add(possiveisMovimentos.indexOf(posicao)+"- "+ posicaoEscolha);
        }



        return listaDepossiveisMovimentos;
    }

    private boolean verificaExtremidade( int index) {
        return (index) % 5 == 0;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }


}
