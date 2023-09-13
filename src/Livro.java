public class Livro extends Produto{
    private String autor;
    private String editora;
    private String edicao;

    public Livro(int id, String descricao, String genero, double preco, String autor, String editora, String edicao) {
        super(id, descricao, genero, preco);
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Livro{" +
                "autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", edicao='" + edicao + '\'' +
                '}';
    }

    @Override
    public void calcularPrecoVenda() {
        setPreco(getPreco() * 1.15);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
}
