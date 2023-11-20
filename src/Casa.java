public class Casa extends Propriedade{
  private int numeroDeQuartos;

    public Casa(String titulo, String descricao, String localizacao, int capacidade, double precoPorNoite, int numeroDeQuartos) {
        super(titulo, descricao, localizacao, capacidade, precoPorNoite);
        this.numeroDeQuartos = numeroDeQuartos;
    }

    public int getNumeroDeQuartos() {
        return numeroDeQuartos;
    }

    public void setNumeroDeQuartos(int numeroDeQuartos) {
        this.numeroDeQuartos = numeroDeQuartos;
    }
}
