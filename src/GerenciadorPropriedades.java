import java.util.ArrayList;
import java.util.List;

public class GerenciadorPropriedades {
  private static GerenciadorPropriedades instancia = null;
  private static List<Propriedade> propriedades;
  private int proximoId;

  private GerenciadorPropriedades() {
    this.proximoId = 1;
  }

  public static GerenciadorPropriedades getInstance() {
    if (instancia == null) {
      instancia = new GerenciadorPropriedades();
    }
    return instancia;
  }

  public void cadastrarPropriedade(Propriedade propriedade, Proprietario proprietario) {
    propriedade.setId(proximoId++);
    propriedade.setProprietario(proprietario);
    propriedades.add(propriedade);
    System.out.println("Propriedade cadastrada com sucesso!");
  }

  public static Propriedade getPropriedadeId(int id) {
    for (Propriedade propriedade : propriedades) {
      if (propriedade.getId() == id) {
        return propriedade;
      }
    }
    return null;
  }

  public static void exibirTodasPropriedades() {
    System.out.println("----- LISTA DE PROPRIEDADES -----");
    for (Propriedade propriedade : propriedades) {
      System.out.println("ID: " + propriedade.getId());
      System.out.println("Título: " + propriedade.getTitulo());
      System.out.println("Descrição: " + propriedade.getDescricao());
      System.out.println("Localização: " + propriedade.getLocalizacao());
      System.out.println("Capacidade: " + propriedade.getCapacidade());
      System.out.println("Preço por Noite: " + propriedade.getPrecoPorNoite());
      // Exibir outras informações relevantes da propriedade, se houver
      System.out.println("---------------------------------");
    }
  }
    
  public List<Propriedade> getPropriedadesPorProprietario(Proprietario proprietario) {
    List<Propriedade> propriedadesDoProprietario = new ArrayList<>();
    for (Propriedade propriedade : propriedades) {
      if (proprietario.equals(propriedade.getProprietario())) {
        propriedadesDoProprietario.add(propriedade);
      }
    }
    return propriedadesDoProprietario;
  }
}