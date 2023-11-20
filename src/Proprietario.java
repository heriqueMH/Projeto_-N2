import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

  public static void menuDeCadastro() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome do proprietário: ");
    String nome = scanner.next();
    System.out.print("Digite a senha do proprietário: ");
    String senha = scanner.next();
    System.out.print("Digite o CPF do proprietário: ");
    String cpf = scanner.next();
    System.out.print("Digite o email do proprietário: ");
    String email = scanner.next();
    System.out.print("Digite o endereço do proprietário: ");
    String endereco = scanner.next();

    cadastrarNovoUsuario(cadastrarProprietario(nome, cpf, email, endereco, senha));

    scanner.close();

  }

  public static Usuario cadastrarProprietario(String nome, String cpf, String email, String endereco, String senha) {
    Usuario novoProprietario = new Proprietario(nome, cpf, email, endereco, senha);
    return novoProprietario;
  }

  @Override
    public void exibirMenu() {
        System.out.println("----- MENU DO PROPRIETÁRIO -----");
        // Opções específicas para proprietários
    }
}