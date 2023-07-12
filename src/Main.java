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

    private static void jogar(Jogador jogadorLogado, Jogador jogadorAdversario) {
        System.out.println(tabuleiro.getListaDePosicaoes());
        System.out.println("Escolha a peça que desja jogar: "+ jogadorLogado.getPecas());
        int escolha= sc.nextInt();
        Unidade unidade= jogadorLogado.getPecas().get(escolha);
        System.out.println("Escolha a posição do movimento: "+unidade);
        unidade.movimentar(tabuleiro);

    }


}

