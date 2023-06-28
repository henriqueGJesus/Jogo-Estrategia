import java.util.ArrayList;

public class Jogador {
    private String nome = "";
    private  String senha= "";
    private String cor= "";
    private ArrayList<Unidade> listaUnidades;

    public Jogador (String nome, String senha){
        this.nome= nome;
        this.senha= senha;
        this.listaUnidades= new ArrayList<>();
    }

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor=cor;

        for (Posicao posicao:tabuleiro.getListaDePosicaoes()) {
            if(posicao.getUnidade()!=null && posicao.getUnidade().getCor().equals(this.cor)){
                this.listaUnidades.add(posicao.getUnidade());

            };

        }
    }

    private String getCor() {
        return cor;
    }

    public ArrayList<Unidade> getPecas() {
        return listaUnidades;
    }
}
