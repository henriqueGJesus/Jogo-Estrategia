import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Posicao> listaDePosicoes = new ArrayList<>();

    public Tabuleiro(){
        for (int i = 0; i < 50; i++) {
           listaDePosicoes.add(new Posicao());
            if(i==41 || i==45) {
                listaDePosicoes.get(i).setUnidade(new Brachiosaurus(35, 55, 500, "Vermelho"));
            }
            if(i<=42 & i>=44){
                listaDePosicoes.get(i).setUnidade(new Tricerapto(35, 150, 600, "Vermelho"));
            }
            if(i==46 || i==47 || i==49 || i==50){
                listaDePosicoes.get(i).setUnidade(new Velociraptor(70, 25, 250, "Vermelho"));
            }
            if(i==58){
                listaDePosicoes.get(i).setUnidade(new Trex(150, 55, 450, "Vermelho"));
            }
            if(i==6 || i==10) {
                listaDePosicoes.get(i).setUnidade(new Brachiosaurus(35, 55, 500, "Azul"));
            }
            if(i<=7 & i>=9){
                listaDePosicoes.get(i).setUnidade(new Tricerapto(35, 150, 600, "Azul"));
            }
            if(i==1 || i==2 || i==4 || i==5){
                listaDePosicoes.get(i).setUnidade(new Velociraptor(70, 25, 250, "Azul"));
            }
            if(i==3){
                listaDePosicoes.get(i).setUnidade(new Trex(150, 55, 450, "Azul"));
            }

        }
    }
    public void removerPeca(Posicao posicao){

    }

    public ArrayList<Posicao> getListaDePosicaoes() {
        return listaDePosicoes;
    }

    @Override
    public String toString() {
        return "Tabuleiro{" +
                "listaDePosicoes=" + listaDePosicoes +
                '}';
    }
}
