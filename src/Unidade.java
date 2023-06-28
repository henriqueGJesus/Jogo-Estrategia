import java.util.ArrayList;

public abstract  class Unidade {
    private double vida;
    private double ataque;
    private double defesa;
    private Posicao posicao;
    private String cor;
    ArrayList<Unidade> listaUnidades = new ArrayList<>();

    public Unidade(double ataque, double defesa, double vida, String cor){
        this.ataque=ataque;
        this.defesa=defesa;
        this.vida=vida;
        listaUnidades.add(this);
    }

 private void movimentar(Tabuleiro tabuleiro, Unidade adversario){
     ArrayList<Posicao> possiveisMovimentos= new ArrayList<>();
     int posicaoNoTabuleiro= tabuleiro.getListaDePosicaoes().indexOf(this);
     ArrayList<Posicao> posicaoTabuleiro= tabuleiro.getListaDePosicaoes();



     for (int i = 0; i <50 ; i++) {
         if(this.cor=="Azul") {
             if (tabuleiro.getListaDePosicaoes().get(i).equals(cor == "Vermelho")) {
                 atacar(adversario,tabuleiro);
             }
         }
         if(this.cor=="Vermelho") {
             if (tabuleiro.getListaDePosicaoes().get(i).equals(cor == "Azul")) {
                 atacar(adversario,tabuleiro);
             }
         }

            if(posicaoTabuleiro.get(posicaoNoTabuleiro+5).getUnidade()==null){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro-5).getUnidade()==null){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro+4).getUnidade()==null){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro-4).getUnidade()==null){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro+6).getUnidade()==null){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro-6).getUnidade()==null){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }


        }

     }

 public abstract boolean atacar(Unidade adversario, Tabuleiro tabuleiro);

    public String getCor() {
        return cor;
    }

    public double getVida() {
        return vida;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }
}
