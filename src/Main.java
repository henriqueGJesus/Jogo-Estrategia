import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Tabuleiro tabuleiro = new Tabuleiro();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Jogador> listaJogadores = new ArrayList<>();

    public static void main(String[] args) {
        cadastro();
        comecaJogo();
    }

    private static void cadastro() {
        String nomeJogador1 = "";
        String nomeJogador2 = "";

        System.out.println("Cadastre o nickname do primeiro Jogador:");
        nomeJogador1 = sc.next();

        System.out.println("Cadastre o nickname do segundo Jogador:");
        nomeJogador2 = sc.next();

        listaJogadores.add(new Jogador(nomeJogador1));
        listaJogadores.add(new Jogador(nomeJogador2));


    }

    private static void comecaJogo() {
        int i = 0;
        listaJogadores.get(0).setCor();
        if (listaJogadores.get(1).getCor().equals("Azul")) {
            i = 1;
        }

        System.out.println(listaJogadores.get(0).copularListaUnidades(tabuleiro));
        System.out.println(listaJogadores.get(1).copularListaUnidades(tabuleiro));
        Jogador jogador = listaJogadores.get(i % 2);
        do {
            System.out.println("O " + jogador.getNome() + " Joga agora");
            jogar(jogador);
            i++;
        } while (!Jogador.acabaJogo());


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
        if (unidade.atacar(tabuleiro, jogadorLogado, posicaoUnidadeEscolhida)) {
            System.out.println("Voce deu " + unidade.getAtaque() + " De dano no personagem inimigo");
        }


    }


}

