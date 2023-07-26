import java.util.ArrayList;
import java.util.Random;

public class Jogador {
    private String nome = "";
    private String senha = "";
    private String cor = "";
    private ArrayList<Unidade> listaUnidades;
    static ArrayList<Jogador> listaJogadores = new ArrayList<>();

    public Jogador(String nome) {
        this.nome = nome;
        this.listaUnidades = new ArrayList<>();


    }

    public static boolean acabaJogo() {
        if (listaJogadores.get(0).listaUnidades == null || listaJogadores.get(1).listaUnidades == null) {
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
                if (gerador.nextInt(2) == 1) {
                    listaJogadores.get(0).cor="Azul";
                    listaJogadores.get(1).cor="Vermelho";
                } else{
                    listaJogadores.get(1).cor="Azul";
                    listaJogadores.get(0).cor="Vermelho";
                }

        return this.cor;
    }

    public String getCor(Tabuleiro tabuleiro) {
        listaUnidades.clear();
        for (Posicao posicao : tabuleiro.getListaDePosicaoes()) {
            if (posicao.getUnidade() != null && posicao.getUnidade().getCor().equals(this.cor)) {
                this.listaUnidades.add(posicao.getUnidade());

            }
        }
        return cor;
    }

    public ArrayList<Unidade> getPecas() {
        return listaUnidades;
    }

    public String getNome() {
        return nome;
    }

    public  ArrayList<String> toStringListaunidades() {
        ArrayList<String> listaSimboloUnidades = new ArrayList<>();
        for (int i = 0; i < listaUnidades.size(); i++) {
           listaSimboloUnidades.add(""+i +"- "+ listaUnidades.get(i).getSimbolo()
                   );
        }
       return listaSimboloUnidades;
    }
}
