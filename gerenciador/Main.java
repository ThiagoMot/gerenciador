import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== GERENCIADOR DE PRODUTOS ===");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Atualizar produto");
            System.out.println("4. Remover produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: R$ ");
                    double preco = scanner.nextDouble();
                    dao.adicionar(nome, preco);
                    break;

                case 2:
                    System.out.println("\n--- Lista de Produtos ---");
                    var lista = dao.listarTodos();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        lista.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("ID do produto a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (dao.buscarPorId(idAtualizar) != null) {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo preço: R$ ");
                        double novoPreco = scanner.nextDouble();
                        
                        if (dao.atualizar(idAtualizar, novoNome, novoPreco)) {
                            System.out.println("✅ Produto atualizado!");
                        }
                    } else {
                        System.out.println("❌ Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("ID do produto a remover: ");
                    int idDeletar = scanner.nextInt();
                    if (dao.deletar(idDeletar)) {
                        System.out.println("✅ Produto removido!");
                    } else {
                        System.out.println("❌ Produto não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}