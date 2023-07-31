import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Posicao> listaDePosicoes = new ArrayList<>();
    public Tabuleiro() {
        for (int i = 0; i < 50; i++) {
            listaDePosicoes.add(new Posicao());
            if (i == 40 || i == 44) {
                listaDePosicoes.get(i).setUnidade(new Brachiosaurus(35, 40, 750, "Vermelho", listaDePosicoes.get(i), "BRAC"));
            }
            if (i == 41 || i == 42 || i == 43) {

                listaDePosicoes.get(i).setUnidade(new Tricerapto(35, 150, 600, "Vermelho", listaDePosicoes.get(i), "TRIC"));

            }
            if (i == 45 || i == 46 || i == 48 || i == 49) {
                listaDePosicoes.get(i).setUnidade(new Velociraptor(70, 25, 250, "Vermelho", listaDePosicoes.get(i), "VELO"));

            }
            if (i == 47) {
                listaDePosicoes.get(i).setUnidade(new Trex(150, 55, 450, "Vermelho", listaDePosicoes.get(i), "TREX"));
            }
            if (i == 5 || i == 9) {
                listaDePosicoes.get(i).setUnidade(new Brachiosaurus(35, 40, 750, "Azul", listaDePosicoes.get(i), "BRAC"));
            }
            if (i == 6 || i == 8 || i == 7) {
                listaDePosicoes.get(i).setUnidade(new Tricerapto(35, 150, 600, "Azul", listaDePosicoes.get(i), "TRIC"));
            }
            if (i == 0 || i == 1 || i == 3 || i == 4) {
                listaDePosicoes.get(i).setUnidade(new Velociraptor(70, 25, 250, "Azul", listaDePosicoes.get(i), "VELO"));
            }
            if (i == 2) {
                listaDePosicoes.get(i).setUnidade(new Trex(150, 55, 450, "Azul", listaDePosicoes.get(i), "TREX"));
            }

        }
    }

    public ArrayList<Posicao> getListaDePosicaoes() {
        return listaDePosicoes;
    }


    public void atualizaTabuleiro(Posicao posicaoAtulizada, Posicao posicaoDeOrigem, Jogador jogador) {
        Unidade unidade = posicaoAtulizada.getUnidade();

        int indicePosicaoAtulizada = listaDePosicoes.indexOf(posicaoAtulizada);
        int indicePosicaoDeOrigem = listaDePosicoes.indexOf(posicaoDeOrigem);


        listaDePosicoes.get(indicePosicaoAtulizada).setUnidade(unidade);
        listaDePosicoes.get(indicePosicaoDeOrigem).setUnidade(null);
        promocao(indicePosicaoAtulizada, unidade, jogador);

    }

    private void promocao(int indicePosicaoAtulizada, Unidade unidade, Jogador jogador) {

        if(jogador.getCor().equals(unidade.getCor())){
            if(unidade.getCor().equals("Vermelho") && indicePosicaoAtulizada>0 && indicePosicaoAtulizada <=4) {
               buffUnidades(jogador);
            }
            if(unidade.getCor().equals("Azul") && indicePosicaoAtulizada>44 && indicePosicaoAtulizada <=49 ){
                buffUnidades(jogador);
            }


        }
    }

    @Override
    public String toString() {
        ArrayList<String> novaLista = new ArrayList<>();

        for (int i = 0; i < listaDePosicoes.size(); i++) {

            if ((i + 1) % 5 == 0) {
                if (listaDePosicoes.get(i).getUnidade() != null) {
                    novaLista.add((listaDePosicoes.get(i).getUnidade().getSimbolo() + "|"));
                    novaLista.add("\n");
                } else {

                    novaLista.add(" "+i+"  ");
                    novaLista.add("\n");
                }

            } else {
                if (listaDePosicoes.get(i).getUnidade() != null) {
                    novaLista.add((listaDePosicoes.get(i).getUnidade().getSimbolo() + "|"));
                } else {

                    novaLista.add(" "+i+"  ");
                }
            }
        }


        System.out.println(novaLista);
        return "";

    }

    public void removerTabuleiro(Unidade unidade, Posicao posicao) {
        int posicaoRemover = listaDePosicoes.indexOf(posicao);
        listaDePosicoes.get(posicaoRemover).setUnidade(null);
    }

    public void buffUnidades(Jogador jogador){

        for (int i = 0; i < jogador.getListaUnidades().size(); i++) {
            Unidade unidadeASerBuffada = jogador.getListaUnidades().get(i);
            unidadeASerBuffada.setDefesa(unidadeASerBuffada.getDefesa() * 2);
            unidadeASerBuffada.setVida(unidadeASerBuffada.getVida() * 2);
            unidadeASerBuffada.setAtaque(unidadeASerBuffada.getAtaque() * 2);
        }

    }

}
