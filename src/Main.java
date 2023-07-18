import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Jogador jogador1= new Jogador("Romario","123");
   static Jogador jogador2= new Jogador("Roberto","123");
   static Tabuleiro tabuleiro = new Tabuleiro();
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Jogador.listaJogadores.add(jogador1);
        Jogador.listaJogadores.add(jogador2);
        login();

    }

    private static void login() {
        String senha="";
        String nome="";
        System.out.println("Digite sua senha: ");
        senha=sc.next();

        System.out.println("Digite seu nome: ");
        nome=sc.next();
        if (jogador1.verficaLogin(senha, nome) || jogador2.verficaLogin(senha,nome)) {
            comecaJogo();
        }
    }

    private static void comecaJogo() {
        if(jogador1.setCor(tabuleiro).equals("Azul")){
            System.out.println("O "+jogador1.getNome()+" Começa Jogando");
            jogar(jogador1,jogador2);
        }else{
            jogador2.setCor(tabuleiro);
            System.out.println("O "+jogador2.getNome()+" Começa Jogando");
            jogar(jogador2,jogador1);
        }

    }
    //gsfdgsdgsdg
    private static void jogar(Jogador jogadorLogado, Jogador jogadorAdversario) {

        if(!Jogador.acabaJogo()) {
            System.out.println(tabuleiro);

            System.out.println("Escolha a peça que desja jogar: " + jogadorLogado.getPecas());
            int escolha = sc.nextInt();

            Unidade unidade = jogadorLogado.getPecas().get(escolha);
            unidade.PossiveisMovimentos(tabuleiro);
            Posicao posicaoUnidadeEscolhida = unidade.getPosicao();
            System.out.println("Escolha a posição do movimento: " + unidade.possiveisMovimentos);
            int escolhaJogada = sc.nextInt();

            Posicao posicaoDaJogada = Unidade.possiveisMovimentos.get(escolhaJogada);

            unidade.movimentar(posicaoDaJogada, posicaoUnidadeEscolhida);

            unidade.atualizaTabuleiro(tabuleiro, posicaoUnidadeEscolhida);

            System.out.println(tabuleiro);

            System.out.println(tabuleiro);

            if (unidade.atacar(tabuleiro,jogadorLogado)) {
                System.out.println("Voce deu " + unidade.getAtaque() + " De dano no personagem inimigo");
            }


            //Jogada Adversaria.
            System.out.println("Escolha a peça que desja jogar: " + jogadorAdversario.getPecas());
            int escolha2 = sc.nextInt();

            Unidade unidade2 = jogadorAdversario.getPecas().get(escolha2);
            unidade2.PossiveisMovimentos(tabuleiro);
            Posicao posicaoUnidadeEscolhida2 = unidade2.getPosicao();
            System.out.println("Escolha a posição do movimento: " + unidade2.possiveisMovimentos);
            int escolhaJogada2 = sc.nextInt();

            Posicao posicaoDaJogada2 = Unidade.possiveisMovimentos.get(escolhaJogada2);

            unidade2.movimentar(posicaoDaJogada2, posicaoUnidadeEscolhida2);

            unidade2.atualizaTabuleiro(tabuleiro, posicaoUnidadeEscolhida2);

            System.out.println(tabuleiro);
            if (unidade2.atacar(tabuleiro,jogadorAdversario)) {
                System.out.println("Voce deu " + unidade2.getAtaque() + " De dano no personagem inimigo");
            }
        }




    }


}

