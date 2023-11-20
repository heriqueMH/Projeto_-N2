import java.util.ArrayList;
import java.util.List;

public class Propriedade{
  private String titulo;
  private String descricao;
  private String localizacao;
  private int capacidade;
  private double precoPorNoite;
  private List<String> fotos;
  private List<Avaliacao> avaliacoes;

  public Propriedade(String titulo, String descricao, String localizacao, int capacidade, double precoPorNoite) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.localizacao = localizacao;
    this.capacidade = capacidade;
    this.precoPorNoite = precoPorNoite;
    this.fotos = new ArrayList<>();
    this.avaliacoes = new ArrayList<>();
  }

  public void receberAvaliacao(Avaliacao avaliacao) {
    avaliacoes.add(avaliacao);
  }

  public double calcularCustoTotal(int quantidadeDias) {
    return quantidadeDias * precoPorNoite;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getLocalizacao() {
    return this.localizacao;
  }

  public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public int getCapacidade() {
    return this.capacidade;
  }

  public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
  }

  public double getPrecoPorNoite() {
    return this.precoPorNoite;
  }

  public void setPrecoPorNoite(double precoPorNoite) {
    this.precoPorNoite = precoPorNoite;
  }

  public List<String> getFotos() {
    return this.fotos;
  }

  public void setFotos(List<String> fotos) {
    this.fotos = fotos;
  }

  public List<Avaliacao> getAvaliacoes() {
    return this.avaliacoes;
  }

  public void setAvaliacoes(List<Avaliacao> avaliacoes) {
    this.avaliacoes = avaliacoes;
  }

}

