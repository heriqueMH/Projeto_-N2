import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospede extends Usuario {
  private List<Reserva> reservas;

    public Hospede(String nome, String cpf, String email, String endereco, String senha) {
        super(nome, cpf, email, endereco, senha);
        this.reservas = new ArrayList<>();
    }

    public void reservarPropriedade(Propriedade propriedade, Reserva reserva) {
      reservas.add(reserva);
  }

    public List<Reserva> getReservas() {
      return reservas;
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

  @Override
  public void exibirMenu() {
    System.out.println("----- MENU DO HÓSPEDE -----");
  
  }
}


