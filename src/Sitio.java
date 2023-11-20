public class Sitio extends Propriedade {
    private double areaTotal;

    public Sitio(String titulo, String descricao, String localizacao, int capacidade, double precoPorNoite, double areaTotal) {
        super(titulo, descricao, localizacao, capacidade, precoPorNoite);
        this.areaTotal = areaTotal;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }
}
