import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Tabuleiro tabuleiro = new Tabuleiro();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cadastro();

    }

    private static void cadastro() {
        String nomeJogador1="";
        String nomeJogador2="";

        System.out.println("Cadastre o nickname do primeiro Jogador:");
        nomeJogador1=sc.next();

        System.out.println("Cadastre o nickname do segundo Jogador:");
        nomeJogador2=sc.next();

        Jogador jogador1 = new Jogador(nomeJogador1);
        Jogador jogador2 = new Jogador(nomeJogador2);
        Jogador.listaJogadores.add(jogador1);
        Jogador.listaJogadores.add(jogador2);
        comecaJogo(jogador1,jogador2);
    }

    private static void comecaJogo(Jogador jogador1, Jogador jogador2) {
        int i = 0;
        jogador1.setCor();
        System.out.println(jogador1.copularListaUnidades(tabuleiro));
        System.out.println(jogador2.copularListaUnidades(tabuleiro));
            do {
                if(i % 2 == 0 ){
                if (jogador1.getCor().equals("Azul")) {
                    i++;
                    System.out.println("O " + jogador1.getNome() + " Joga agora");
                    jogar(jogador1);
                }else if(jogador2.getCor().equals("Azul")){
                    i++;
                    System.out.println("O " + jogador2.getNome() + " Joga agora");
                    jogar(jogador2);
                }
                } else if (i % 2 == 1) {
                    if(jogador2.getCor().equals("Vermelho")) {
                        i++;
                        System.out.println("O " + jogador2.getNome() + " Joga agora");
                        jogar(jogador2);
                    } else if (jogador1.getCor().equals("Vermelho")) {
                        i++;
                        System.out.println("O " + jogador1.getNome() + " Joga agora");
                        jogar(jogador1);
                    }
                }
            }while(!Jogador.acabaJogo());


    }


    private static void jogar(Jogador jogadorLogado) {
        System.out.println(tabuleiro);
        System.out.println("Escolha a peça que deseja jogar: " + jogadorLogado.toStringListaunidades());
        int escolha = sc.nextInt();

        Unidade unidade = jogadorLogado.getPecas().get(escolha);
        Posicao posicaoUnidadeEscolhida = unidade.getPosicao();

        System.out.println("Escolha a posição do movimento: " + unidade.toStringPossiveisMovimentos(tabuleiro));
        int escolhaJogada = sc.nextInt();

        Posicao posicaoDaJogada = unidade.possiveisMovimentos.get(escolhaJogada);

        unidade.movimentar(posicaoDaJogada, posicaoUnidadeEscolhida, tabuleiro, jogadorLogado);

        System.out.println(tabuleiro);
        System.out.println(jogadorLogado.getCor());
        if (unidade.atacar(tabuleiro,jogadorLogado,posicaoUnidadeEscolhida)) {
            System.out.println("Voce deu " + unidade.getAtaque() + " De dano no personagem inimigo");
        }


    }


}

