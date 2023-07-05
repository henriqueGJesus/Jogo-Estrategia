import java.util.ArrayList;
import java.util.Random;

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

    public boolean setCor(Tabuleiro tabuleiro) {
        Random gerador = new Random();
        this.cor="Azul";
           if(gerador.nextInt(2)==1){
               this.cor="Azul";
           }else{
               this.cor="Vermelho";
           }
        for (Posicao posicao:tabuleiro.getListaDePosicaoes()) {
            if(posicao.getUnidade()!=null && posicao.getUnidade().getCor().equals(this.cor)){
                this.listaUnidades.add(posicao.getUnidade());

            }

        }


        return false;
    }

    private String getCor() {
        return cor;
    }

    public ArrayList<Unidade> getPecas() {
        return listaUnidades;
    }
}
