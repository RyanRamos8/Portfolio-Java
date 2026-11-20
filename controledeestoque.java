import java.util.*;

public class ControleDeEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> estoque = new HashMap<>();
        int opcao1 = 0;

        while (opcao1 != 6) {
            System.out.println("\n==== Menu ===");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar um produto e sua quantidade");
            System.out.println("2 - Consultar produto e sua quantidade");
            System.out.println("3 - Atualizar a quantidade de um produto");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Listar produtos cadastrados");
            System.out.println("6 - Sair");

            opcao1 = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao1) {
                case 1:
                    System.out.println("Digite o nome do produto que deseja cadastrar:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a quantidade:");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();

                    estoque.put(nome, qtd);
                    System.out.println("Produto Adicionado!");
                    System.out.println("Produto: " + nome + " | Quantidade: " + qtd);
                    break;

                case 2:
                    System.out.println("Digite o nome do produto para consultar:");
                    String consulta = scanner.nextLine();

                    if (estoque.containsKey(consulta)) {
                        int quantidade = estoque.get(consulta);
                        System.out.println("Produto: " + consulta + " | Quantidade: " + quantidade);
                    } else {
                        System.out.println("Produto não disponível no estoque.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o produto que você deseja atualizar a quantidade:");
                    String nome1 = scanner.nextLine();

                    if (estoque.containsKey(nome1)) {
                        System.out.println("Digite a nova quantidade:");
                        int qtd1 = scanner.nextInt();
                        scanner.nextLine();

                        estoque.put(nome1, qtd1);
                        System.out.println("Quantidade atualizada com sucesso!");
                    } else {
                        System.out.println("Erro: Produto não encontrado no estoque.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do produto que deseja remover:");
                    String removerNome = scanner.nextLine();

                    if (estoque.remove(removerNome) != null) {
                        System.out.println("Produto removido: " + removerNome);
                        System.out.println("Estoque atualizado: " + estoque);
                    } else {
                        System.out.println("Erro: O produto '" + removerNome + "' não foi encontrado no estoque.");
                    }
                    break;

                case 5:
                    if (estoque.isEmpty()) {
                        System.out.println("O estoque está vazio.");
                    } else {
                        System.out.println("--- Produtos Cadastrados ---");
                        estoque.forEach((produto, quantidade) ->
                                System.out.println("Produto: " + produto + " | Quantidade: " + quantidade)
                        );
                    }
                    break;

                case 6:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Digite um número de 1 a 6.");
                    break;
            }
        }
        scanner.close();
    }
}
