import java.util.ArrayList;

public abstract  class Unidade {
    private double vida;
    private double ataque;
    private double defesa;
    private Posicao posicao;
    private String cor;
    ArrayList<Unidade> listaUnidades = new ArrayList<>();

    public Unidade(double ataque, double defesa, double vida, String cor, Posicao posicao){
        this.ataque=ataque;
        this.defesa=defesa;
        this.vida=vida;
        this.cor=cor;
        this.posicao=posicao;
        listaUnidades.add(this);
    }

 public void movimentar(Tabuleiro tabuleiro){
     ArrayList<Posicao> possiveisMovimentos= new ArrayList<>();
     int posicaoNoTabuleiro= tabuleiro.getListaDePosicaoes().indexOf(this.posicao);
     ArrayList<Posicao> posicaoTabuleiro= tabuleiro.getListaDePosicaoes();

     System.out.println(posicaoNoTabuleiro);

     for (int i = 0; i <50 ; i++) {

         if(this.cor=="Azul") {
             System.out.println("Eita Azul ");
             if (tabuleiro.getListaDePosicaoes().get(i).equals(cor == "Vermelho")) {
                 System.out.println("é vermelho ");
                if(atacar(tabuleiro)){
                    break;
                }
             }
         }
         if(this.cor=="Vermelho") {
             System.out.println("Eita");
             if (tabuleiro.getListaDePosicaoes().get(i).equals(cor == "Azul")) {
                 if(atacar(tabuleiro)){
                     break;
                 }
             }
         }

            if(posicaoTabuleiro.get(posicaoNoTabuleiro+5).getUnidade()==null &&posicaoTabuleiro.get(posicaoNoTabuleiro+5).getUnidade().getCor().equals("Vermelho") ){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro-5).getUnidade()==null && posicaoTabuleiro.get(posicaoNoTabuleiro+5).getUnidade().getCor().equals("Azul")){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro+4).getUnidade()==null && posicaoTabuleiro.get(posicaoNoTabuleiro+5).getUnidade().getCor().equals("Vermelho")){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro-4).getUnidade()==null && posicaoTabuleiro.get(posicaoNoTabuleiro+5).getUnidade().getCor().equals("Azul")){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro+6).getUnidade()==null && posicaoTabuleiro.get(posicaoNoTabuleiro+5).getUnidade().getCor().equals("Vermelho")){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }
            if(posicaoTabuleiro.get(posicaoNoTabuleiro-6).getUnidade()==null && posicaoTabuleiro.get(posicaoNoTabuleiro+5).getUnidade().getCor().equals("Azul")){
                possiveisMovimentos.add(tabuleiro.getListaDePosicaoes().get(i));
            }


        }
     //gsfdgsdgsdg

     }

 public abstract boolean atacar(Tabuleiro tabuleiro);

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

    public double getAtaque() {
        return ataque;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Unidade" + this.getClass();

    }

}
