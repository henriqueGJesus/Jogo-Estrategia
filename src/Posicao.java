public class Posicao {
  private Unidade unidade;

    public Unidade getUnidade() {
    return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Posicao{" +
                "unidade=" + unidade +
                '}';
    }
}
