import java.util.Comparator;
import java.util.List;

// Listar todas as pessoas
// Listar as 10 primeiras pessoas
// Listar as pessoas que são do Brasil
// Listar as pessoas do Brasil com o nome em Uppercase e suas idades
// Listar as pessoas que são do Brasil, em ordem de nome
// Listar as pessoas que são do Brasil, em ordem de idade
// Contar quantas pessoas tem mais de 45 anos
// Calcular a média de idade das pessoas


public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Dados.getPessoas();

        System.out.println("Listar todas as pessoas:");
        pessoas.forEach(System.out::println);

        System.out.println("\nListar as 10 primeiras pessoas:");
        pessoas.stream()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\nListar as pessoas que são do Brasil:");
        pessoas.stream()
                .filter(p -> p.getPais().equalsIgnoreCase("Brazil"))
                .forEach(System.out::println);

        System.out.println("\nListar as pessoas do Brasil com o nome em Uppercase e suas idades:");
        pessoas.stream()
                .filter(p -> p.getPais().equalsIgnoreCase("Brazil"))
                .forEach(p -> System.out.println(p.getNome().toUpperCase() + " - " + p.getIdade()));

        System.out.println("\nListar as pessoas que são do Brasil, em ordem de nome:");
        pessoas.stream()
                .filter(p -> p.getPais().equalsIgnoreCase("Brazil"))
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);

        System.out.println("\nListar as pessoas que são do Brasil, em ordem de idade:");
        pessoas.stream()
                .filter(p -> p.getPais().equalsIgnoreCase("Brazil"))
                .sorted(Comparator.comparingInt(Pessoa::getIdade))
                .forEach(System.out::println);

        System.out.println("\nContar quantas pessoas têm mais de 45 anos:");
        long count = pessoas.stream()
                .filter(p -> p.getIdade() > 45)
                .count();
        System.out.println(count);

        System.out.println("\nCalcular a média de idade das pessoas:");
        double average = pessoas.stream()
                .mapToInt(Pessoa::getIdade)
                .average()
                .orElse(0);
        System.out.println(average);

        
        }
    }




