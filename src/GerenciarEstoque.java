import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEstoque {
    List<Produto> listProduto = new ArrayList<>();
    Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {
        GerenciarEstoque ge = new GerenciarEstoque();
        int opcao = 0;
        do{
            System.out.println("Menu Principal");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Vender Produto");
            System.out.println("3. Comprar Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Consultar Estoque");
            System.out.println("9. Sair");
            System.out.println("Escolha sua opção: ");
            opcao = Integer.parseInt(ge.sc.nextLine());
            switch (opcao){
                case 1:
                    ge.execCadastrar();
                    break;
                case 2:
                    ge.execVender();
                    break;
                case 3:
                    ge.execComprar();
                    break;
                case 4:
                    ge.execListarProdutos();
                    break;
                case 5:
                    ge.execConsultarEstoque();
                    break;
                case 9:
                    System.out.println("Fim do Programa");
                    break;
                default:
                    System.out.println("Opção inválidad");
            }
        }while(opcao!=9);
    }

    private void execConsultarEstoque() {
        System.out.println("Digite o id do produto a consultar");
        int idProd = Integer.parseInt(sc.nextLine());
        for (Produto p : listProduto){
            if(p.getId()==idProd){
                System.out.println("DADOS DO PRODUTO");
                System.out.println(p.toString());
                System.out.println("----------------");
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    private void execListarProdutos() {

        for (Produto p : listProduto){
            System.out.println("-----------------------");
            System.out.println(p.toString());
            System.out.println("-----------------------");
        }
    }

    private void execComprar() {
        System.out.println("Digite o id do produto a vender");
        int idProd = Integer.parseInt(sc.nextLine());
        for (Produto p : listProduto){
            if(p.getId()==idProd){
                System.out.println("Efetuando a compra");
                System.out.println("Digite a quantidade a ser comprada: ");
                int qtd = Integer.parseInt(sc.nextLine());
                comprar(p, qtd);
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    private void execVender() {
        System.out.println("Digite o id do produto a vender");
        int idProd = Integer.parseInt(sc.nextLine());
        for (Produto p : listProduto){
            if(p.getId()==idProd){
                System.out.println("Efetuando a venda");
                System.out.println("Digite a quantidade a ser vendida: ");
                int qtd = Integer.parseInt(sc.nextLine());
                vender(p, qtd);
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    private void execCadastrar() {
        System.out.println("Cadastrando um produto");
        int tipo;
        System.out.println("Tipo de Produto:");
        System.out.println("Digite 1 para livro, ou 2 para dvd: ");
        tipo = Integer.parseInt(sc.nextLine());
        //geral
        System.out.println("Digite o id do produto: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Digite a descrição do produto: ");
        String descricao = sc.nextLine();
        System.out.println("Digite o genero do produto: ");
        String genero = sc.nextLine();
        System.out.println("Digite o preco do produto: ");
        double preco = Double.parseDouble(sc.nextLine());
        Produto produto = null;
        if(tipo==1){
            System.out.println("Digite o autor do livro: ");
            String autor = sc.nextLine();
            System.out.println("Digite a editora do livro: ");
            String editora = sc.nextLine();
            System.out.println("Digite a edição do livro: ");
            String edicao = sc.nextLine();
            produto = new Livro(id, descricao, genero, preco, autor, editora, edicao);
            listProduto.add(produto);
            System.out.println("Livro cadastrado com sucesso");
        }else if(tipo==2){
            System.out.println("Digite o diretor do dvd: ");
            String diretor = sc.nextLine();
            System.out.println("Digite a duracao do dvd: ");
            int duracao = Integer.parseInt(sc.nextLine());
            System.out.println("Digite a censura do dvd: ");
            String censura = sc.nextLine();
            produto = new Dvd(id, descricao,genero,preco,diretor,duracao,censura);
            listProduto.add(produto);
            System.out.println("DVD cadastrado com sucesso");
        }else{
            System.out.println("Tipo invalido de produto");
        }
    }

    public void vender(Produto produto, int qtd){
        for(Produto p : listProduto){
            if(produto.getId() == p.getId()){
                if(p.getEstoqueDisponivel() >= qtd){
                    p.setEstoqueDisponivel(p.getEstoqueDisponivel() - qtd);
                    System.out.println("Produto vendido");
                    return;
                }else{
                    System.out.println("Quantidade indisponivel");
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado");
    }
    public void comprar(Produto produto, int qtd){
        for(Produto p : listProduto){
            if(produto.getId() == p.getId()){
                if(qtd > 0){
                    p.setEstoqueDisponivel(p.getEstoqueDisponivel() + qtd);
                    System.out.println("Produto comprado");
                    return;
                }else{
                    System.out.println("Quantidade inválida");
                }
            }
        }
        System.out.println("Produto não encontrado");
    }
}