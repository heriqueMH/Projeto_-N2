public class Avaliacao {
  private int pontuacao;
  private String comentario;

  public Avaliacao(int pontuacao, String comentario) {
    this.pontuacao = pontuacao;
    this.comentario = comentario;
  }

  public int getPontuacao() {
    return pontuacao;
  }

  public void setPontuacao(int pontuacao) {
    this.pontuacao = pontuacao;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }
}
