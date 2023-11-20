import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
  private String nome;
  private String cpf;
  private String email;
  private String endereco;
  private String senha;
  private static List<Usuario> usuariosCadastrados = new ArrayList<>();

  public Usuario(String nome, String cpf, String email, String endereco, String senha) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.endereco = endereco;
    this.senha = senha;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  private String getSenha() {
    return this.senha;
  }

  public static void cadastrarNovoUsuario(Usuario novoUsuario) {
    usuariosCadastrados.add(novoUsuario);
    System.out.println("Usuário cadastrado com sucesso.");
  }

  public static Usuario buscarUsuario(String nome, String senha) {
    for (Usuario usuario : usuariosCadastrados) {
        if (usuario.getNome().equalsIgnoreCase(nome) && usuario.getSenha().equals(senha)) {
            return usuario;
        }
    }
    return null;
  }

  public static void excluirUsuario(String nome) {
    for (Usuario usuario : usuariosCadastrados) {
        if (usuario.getNome().equals(nome)) {
          usuariosCadastrados.remove(usuario);
          System.out.println("Usuário removido com sucesso.");
          return;
        }
    }
    System.out.println("Usuário não encontrado.");
  }

  public boolean senhaValida(String senha) {
    return this.senha.equals(senha);
  }

   public abstract void exibirMenu();
}


