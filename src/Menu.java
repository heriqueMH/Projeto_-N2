import java.util.Scanner;

class Menu {
  private Scanner scanner;

  public Menu() {
    this.scanner = new Scanner(System.in);
  }

  public void exibirMenu() {
    int opcaoMenu = 0;
    do {
      System.out.println("----- MENU -----");
      System.out.println("1. Usuário já cadastrado");
      System.out.println("2. Cadastrar novo usuário");
      System.out.println("3. Excluir usuário");
      System.out.println("4. Sair do programa");
      System.out.print("Escolha uma opção: ");
      opcaoMenu = scanner.nextInt();
      switch (opcaoMenu) {
          case 1:
            autenticarUsuario();
            break;
          case 2:
            exibirSubMenuCadastro();
            break;
          case 3:
            excluirUsuario();
            break;
      }
    } while (opcaoMenu != 4);
  }

  private void autenticarUsuario() {
    System.out.print("Digite o nome do usuário: ");
    String nome = scanner.next();
    System.out.print("Digite a senha do usuário: ");
    String senha = scanner.next();

    Usuario usuarioAutenticado = Usuario.buscarUsuario(nome, senha);
    if (usuarioAutenticado != null) {
        System.out.println("Usuário autenticado! Bem-vindo, " + usuarioAutenticado.getNome() + ".");
    } else {
        System.out.println("Usuário ou senha incorretos.");
    }
  }


  private void exibirSubMenuCadastro() {
    System.out.println("----- SUBMENU DE CADASTRO -----");
    System.out.println("1. Cadastrar Hóspede");
    System.out.println("2. Cadastrar Proprietário");
    System.out.print("Escolha uma opção: ");
    int opcaoSubMenu = scanner.nextInt();

    switch (opcaoSubMenu) {
      case 1:
        Hospede.menuDeCadastro();
        break;
      case 2:
        Proprietario.menuDeCadastro();
        break;
      default:
        System.out.println("Opção inválida.");
        break;
    }
  }

  private void excluirUsuario() {
    System.out.print("Digite o nome do usuário a ser excluído: ");
    String nome = scanner.next();
    Usuario.excluirUsuario(nome);
  }

}