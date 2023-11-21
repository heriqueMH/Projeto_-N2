import java.util.List;
import java.util.Scanner;

public class Proprietario extends Usuario {

  public Proprietario(String nome,String cpf, String email, String endereco, String senha) {
    super(nome, cpf, email, endereco, senha);
  }

  public void cadastrarNovaPropriedade(Propriedade propriedade) {
    GerenciadorPropriedades gerenciador = GerenciadorPropriedades.getInstance();
    gerenciador.cadastrarPropriedade(propriedade, this);
  }

  public void exibirPropriedades() {
    GerenciadorPropriedades gerenciador = GerenciadorPropriedades.getInstance();
    List<Propriedade> minhasPropriedades = gerenciador.getPropriedadesPorProprietario(this);

    if (minhasPropriedades.isEmpty()) {
        System.out.println("Você não possui propriedades cadastradas.");
    } else {
        System.out.println("----- SUAS PROPRIEDADES -----");
        for (Propriedade propriedade : minhasPropriedades) {
            System.out.println("ID: " + propriedade.getId());
            System.out.println("Título: " + propriedade.getTitulo());
            System.out.println("Descrição: " + propriedade.getDescricao());
            // Adicione outros atributos relevantes para exibição
            System.out.println("------------------------------");
        }
    }
  }

  public static void menuDeCadastro() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome do proprietário: ");
    scanner.nextLine();
    String nome = scanner.next();
    System.out.print("Digite a senha do proprietário: ");
    scanner.nextLine();
    String senha = scanner.next();
    System.out.print("Digite o CPF do proprietário: ");
    scanner.nextLine();
    String cpf = scanner.next();
    scanner.nextLine();
    System.out.print("Digite o email do proprietário: ");
    String email = scanner.next();
    scanner.nextLine();
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
      System.out.println("");
      System.out.println("----- MENU DO PROPRIETÁRIO -----");
      System.out.println("1. Consultar uma Propriedades");
      System.out.println("2. Cadastrar nova Propriedade");
      System.out.println("3. Excluir uma Propriedade");
      System.out.println("4. Sair do programa");
    }
}