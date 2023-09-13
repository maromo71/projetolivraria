public class Dvd extends Produto{
    private String diretor;
    private int duracao;
    private String censura;

    public Dvd(int id, String descricao, String genero, double preco, String diretor, int duracao, String censura) {
        super(id, descricao, genero, preco);
        this.diretor = diretor;
        this.duracao = duracao;
        this.censura = censura;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Dvd{" +
                "diretor='" + diretor + '\'' +
                ", duracao=" + duracao +
                ", censura='" + censura + '\'' +
                '}';
    }

    @Override
    public void calcularPrecoVenda() {
        setPreco(getPreco() * 1.20);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getCensura() {
        return censura;
    }

    public void setCensura(String censura) {
        this.censura = censura;
    }
}
