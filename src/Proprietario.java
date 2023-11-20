import java.util.ArrayList;
import java.util.List;

public class Proprietario extends Usuario {
  private List<Propriedade> propriedades;

  public Proprietario(String nome,String cpf, String email, String endereco, String senha) {
    super(nome, cpf, email, endereco, senha);
    this.propriedades = new ArrayList<>();
  }

  public void cadastrarPropriedade(Propriedade propriedade) {
    propriedades.add(propriedade);
  }

  public List<Propriedade> getPropriedades() {
    return propriedades;
  }

  @Override
    public void exibirMenu() {
        System.out.println("----- MENU DO PROPRIETÁRIO -----");
        // Opções específicas para proprietários
    }
}