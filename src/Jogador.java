import java.util.ArrayList;
import java.util.Random;

public class Jogador {
    //gsfdgsdgsdg
    private String nome = "";
    private String senha = "";
    private String cor = "";
    private ArrayList<Unidade> listaUnidades;
    static ArrayList<Jogador> listaJogadores =new ArrayList<>();

    public Jogador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.listaUnidades = new ArrayList<>();


    }

    public static boolean acabaJogo() {
        if(listaJogadores.get(0).listaUnidades==null || listaJogadores.get(1).listaUnidades==null ){
            return true;
        }

        return false;
    }

    public void removeUnidade(Unidade adversario, Tabuleiro tabuleiro) {
        this.listaUnidades.remove(adversario);
        tabuleiro.removerTabuleiro(adversario);
    }

    public String setCor(Tabuleiro tabuleiro) {
        Random gerador = new Random();



        for (Jogador jogador : listaJogadores) {

            if (gerador.nextInt(2) == 1 & !jogador.cor.equals("Azul")) {
                this.cor = "Azul";
            } else {
                 this.cor = "Vermelho";
            }
        }
        for (Posicao posicao : tabuleiro.getListaDePosicaoes()) {


            if (posicao.getUnidade() != null && posicao.getUnidade().getCor().equals(this.cor)) {
                this.listaUnidades.add(posicao.getUnidade());

            }
        }



        return this.cor;
    }

    private String getCor() {
        return cor;
    }

    public ArrayList<Unidade> getPecas() {
        return listaUnidades;
    }

    public boolean verficaLogin(String senha, String nome) {

        for (Jogador jogador: listaJogadores) {
            if(jogador.senha.equals(senha) & jogador.nome.equals(nome)){
                return true;
            }

        }
        return false;
    }

    public String getNome() {
        return nome;
    }
}
