import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import service.Desserializador;
import service.LeitorDeArquivos;

public class App {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("src/DadosClientes.txt");

        Stream<String> dados = LeitorDeArquivos.readPorLinha(path);

        System.out.println("Lista de clientes que não possuem empréstimo:");

        dados
            .parallel()
            .map(dado -> Desserializador.criarCliente(dado))
            .filter(cliente -> !cliente.isPossuiEmprestimo())
            .forEach(System.out::println);
    }        
}
