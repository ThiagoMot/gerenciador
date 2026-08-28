import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    // CREATE - Criar
    public void adicionar(String nome, double preco) {
        Produto produto = new Produto(proximoId++, nome, preco);
        produtos.add(produto);
        System.out.println("✅ Produto cadastrado com sucesso!");
    }

    // READ - Listar Todos
    public List<Produto> listarTodos() {
        return produtos;
    }

    // READ - Buscar por ID
    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // UPDATE - Atualizar
    public boolean atualizar(int id, String novoNome, double novoPreco) {
        Produto produto = buscarPorId(id);
        if (produto != null) {
            produto.setNome(novoNome);
            produto.setPreco(novoPreco);
            return true;
        }
        return false;
    }

    // DELETE - Deletar
    public boolean deletar(int id) {
        Produto produto = buscarPorId(id);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }
}