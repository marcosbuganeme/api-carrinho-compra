package api.carrinho.compra;

public class Pessoa {

    public enum Maioridade {
        MENOR,
        MAIOR;
    }

    private int idade;
    private String nome;
    private Maioridade maioridade;

    public Pessoa(int idade, String nome, Maioridade maioridade) {
        this.idade = idade;
        this.nome = nome;
        this.maioridade = maioridade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Maioridade getMaioridade() {
        return maioridade;
    }

    public void setMaioridade(Maioridade maioridade) {
        this.maioridade = maioridade;
    }

    @Override
    public String toString() {
        return "Pessoa [idade=" + idade + ", nome=" + nome + "]";
    }
}