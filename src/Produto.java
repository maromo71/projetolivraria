public abstract class Produto {
    private int id;
    private String descricao;
    private String genero;
    private int estoqueDisponivel;
    private double preco;

    public Produto(int id, String descricao, String genero, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.genero = genero;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", genero='" + genero + '\'' +
                ", estoqueDisponivel=" + estoqueDisponivel +
                ", preco=" + preco +
                '}';
    }

    public abstract void calcularPrecoVenda();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public void setEstoqueDisponivel(int estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
