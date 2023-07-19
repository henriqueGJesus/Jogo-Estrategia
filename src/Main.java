import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Jogador jogador1 = new Jogador("Romario", "123");
    static Jogador jogador2 = new Jogador("Roberto", "123");
    static Tabuleiro tabuleiro = new Tabuleiro();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Jogador.listaJogadores.add(jogador1);
        Jogador.listaJogadores.add(jogador2);
        login();

    }

    private static void login() {
        String senha = "";
        String nome = "";
        System.out.println("Digite sua senha: ");
        senha = sc.next();

        System.out.println("Digite seu nome: ");
        nome = sc.next();
        if (jogador1.verficaLogin(senha, nome) || jogador2.verficaLogin(senha, nome)) {
            comecaJogo();
        }
    }

    private static void comecaJogo() {
        int i = 0;
        do {
            if (jogador1.setCor(tabuleiro).equals("Azul") && i % 2 == 0) {
                i++;
                System.out.println("O " + jogador1.getNome() + " Começa Jogando");
                jogar(jogador1);
            } else if (jogador2.setCor(tabuleiro).equals("Vermelho") && i % 2 == 1) {
                i++;
                System.out.println("O " + jogador2.getNome() + " Começa Jogando");
                jogar(jogador2);
            }
        } while (!Jogador.acabaJogo());

    }


    private static void jogar(Jogador jogadorLogado) {

        System.out.println(tabuleiro);
        System.out.println("Escolha a peça que deseja jogar: " + jogadorLogado.getPecas());
        int escolha = sc.nextInt();

        Unidade unidade = jogadorLogado.getPecas().get(escolha);
        System.out.println(unidade);

        unidade.PossiveisMovimentos(tabuleiro);
        Posicao posicaoUnidadeEscolhida = unidade.getPosicao();

        System.out.println("Escolha a posição do movimento: " + unidade.possiveisMovimentos);
        int escolhaJogada = sc.nextInt();

        Posicao posicaoDaJogada = unidade.possiveisMovimentos.get(escolhaJogada);

        unidade.movimentar(posicaoDaJogada, posicaoUnidadeEscolhida);

        unidade.atualizaTabuleiro(tabuleiro, posicaoUnidadeEscolhida);

        System.out.println(tabuleiro);
        System.out.println(jogadorLogado.getCor());

        if (unidade.atacar(tabuleiro,jogadorLogado,posicaoUnidadeEscolhida)) {
            System.out.println("Voce deu " + unidade.getAtaque() + " De dano no personagem inimigo");
        }


    }


}

