public class Apartamento extends Propriedade{
  private boolean possuiElevador;

    public Apartamento(String titulo, String descricao, String localizacao, int capacidade, double precoPorNoite, boolean possuiElevador) {
        super(titulo, descricao, localizacao, capacidade, precoPorNoite);
        this.possuiElevador = possuiElevador;
    }

    public boolean isPossuiElevador() {
        return possuiElevador;
    }

    public void setPossuiElevador(boolean possuiElevador) {
        this.possuiElevador = possuiElevador;
    }
}
