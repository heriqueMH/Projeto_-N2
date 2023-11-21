import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospede extends Usuario {
  private List<Reserva> reservas;
  private Scanner scanner;

  public Hospede(String nome, String cpf, String email, String endereco, String senha) {
    super(nome, cpf, email, endereco, senha);
    this.reservas = new ArrayList<>();
    this.scanner = new Scanner(System.in);
  }

  public void cadastrarNovaReserva() {
    System.out.println("----- CADASTRAR NOVA RESERVA -----");
    System.out.println("1. Buscar Propriedade");
    System.out.println("2. Lista Propriedades");
    System.out.println("3. Sair do Programa");
    System.out.print("Escolha uma opção: ");
    int opcaoSubMenu = scanner.nextInt();
    switch (opcaoSubMenu) {
        case 1:
            System.out.println("Digite o Id da propriedade.");
            int idEscolhido = scanner.nextInt();
            setPropriedade(idEscolhido);
            break;
        case 2:
            GerenciadorPropriedades.exibirTodasPropriedades();
            System.out.println("");
            System.out.println("Digite o ID da propriedade desejada");
            int id = scanner.nextInt();
            setPropriedade(id);
            break;
        case 3:
            break;
        default:
            System.out.println("Opção inválida.");
            break;
    }
  }

  public void setPropriedade(int id){
    Propriedade propriedadeEscolhida = GerenciadorPropriedades.getPropriedadeId(id);
    Reserva novaReservaLista = new Reserva(propriedadeEscolhida, this);
    reservas.add(novaReservaLista);
    System.out.println("Reserva cadastrada com sucesso.");
  }

  public void excluirReserva(int numeroReserva) {
    Reserva reservaParaExcluir = null;
    for (Reserva reserva : reservas) {
        if (reserva.getReserva() == numeroReserva) {
            reservaParaExcluir = reserva;
            break;
        }
    }

    if (reservaParaExcluir != null) {
        reservas.remove(reservaParaExcluir);
        System.out.println("Reserva excluída com sucesso.");
    } else {
        System.out.println("Reserva não encontrada.");
    }
  }

  public Reserva getReserva(int numeroReserva) {
    for (Reserva reserva : reservas) {
        if (reserva.getReserva() == numeroReserva) {
            return reserva;
        }
    }
    return null;
  }

  public void consultarReservas() {
    if (reservas.isEmpty()) {
      System.out.println("Você não possui reservas.");
    } else {
      System.out.println("----- SUAS RESERVAS -----");
      for (Reserva reserva : reservas) {
        System.out.println("Número da reserva: " + reserva.getReserva());
        // Exibir outras informações relevantes da reserva
      }
    }
  }

  public void avaliarPropriedade(Reserva reserva, Avaliacao avaliacao) {
    if (reserva.estadiaConcluida()) {
      reserva.getPropriedade().receberAvaliacao(avaliacao);
    } else {
      System.out.println("Avaliação disponível somente após o término da estadia.");
    }
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

    cadastrarNovoUsuario(cadastrarHospede(nome, cpf, email, endereco, senha));

    scanner.close();
  }

  public static Usuario cadastrarHospede(String nome, String cpf, String email, String endereco, String senha) {
    Usuario novoProprietario = new Proprietario(nome, cpf, email, endereco, senha);
    return novoProprietario;
  }

  public void excluirReserva(Reserva reserva, String senha) {

    System.out.print("Digite a senha para confirmar a exclusão da reserva: ");
    String senhaDigitada = scanner.nextLine();

    if (senha.equals(senhaDigitada)) {
      if (reservas.contains(reserva)) {
        reservas.remove(reserva);
        System.out.println("Reserva excluída com sucesso.");
      } else {
        System.out.println("Reserva não encontrada.");
      }
    } else {
     System.out.println("Senha incorreta. A exclusão da reserva não foi realizada.");
    }
  }

  @Override
  public void exibirMenu() {
    System.out.println("");
    System.out.println("----- MENU DO HÓSPEDE -----");
    System.out.println("1. Consultar Reservas");
    System.out.println("2. Cadastrar Nova Reserva");
    System.out.println("3. Excluir Reserva");
    System.out.println("4. Sair do programa");
  
    int opcaoMenu = scanner.nextInt();
    switch (opcaoMenu) {
      case 1:
        consultarReservas();
        break;
      case 2:
        cadastrarNovaReserva();
        break;
      case 3:
        System.out.print("Digite o número da reserva a ser excluída: ");
        int numReserva = scanner.nextInt();
        excluirReserva(numReserva);
        break;
      case 4:
        System.out.println("Saindo do programa...");
        break;
      default:
        System.out.println("Opção inválida.");
        break;
      }
  }
}



