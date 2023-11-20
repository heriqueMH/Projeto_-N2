import java.util.ArrayList;
import java.util.List;

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

  public 

  @Override
  public void exibirMenu() {
    System.out.println("----- MENU DO HÓSPEDE -----");
  
  }
}


